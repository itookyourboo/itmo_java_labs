package client.util;

import common.exceptions.IncorrectInputInScriptException;
import common.exceptions.MustBeNotEmptyException;
import common.exceptions.NotInBoundsException;
import common.model.Coordinates;
import common.model.FormOfEducation;
import common.model.Location;
import common.model.Person;

import java.io.Console;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interactor {
    private static final int MIN_X = -512;
    private static final int MIN_WEIGHT = 0;
    private static final int MIN_PASSPORT_ID_LENGTH = 4;
    private static final int MAX_LOCATION_NAME_LENGTH = 272;
    private static final int MIN_STUDENTS_COUNT = 0;
    private static final int MIN_EXPELLED_STUDENTS = 0;
    private static final int MIN_SHOULD_BE_EXPELLED = 0;
    private static Pattern patternNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
    private static Pattern patternUsername = Pattern.compile("[_0-9A-Za-z]{3,12}");
    private static Pattern patternPassword = Pattern.compile("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[_0-9a-zA-Z!@#$%^&*]{6,30}");

    static boolean fileMode = false;

    public static String askUsername(Scanner scanner) {
        String username;
        while (true) {
            System.out.println("??????? ??? ????????????:");
            username = scanner.nextLine();
            if (patternUsername.matcher(username).matches())
                return username;
            printError("??? ???????????? - ?? 3 ?? 12 ???????? (_0-9a-Z).");
        }
    }

    public static String askPassword(Scanner scanner) {
        String password;
        Console console = System.console();
        while (true) {
            System.out.println("??????? ??????:");
            if (console != null) {
                char[] symbols = console.readPassword();
                if (symbols == null) continue;
                password = String.valueOf(symbols);
            } else password = scanner.nextLine();
            if (patternPassword.matcher(password).matches())
                return password;
            printError("?????? - ?? 6 ?? 30 ???????? (???? ?? 1 ?????, 1 ????????? ? 1 ???????? ????????? ?????, _0-9a-Z!@#$%^&*).");
        }
    }

    /**
     * Asks a user the studyGroup's name.
     *
     * @param inputTitle title of input.
     * @param minLength  min length of string
     * @param maxLength  max length of string
     * @return name
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public static String askName(Scanner scanner, String inputTitle, int minLength, int maxLength) throws IncorrectInputInScriptException {
        String name;
        while (true) {
            try {
                System.out.println(inputTitle);
                displayInput();
                name = scanner.nextLine().trim();
                if (fileMode) System.out.println(name);
                if (name.equals("")) throw new MustBeNotEmptyException();
                if (name.length() <= minLength) throw new NotInBoundsException();
                if (name.length() >= maxLength) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("??? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (MustBeNotEmptyException exception) {
                printError("??? ?? ????? ???? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            } catch (NotInBoundsException e) {
                printError(String.format("????? ?????? ?? ?????? ? ???????? (%d; %d)", minLength, maxLength));
            }
        }
        return name;
    }

    /**
     * Asks a user the studyGroup's X coordinate.
     *
     * @param withLimit set bounds for X
     * @return studyGroup's X coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public static int askX(Scanner scanner, boolean withLimit) throws IncorrectInputInScriptException {
        String strX = "";
        int x;
        while (true) {
            try {
                if (withLimit)
                    System.out.println("??????? ?????????? X > " + MIN_X + ":");
                else
                    System.out.println("??????? ?????????? X:");
                displayInput();
                strX = scanner.nextLine().trim();
                if (fileMode) System.out.println(strX);
                x = Integer.parseInt(strX);
                if (withLimit && x <= MIN_X) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("?????????? X ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInBoundsException exception) {
                printError("?????????? X ?????? ???? ? ????????? (" + (withLimit ? MIN_X : Integer.MIN_VALUE)
                        + ";" + Integer.MAX_VALUE + ")!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strX).matches())
                    printError("?????????? X ?????? ???? ? ????????? (" + (withLimit ? MIN_X : Integer.MIN_VALUE)
                            + ";" + Integer.MAX_VALUE + ")!");
                else
                    printError("?????????? X ?????? ???? ???????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            }
        }
        return x;
    }

    /**
     * Asks a user the studyGroup's Y coordinate.
     *
     * @return StudyGroup's Y coordinate.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public static long askY(Scanner scanner) throws IncorrectInputInScriptException {
        String strY = "";
        long y;
        while (true) {
            try {
                System.out.println("??????? ?????????? Y:");
                displayInput();
                strY = scanner.nextLine().trim();
                if (fileMode) System.out.println(strY);
                y = Long.parseLong(strY);
                break;
            } catch (NoSuchElementException exception) {
                printError("?????????? Y ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strY).matches())
                    printError("?????????? Y ?????? ???? ? ????????? (" + Long.MIN_VALUE
                            + ";" + Long.MAX_VALUE + ")!");
                else
                    printError("?????????? Y ?????? ???? ???????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            }
        }
        return y;
    }

    /**
     * Asks a user the studyGroup's coordinates.
     *
     * @return StudyGroup's coordinates.
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public static Coordinates askCoordinates(Scanner scanner) throws IncorrectInputInScriptException {
        int x = askX(scanner, true);
        long y = askY(scanner);
        return new Coordinates(x, y);
    }

    /**
     * Asks a user the studyGroup's form of education
     *
     * @return StudyGroup's form of education
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static FormOfEducation askFormOfEducation(Scanner scanner) throws IncorrectInputInScriptException {
        String strFormOfEducation;
        FormOfEducation formOfEducation;
        while (true) {
            try {
                System.out.println("?????? ???? ???????? - " + FormOfEducation.nameList());
                System.out.println("??????? ????? ????????:");
                displayInput();
                strFormOfEducation = scanner.nextLine().trim();
                if (fileMode) System.out.println(strFormOfEducation);
                formOfEducation = FormOfEducation.valueOf(strFormOfEducation.toUpperCase());
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ???????? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalArgumentException exception) {
                printError("????? ???????? ??? ? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            }
        }
        return formOfEducation;
    }

    /**
     * Asks a user the studyGroup's student count
     *
     * @return StudyGroup's students count
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static Integer askStudentsCount(Scanner scanner) throws IncorrectInputInScriptException {
        String strStudentsCount = "";
        int studentsCount;
        while (true) {
            try {
                System.out.println("??????? ?????????? ?????????:");
                displayInput();
                strStudentsCount = scanner.nextLine().trim();
                if (fileMode) System.out.println(strStudentsCount);
                studentsCount = Integer.parseInt(strStudentsCount);
                if (studentsCount <= MIN_STUDENTS_COUNT) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strStudentsCount).matches())
                    printError("????? ?????? ???? ? ????????? (" + MIN_STUDENTS_COUNT + ";" + Integer.MAX_VALUE + ")!");
                else
                    printError("?????????? ????????? ?????? ???? ???????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            } catch (NotInBoundsException e) {
                printError("????? ?????? ???? ?????? " + MIN_STUDENTS_COUNT);
            }
        }
        return studentsCount;
    }

    /**
     * Asks a user the studyGroup's expelled students count
     *
     * @return StudyGroup's count of expelled students
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static Long askExpelledStudents(Scanner scanner) throws IncorrectInputInScriptException {
        String strExpelledStudents = "";
        long expelledStudents;
        while (true) {
            try {
                System.out.println("??????? ?????????? ??????????? ?????????:");
                displayInput();
                strExpelledStudents = scanner.nextLine().trim();
                if (fileMode) System.out.println(strExpelledStudents);
                expelledStudents = Integer.parseInt(strExpelledStudents);
                if (expelledStudents <= MIN_EXPELLED_STUDENTS) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strExpelledStudents).matches())
                    printError("????? ?????? ???? ? ????????? (" + MIN_EXPELLED_STUDENTS + ";" + Long.MAX_VALUE + ")!");
                else
                    printError("?????????? ????????? ?????? ???? ???????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            } catch (NotInBoundsException e) {
                printError("????? ?????? ???? ?????? " + MIN_EXPELLED_STUDENTS);
            }
        }
        return expelledStudents;
    }

    /**
     * Asks a user the studyGroup's admin
     *
     * @return Person [Admin]
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static Person askGroupAdmin(Scanner scanner) throws IncorrectInputInScriptException {
        String name = askAdminName(scanner);
        long weight = askWeight(scanner);
        String passportID = askPassportID(scanner);
        Location location = askLocation(scanner);
        return new Person(name, weight, passportID, location);
    }

    /**
     * Asks a user the studyGroup's count of should be expelled students
     *
     * @return StudyGroup's count of should be expelled students
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static Integer askShouldBeExpelled(Scanner scanner) throws IncorrectInputInScriptException {
        String strShouldBeExpelled = "";
        int shouldBeExpelled;
        while (true) {
            try {
                System.out.println("??????? ?????????? ?????????, ??????? ?????? ???? ?????????:");
                displayInput();
                strShouldBeExpelled = scanner.nextLine().trim();
                if (fileMode) System.out.println(strShouldBeExpelled);
                shouldBeExpelled = Integer.parseInt(strShouldBeExpelled);
                if (shouldBeExpelled <= MIN_SHOULD_BE_EXPELLED) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strShouldBeExpelled).matches())
                    printError("????? ?????? ???? ? ????????? (" + MIN_SHOULD_BE_EXPELLED + ";" + Integer.MAX_VALUE + ")!");
                else
                    printError("?????????? ????????? ?????? ???? ???????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            } catch (NotInBoundsException e) {
                printError("????? ?????? ???? ?????? " + MIN_SHOULD_BE_EXPELLED);
            }
        }
        return shouldBeExpelled;
    }

    /**
     * Asks a user the admin's name
     *
     * @return Person's name
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static String askAdminName(Scanner scanner) throws IncorrectInputInScriptException {
        return askName(scanner, "??????? ??? ?????? ??????:", 0, Integer.MAX_VALUE);
    }

    /**
     * Asks a user the location's name
     *
     * @return Location's name
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static String askLocationName(Scanner scanner) throws IncorrectInputInScriptException {
        return askName(scanner, "??????? ??? ???????:", 0, MAX_LOCATION_NAME_LENGTH);
    }

    /**
     * Asks a user the studyGroup's name
     *
     * @return StudyGroup's name
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static String askGroupName(Scanner scanner) throws IncorrectInputInScriptException {
        return askName(scanner, "??????? ??? ??????:", 0, Integer.MAX_VALUE);
    }

    /**
     * Asks a user the person's weight
     *
     * @return Person's weight
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static long askWeight(Scanner scanner) throws IncorrectInputInScriptException {
        String strWeight = "";
        long weight;
        while (true) {
            try {
                System.out.println("??????? ??? ????????:");
                displayInput();
                strWeight = scanner.nextLine().trim();
                if (fileMode) System.out.println(strWeight);
                weight = Integer.parseInt(strWeight);
                if (weight <= MIN_WEIGHT) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ?? ??????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NumberFormatException exception) {
                if (patternNumber.matcher(strWeight).matches())
                    printError("????? ?????? ???? ? ????????? (" + MIN_WEIGHT + ";" + Long.MAX_VALUE + ")!");
                else
                    printError("??? ?????? ???? ??????????? ??????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NullPointerException | IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            } catch (NotInBoundsException e) {
                printError("????? ?????? ???? ?????? " + MIN_WEIGHT);
            }
        }
        return weight;
    }

    /**
     * Asks a user the admin's passport ID
     *
     * @return Person's passportID
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static String askPassportID(Scanner scanner) throws IncorrectInputInScriptException {
        return askName(scanner, "??????? ID ????????:", 4, Integer.MAX_VALUE);
    }

    /**
     * Asks a user the admin's location
     *
     * @return Person's location
     * @throws IncorrectInputInScriptException if script is running and something goes wrong.
     */
    public static Location askLocation(Scanner scanner) throws IncorrectInputInScriptException {
        int x = askX(scanner, false);
        int y = (int) askY(scanner);
        String name = askLocationName(scanner);
        return new Location(x, y, name);
    }

    /**
     * Asks a user a question.
     *
     * @param question A question.
     * @return Answer (true/false).
     * @throws IncorrectInputInScriptException If script is running and something goes wrong.
     */
    public static boolean askQuestion(Scanner scanner, String question) throws IncorrectInputInScriptException {
        String finalQuestion = question + " (+/-):";
        String answer;
        while (true) {
            try {
                System.out.println(finalQuestion);
                displayInput();
                answer = scanner.nextLine().trim();
                if (fileMode) System.out.println(answer);
                if (!answer.equals("+") && !answer.equals("-")) throw new NotInBoundsException();
                break;
            } catch (NoSuchElementException exception) {
                printError("????? ?? ?????????!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (NotInBoundsException exception) {
                printError("????? ?????? ???? ??????????? ??????? '+' ??? '-'!");
                if (fileMode) throw new IncorrectInputInScriptException();
            } catch (IllegalStateException exception) {
                printError("?????????????? ??????!");
                System.exit(0);
            }
        }
        return answer.equals("+");
    }

    public static void println(String str) {
        System.out.println(str);
    }
    public static void printError(String error) {
        System.out.println("??????! " + error);
    }
    public static void displayInput() {
        System.out.print("> ");
    }

    public static void setOutputStream(OutputStream outputStream) {
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        System.setErr(printStream);
    }

    public static void setDefaultOutputStream() {
        System.setOut(System.out);
        System.setErr(System.err);
    }
}