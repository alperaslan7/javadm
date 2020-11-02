import java.util.*;
import java.io.*;
import java.math.*;


class Solution{

    public static void affMatrice(int[][] matrice)
	{
		for(int i = 0 ; i < matrice.length ; i++)
		{
			for (int j = 0 ; j < matrice[i].length ; j++)
				System.err.format("%6d", matrice[i][j]);
			System.err.println();
		}
	}

    public static int nbPaths(int[][] matrix) {
        // On utilise  le Triangle de Pascal
        // On remplit les bords de la matrice
        // Si c'est hors chemin, on met la valeur 0
        // Tant que c'est sur le chemin, c'est 1
        matrix[0][0] = 1;
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0 && matrix[i - 1][0] != 0) {
                matrix[i][0] = 1;
            }
            else if(matrix[i][0] == 1) {
                matrix[i][0] = 0;
            }
        }
        for(int j = 1; j < matrix[0].length; j++){
            if(matrix[0][j] == 0 && matrix[0][j - 1] != 0) {
              matrix[0][j] = 1;
            }
            else if(matrix[0][j] == 1) {
              matrix[0][j] = 0;
            }
        }

        // On utilise le triangle de Pascal
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
                else if(matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
                }
            }
        }
        System.err.println("Matrice pascale: ");
        affMatrice(matrix);
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        int[][] matrix = new int[M][N];

        for (int i = 0; i < M; i++) {
            String ROW = in.nextLine();
            for(int j = 0; j < N; j++) {
              matrix[i][j] = Integer.parseInt(String.valueOf(ROW.charAt(j)));
            }
        }



        System.err.println("Matrice du parcours");;
        affMatrice(matrix);
        System.out.println(nbPaths(matrix));
    }
}

