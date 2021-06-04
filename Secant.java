public class Secant {
    public static float fungsi(float x){
        //f(x) = 8x^3 - 3*8x^2 + 8*8x - 4
        //f(x) = 8x^3 - 24x^2 + 64x - 4  (dibagi 4 untuk disederhanakan)
        //f(x) = 2x^3 - 6x^2 + 16x - 1
        float y;
        y = 2*(x * x * x) - 6*(x * x) + 16*x - 1;
        return y;
    }

    public static void main(String[] args){
        //Definisikan torelansi error (e) dan iterasi maksimum (n)
        int  i = 1, n = 5;
        float e = 0;

        //menentukan pendeketan awal
        float x0 = (float) 0.4;
        float x1 = (float) 0.5;
        System.out.println("Pendekatan awal x0 = "+ x0 + " dan x1 = "+ x1);

        float y0 = fungsi(x0);
        float y1 = fungsi(x1);
        float xn = 999;
        float fx = 999;

        System.out.println("   x(n-2)   |   x(n-1)   |    x(n)    |    f(x)");

        while (i <= n && Math.abs(fx) > e){
            y0 = fungsi(x0);
            y1 = fungsi(x1);
            xn = x1 - y1 * ((x1 - x0)/(y1 - y0));
            fx = fungsi(xn);

            System.out.println(i+") "+x0+" | "+x1+" | "+xn+" | "+fx);

            x0 = x1;
            x1 = xn;

            i++;
        }
        System.out.printf("Akar persamaan      : "+"%.3f", xn);
        System.out.printf("\nOptimal return      : "+"%.3f", fx);
        System.out.printf("\nNilai error         : "+"%.3f", Math.abs(fx));
    }
}
