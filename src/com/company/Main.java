package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("INPUT.TXT")));
        String string;
        string = bufferedReader.readLine();
        int quantity = Integer.parseInt(string.split(" ")[0]);
        int length = Integer.parseInt(string.split(" ")[1]);
        string = bufferedReader.readLine();
        int line = Integer.parseInt(string.split(" ")[0]);
        int column = Integer.parseInt(string.split(" ")[1]);
        int simpleNumberP = Integer.parseInt(bufferedReader.readLine());
        bufferedReader.readLine();
        String[] numbers;
        List<int[][]> matrixes = new ArrayList<>();
        int count = 1;
        while (count <= quantity) {
            int[][] varMatrix = new int[length][length];
            for (int i = 0; i < length; i++) {
                numbers = bufferedReader.readLine().split(" ");
                for (int j = 0; j < length; j++) {
                    varMatrix[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            matrixes.add(varMatrix);
            bufferedReader.readLine();
            count++;
        }
        bufferedReader.close();
        int[][] matrix = matrixes.get(0);
        int[] result = new int[length];
        for (int matrixNumber = 1; matrixNumber < quantity; matrixNumber++) {
            int[][] varMatrix = matrixes.get(matrixNumber);
            int i = line - 1;
            for (int j = 0; j < length; j++) {
                result[j] = 0;
                for (int k = 0; k < length; k++) {
                    result[j] += matrix[i][k] * varMatrix[k][j];
                }
                if (result[j] > simpleNumberP) {
                    result[j] = result[j] % simpleNumberP;
                }
            }
            for(int j = 0; j < length; ++j) {
                matrix[i][j] = result[j];
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("OUTPUT.TXT")));
        bufferedWriter.write(String.valueOf(matrix[line-1][column-1]));
        bufferedWriter.close();
    }
}
