public class Trapezoidal {
    //declaring the function
    public static double func(double x){
        return (x * x * x) + (x * x) + 10;
    }

    //exact value of the integral
    public static double integral(double x){
        return ((x * x * x * x)/4) + ((x * x * x)/3) + (10*x);
    }

    public static double trapezoid(double a, double b, int n) {
        double[] xvals = new double[n];

        double h = (b - a) / n; //h = delta (grid spacing)
        double sum = func(a) + func(b); //sum the first and the last terms of trapezoidal rule formula

        for (int i = 0; i < n-1; i++) {
            xvals[i] = a + (i+1)*h;
            sum += 2 * func(xvals[i]);
        }
        sum *= h/2;
        return sum;
    }
    public static void main(String[] args) {
        double a = 0; //define left end
        double b = 5; //define right end
        int n = 10; //total divider (number of grids)
        double integral = integral(b) - integral(a);

        System.out.println("Definite Integral: " + integral);
        System.out.println("The value of the integral with Trapezoidal Rule: " + trapezoid(a,b,n));
        System.out.println("Error value: " + Math.abs(trapezoid(a,b,n) - integral));

    }
}
