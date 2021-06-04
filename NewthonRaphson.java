public class NewthonRaphson {
    public static float fungsi(float x){
        //f(x) = 8x^3 - 3*8x^2 + 8*8x - 4
        //f(x) = 8x^3 - 24x^2 + 64x - 4  (dibagi 4 untuk disederhanakan)
        //f(x) = 2x^3 - 6x^2 + 16x - 1
        float y;
        y = 2*(x * x * x) - 6*(x * x) + 16*x - 1;
        return y;
    }

    public static float turunan(float x){
        //turunun f(x) = 6x^2 - 12x + 16
        float y = 6*(x*x) - 12*x + 16;
        return y;
    }
    public static void main(String[] args){
        //menentukan toleransi error dan iterasi maksimum
        int  i = 1;
        int n = 5;
        float error = 0;

        //menentukan pendeketan awal
        float x0 = (float) 1.1;
        float fx = fungsi(x0);
        float tfx = turunan(x0);
        float x1 = x0 - (fx/tfx);
        float selisih = x1 - x0;

        System.out.println("     x     |     f(x)     |     f'(x)     |     error/selisish");

        while (i <= n || Math.abs(fx) > error){
            x1 = x0;
            fx = fungsi(x0);
            tfx = turunan(x0);
            x0 = x1 - (fx/tfx);
            selisih = x1-x0;
            System.out.println(i+") "+x1+" | "+fx+" | "+tfx+" | "+selisih);

            i++;
        }
        System.out.printf("Akar persamaan      : "+ "%.3f", x1);
        System.out.printf("\nOptimal return      : "+ "%.3f", selisih);
        System.out.printf("\nNilai error         : "+ "%.3f", Math.abs(selisih));
    }
}
