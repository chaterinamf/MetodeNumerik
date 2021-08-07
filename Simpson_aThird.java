public class Simpson_aThird {
    //declaring the function
    public static double func(double x){
        return (x * x * x) + (x * x) + 10;
    }

    //exact value of the integral
    public static double integral(double x){
        return ((x * x * x * x)/4) + ((x * x * x)/3) + (10*x);
    }

    public static double simpson(double a, double b, int n) {
        double[] xvals = new double[n];

        double h = (b - a) / (n); //h = delta (grid spacing)
        double sum = func(a) + func(b); //sum the first and the last terms of Simpson 1/3 formula

        // 4/3 terms (odd number)
        for (int i = 1; i < n; i+=2) {
            xvals[i] = a + i*h;
            sum += 4 * func(xvals[i]);
        }

        // 2/3 terms (even number)
        for (int i = 2; i < n-1; i+=2) {
            xvals[i] = a + i*h;
            sum += 2 * func(xvals[i]);
        }
        sum *= h/3;
        return sum;
    }
    public static void main(String[] args) {
        double a = 0; //define left end
        double b = 5; //define right end
        int n = 10; //total divider (number of grids)
        double integral = integral(b) - integral(a);

        System.out.println("Definite Integral: " + integral);
        System.out.println("The value of the integral with Trapezoidal Rule: " + simpson(a,b,n));
        System.out.println("Error value: " + Math.abs(simpson(a,b,n) - integral));

    }
}
