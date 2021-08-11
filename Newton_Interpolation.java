/*
Newton Divided Difference Interpolation Application in
Celsius to Fahrenheit conversion program
by Chaterina M. Fransisca
*/

public class Newton_Interpolation {
    public static double newton(double[] x1, double[][] y1, double x, int n){
        double res = y1[0][0];

        //construct the divided difference table
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n-i; j++)
                y1[j][i] = (y1[j][i-1] - y1[j+1][i-1]) / (x1[j] - x1[i+j]);
        }

        //applying formula newton interpolation
        for (int i = 1; i < n; i++){
            float temp = 1;
            for (int j = 0; j < i; j++)
                temp *= (x - x1[j]); //find the product term
            res += (temp * y1[0][i]);//newton's formula
        }
        return res;
    }
    public static double fahrenheit(double x){
        double F = (x * 9.0/5.0) + 32;
        return F;
    }

    public static void main (String [] args){
        int n = 9;//define the polynomial degree
        double x1[] = {10,20,30,40,50,60,70,80,90,100}; //data in celsius
        /* y[][] is used for divided difference
         table where y[][0] is used for input */
        double y1[][] = new double[10][10]; //data in fahrenheit
        y1[0][0] = 50;
        y1[1][0] = 68;
        y1[2][0] = 86;
        y1[3][0] = 104;
        y1[4][0] = 122;
        y1[5][0] = 140;
        y1[6][0] = 158;
        y1[7][0] = 176;
        y1[8][0] = 194;
        y1[9][0] = 212;

        double x = 18.18; //value from the required point
        double Newton = newton(x1, y1, x, n);
        System.out.println(x + " Celsius equals to "+ Newton + " Fahrenheit");
        double F = fahrenheit(x);
        System.out.println("Error value = " + (Math.abs(Newton - F)));
    }
}
