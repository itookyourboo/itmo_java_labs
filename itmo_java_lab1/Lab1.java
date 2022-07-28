public class Main {

    private static final int MIN = -10, MAX = 6, ROWS = 7, COLS = 17;

    public static void main(String[] args) {
        int[] d = new int[ROWS];
        fillD(d);
        
        float[] x = new float[COLS];
        fillX(x);
        
        double[][] f = new double[ROWS][COLS];
        fillF(f, d, x);

        printMatrix(f);
    }

    private static void fillD(int[] d) {
        for (int i = 0; i < ROWS; i++)
            d[i] = 2 * i + 3;
    }

    private static void fillX(float[] x) {
        for (int i = 0; i < x.length; i++)
            x[i] = randomFloat(MIN, MAX);
    }

    private static void fillF(double[][] f, int[] d, float[] x) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if (d[i] == 3)
                    f[i][j] = firstFormula(x[j]);
                else if (d[i] == 7 || d[i] == 11 || d[i] == 13)
                    f[i][j] = secondFormula(x[j]);
                else
                    f[i][j] = thirdFormula(x[j]);
            }
        }
    }

    private static double firstFormula(float x) {
        return Math.sin(Math.atan(1 / Math.exp(Math.abs(x))));
    }

    private static double secondFormula(float x) {
        return Math.atan(Math.sin(Math.asin(Math.sin(x))));
    }

    private static double thirdFormula(float x) {
        return Math.pow(
                Math.sin(Math.pow(Math.pow(x, 1f / 3), (Math.pow((x / 2f + 0.125), 2) - 1) / 0.5f)),
                Math.atan(Math.pow((x - 2) / 16f, 2)) * (Math.pow(
                        Math.atan(1 / Math.exp(Math.abs(x))),
                        Math.pow(x / 12f, 3) / (Math.pow(0.25 - Math.pow(x, 1f / 3),
                                (Math.pow(x + 1f / 3, x) + 1) / (Math.log(Math.abs(x)))))) - 1));
    }

    private static void printMatrix(double[][] f) {
        for (double[] doubles : f) {
            for (double aDouble : doubles) {
                System.out.printf("%6.4f\t", aDouble);
            }
            System.out.println();
        }
    }

    private static float randomFloat(final int min, final int max) {
        return (float) (Math.random() * (max - min) + min);
    }
}
