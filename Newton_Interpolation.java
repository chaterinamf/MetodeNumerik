public class Newton_Interpolation {
    public static double newton(double x1[], double y1[][], double x, int n){
        double res = y1[0][0];

        //loop untuk menghitung selisih terbagi
        for (int i = 1; i < n; i++){
            for (int j = 0; j < n-i; j++)
                y1[j][i] = (y1[j][i-1] - y1[j+1][i-1]) / (x1[j] - x1[i+j]);
        }

        //formula newton interpolation
        for (int i = 1; i < n; i++){
            double temp = 1;
            for (int j = 0; j < i; j++)
                temp *= (x - x1[j]);
            res += (temp * y1[0][i]);//penjumlahan interpolasinya
        }
        return res;
    }
    public static void main (String [] args){
        int n = 9; //inisialisasi ordo atau derajat
        double x1[] = {10,15,20,25,30,35,40,45,50,55}; //input data Log_10 (x1) ke dalam array
        double y1[][] = new double[10][10];
        y1[0][0] = 1;
        y1[1][0] = 1.17609;
        y1[2][0] = 1.30103;
        y1[3][0] = 1.39794;
        y1[4][0] = 1.47712;
        y1[5][0] = 1.54407;
        y1[6][0] = 1.60206;
        y1[7][0] = 1.65321;
        y1[8][0] = 1.69897;
        y1[9][0] = 1.74036;

        double x = 18; //nilai x yang ingin dicari

        System.out.printf("The value of Log_10 (" + x + ") = "+ "%.5f", newton(x1, y1, x, n));
    }
}
