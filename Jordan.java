public class Jordan {

    /*print Augmented Matrix [A|B]
    [A|B] = {3, 2, 4, 175},
            {2, 4, 3, 180},
            {4, 3, 2, 140}
     */
    public void augmentedMatrix(float[][] A, float[] B){
        int n = B.length;
        System.out.println("Augmented Matriks [A|B] = ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.printf("%4.0f", A[i][j]);
            }
            System.out.printf("%4.0f",B[i]);
            System.out.println();
        }
        System.out.println();
    }

    //mengecek apakah SPL-nya konvergen atau tidak (A[i][i] != 0)
    public boolean convergent(float[][] A){
        for (int i = 0; i < A.length; i++){
            float diagonal = Math.abs(A[i][i]);
            float tempSum = 0;
            for (int j = 0; j < A.length; j++){
                if (A[i][i] == 0)
                {
                    int c = 1;
                    while ((i + c) < A.length && A[i + c][i] == 0)
                        c++;
                    for (int k = 0; k <= A.length; k++)
                    {
                        tempSum =A[i][k];
                        A[i][k] = A[i+c][k];
                        A[i+c][k] = tempSum;
                    }
                }
                //if (i != j) tempSum += Math.abs(A[i][j]);
                if (tempSum >= diagonal) return false;
            }
        }
        System.out.println("SPL Konvergen.");
        return true;
    }
    public void jordan(int n, float[][] a, float[] x){
        int i, j, k;
        float c;
        if (!convergent(a))
            System.out.println("SPL tidak konvergen!");

        else{
            for (i = 0; i < n; i++){
                c = a[i][i];
                for (k = 0; k < n+1; k++)
                    a[i][k] /= c; //membagi elemen masing diagonal (buat identitas)
                for (j = 0; j < n; j++){
                    if (j!=i) {
                        c = a[j][i];
                        for (k = 0; k < n + 1; k++)
                            a[j][k] -= (c * a[i][k]); //operasi OBE
                    }
                }
            }

            //menampilkan nilai masing masing akar (x,y,z)
            for (i = 0; i < n; i++){
                for (j = 0; j < n+1; j++) {
                    x[i] = a[i][j];
                }
            }
        }
    }
    public static void main (String [] args) {
        Jordan jordan = new Jordan();
        /*
        3x + 2y + 4z = 175
        2x + 4y + 3z = 180
        4x + 3y + 2z = 140
         */
        float[][] A = {
                {3, 2, 4},
                {2, 4, 3},
                {4, 3, 2}
        };
        float[] B = {175, 180, 140};
        float[] x = {0,0,0};
        float[][] a = {
                {3, 2, 4, 175},
                {2, 4, 3, 180},
                {4, 3, 2, 140}
        };
        int n = 3;

        jordan.augmentedMatrix(A, B);
        jordan.jordan(n, a, x);
        System.out.println("Akar Persamaan: ");
        System.out.println("    x   |   y   |   z");
        for (int i = 0; i < n; i++) {
            System.out.printf("  "+"%.3f",x[i]);
        }
        System.out.println();

        System.out.println("Matriks Akhir: ");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= n; j++)
                System.out.printf("%3.0f ", Math.abs(a[i][j]));
            System.out.println();
        }
    }
}
