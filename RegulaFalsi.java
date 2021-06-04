/*
Chaterina Maria Fransisca
197064516157
B = 7 + 1 = 8
 */

public class RegulaFalsi {
    public static float fungsi(float x){
        //f(x) = 8x^3 - 3*8x^2 + 8*8x - 4
        //f(x) = 8x^3 - 24x^2 + 64x - 4  (dibagi 4 untuk disederhanakan)
        //f(x) = 2x^3 - 6x^2 + 16x - 1
        float y;
        y = 2*(x * x * x) - 6*(x * x) + 16*x - 1;
        return y;
    }

    public static void main(String[] args){
        float a = (float) -0.4; //batas bawah
        float b = (float) -0.2; //batas atas

        //Tentukan toleransi error (e) dan iterasi maksimum (n)
        int n = 5, i = 1;
        float e = 0;

        float fa = fungsi(a);
        float fb = fungsi(b);
        float c = 999;
        float fc = 999;

        System.out.println("     a     |     b     |     c     |     fa     |     fb     |     fc ");
        while (i <= n && Math.abs(fc) > e){
            fa = fungsi(a);
            fb = fungsi(b);
            c = ((fb * a) - (fa * b)) / (fb - fa);
            fc = fungsi(c);

            System.out.println(i+") "+a+" | "+b+" | "+c+" | "+fa+" | "+fb+" | "+fc);

            //pengecekan
            if ((fa * fc) < 0){
                b = c;
            } else {
                a = c;
            }
            i++;
        }
        System.out.printf("Akar persamaan      : " + "%.3f", c);
        System.out.printf("\nOptimal return      : "+ "%.3f", fc);
        System.out.printf("\nNilai error         : "+ "%.3f", Math.abs(fc));
    }
}
