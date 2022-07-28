package com.proglab4;

import com.proglab4.entity.*;
import com.proglab4.exceptions.CarlsonIsAngryException;
import com.proglab4.exceptions.StampIsBeautifulException;
import com.proglab4.impl.SummerListener;
import com.proglab4.misc.Album;
import com.proglab4.misc.Buzz;
import com.proglab4.misc.Lessons;
import com.proglab4.misc.Stamp;
import com.proglab4.place.*;

public class Main {

    public static void main(String[] args) {
        runIncredibleStory();
    }

    private static void runIncredibleStory() {
        Baby baby = new Baby();
        Roof roof = new Roof(baby);

        Carlson carlson = new Carlson();
        carlson.setBaby(baby);
        carlson.setOnPlaceChangedListener(baby);
        carlson.setPlace(roof);

        carlson.setPlace(null);

        Father father = new Father(baby);
        father.setRight(true);
        Mother mother = new Mother(baby);
        Bosse bosse = new Bosse();
        Betan betan = new Betan();
        Entity[] entities = new Entity[]{mother, bosse, betan};
        for (Entity entity : entities)
            System.out.printf("%s понял%s, что %s %sправ\n",
                    entity.getName(), entity.getSex() == Entity.Sex.FEMALE ? "а" : "",
                    father.getName(), father.isRight() ? "" : "не ");

        Entity babyCaresAbout = baby.caresAbout();
        if (babyCaresAbout == null)
            System.out.println(baby.getName() + " ни о чем не беспокоится");
        else
            System.out.println(baby.getName() + " беспокоится за " + babyCaresAbout.getName());

        Bimbo bimbo = new Bimbo();

        Grandmother grandmother = new Grandmother(baby);
        Village village = new Village();
        village.setOwner(grandmother);
        Village.Redneck redneck = village.new Redneck();

        Town town = new Town();

        SummerListener summerListener = new SummerListener() {
            @Override
            public void onSummerStarted() {
                System.out.println("Лето началось");
                baby.setPlace(village);
                System.out.println(baby.getName() + " уезжает в " + village.toString());
                bimbo.setPlace(village);
                System.out.println(bimbo.getName() + " уезжает в " + village.toString());
            }

            @Override
            public void onSummerGoing() {
                System.out.println("Лето идет");
                baby.play(redneck);
                Entity babyThinksAbout = baby.thinksAbout();
                if (babyThinksAbout == null)
                    System.out.println(baby.getName() + " не думает о " + carlson.getName());
                else
                    System.out.println(baby.getName() + " думает о " + babyThinksAbout.getName());
            }

            @Override
            public void onSummerEnded() {
                System.out.println("Лето закончилось");
                baby.stopPlaying();
                baby.setPlace(town);
                System.out.println(baby.getName() + " вернулся в " + town.getName());
            }
        };

        summerListener.onSummerStarted();
        summerListener.onSummerGoing();
        summerListener.onSummerEnded();

        Room room = new Room(baby);
        baby.run(room);

        if (!room.getWindow().isOpened())
            baby.openWindowInRoom(room);

        Entity babyThinksAbout = baby.thinksAbout();
        if (babyThinksAbout == null)
            System.out.printf("%s ни о чем не думал\n", baby.toString());
        else
            System.out.printf("%s думал о %s\n", baby.toString(), babyThinksAbout.toString());

        Entity babyCriesAbout = baby.criesAbout();
        if (babyCriesAbout == null)
            System.out.printf("%s не плакал\n", baby.toString());
        else
            System.out.printf("%s плакал из-за %s\n", baby.toString(), babyCriesAbout.toString());

        School school = new School();
        Lessons lessons = new Lessons();

        school.printInstance();
        lessons.printInstance();
        carlson.printInstance();

        if (baby.getPlace().equals(room))
            System.out.println(baby.getName() + " сидит в " + room.getName());

        Album album = new Album(1000);
        Stamp prettyStamp = new Stamp("Германия", "Красная Шапочка и Серый Волк");
        prettyStamp.setBeautiful(true);
        Stamp[] stamps = new Stamp[]{new Stamp(), new Stamp(), prettyStamp, new Stamp()};
        for (Stamp stamp : stamps) {
            try {
                album.glue(stamp);
                System.out.println(baby.getName() + " клеит " + stamp.toString());
            } catch (StampIsBeautifulException e) {
                System.out.println(baby.getName() + " наклеил " + album.countStamps() + " марок");
                System.out.println(e.toString());
                System.out.println(baby.getName() + " любит " + stamp.toString());
                break;
            }
        }

        Buzz bzzz = new Buzz(0.65f, 11.8f);
        System.out.println("Малыш слышит " + bzzz.toString());

        Buzz carlsonMotorsBuzz = carlson.getMotor().getBuzz();
        if (bzzz.isSimilar(carlsonMotorsBuzz))
            System.out.println(bzzz.toString() + " похоже на " + carlsonMotorsBuzz);

        carlson.setPlace(room);
        System.out.println(carlson.getName() + " влетает в комнату");
        baby.setHappy(true);
        carlson.setFlying(false);
        carlson.clickButton();

        try {
            baby.hug(carlson);
        } catch (CarlsonIsAngryException exception) {
            System.out.println(exception.toString());
            carlson.kick(baby);
        }
    }
}
