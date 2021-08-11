/*
Lagrange Interpolation Application in
Celsius to Fahrenheit conversion program
by Chaterina M. Fransisca
*/

public class Lagrange_Interpolation {
    public static double lagrange(double x1[], double y1[], double x, int n){
        double res = 0;

        //lagrange formula
        for (int i = 1; i <= n; i++){
            double temp = 1;
            for (int j = 1; j <= n; j++){
                if (i != j) temp *= (x - x1[j])/(x1[i] - x1[j]);//lagrange interpolation
            }
            temp *= y1[i];
            res += temp;//add temporary term to result
        }
        return res;
    }
    public static double fahrenheit(double x){
        double F = (x * 9.0/5.0) + 32;
        return F;
    }

    public static void main (String [] args){
        int n = 9; //define the polynomial degree
        double x1[] = {10,20,30,40,50,60,70,80,90,100}; //data in celsius
        double y1[] = {50,
                68,
                86,
                104,
                122,
                140,
                158,
                176,
                194,
                212,
        }; //data in fahrenheit
        double x = 18.18; //value from the required point
        double Lagrange = lagrange(x1, y1, x, n);
        System.out.println(x + " Celsius equals to "+ Lagrange +  " Fahrenheit");
        double F = fahrenheit(x);
        System.out.println("Error value = " + (Math.abs(Lagrange - F)));
    }
}
