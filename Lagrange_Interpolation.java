public class Lagrange_Interpolation {
    public static double lagrange(double x1[], double y1[], double x, int n){
        //formulasi interpolasi lagrange
        double res = 0;

        for (int i = 1; i <= n; i++){
            double temp = 1;
            for (int j = 1; j <= n; j++){
                if (i != j) temp *= (x - x1[j])/(x1[i] - x1[j]);//perkalian lagrange
            }
            temp *= y1[i];
            res += temp;//penjumlahan interpolasinya
        }
        return res;
    }

    public static void main (String [] args){
        int n = 9; //inisialisasi ordo atau derajat
        double x1[] = {10,15,20,25,30,35,40,45,50,55}; //input data Log_10 (x1) ke dalam array
        double y1[] = {1,
                1.17609,
                1.30103,
                1.39794,
                1.47712,
                1.54407,
                1.60206,
                1.65321,
                1.69897,
                1.74036,
        }; //input nilai dari log_10 (x1) ke dalam y1
        double x = 18; //nilai x yang ingin dicari
        System.out.printf("The value of Log_10 (" + x + ") = "+ "%.5f", lagrange(x1, y1, x, n));
    }
}
