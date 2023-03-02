import java.util.Arrays;
//import java.io.File;
//import java.util.Scanner;

public class Sudoku {

    private static final int LENGTH = 9;

    public static void main(String[] args) {

        int[][] board = new int[LENGTH][LENGTH];
        //File file = new File("C:\\Users\\Matej\\Documents\\programiranje 1\\VSC\\Random\\src\\sudoku.txt");
        //Scanner sc = new Scanner(file);

        /*for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        sc.close();*/

        Vector[][] potentialNumbers = new Vector[LENGTH][LENGTH];
        boolean [][] checkBoard = new boolean[LENGTH][LENGTH];

        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                potentialNumbers[i][j].prepare();
            }
        }

        int indexOfCandidate = 0;
        int counter = 0;
        int counter1 = 0;
        int counter2 = 0;
        int checkNumber = 0;
        boolean condition = false;
        while (!condition) {
            for (int i = 0; i < LENGTH; i++) {
                for (int j = 0; j < LENGTH; j++) {
                   if (board[i][j] == 0) {
                        for (int k = 0; k < LENGTH; k++) {
                            if (potentialNumbers[i][j].returnValueOnIndex(k) > 0) { 
                                counter1++;
                                indexOfCandidate = k;
                            }
                        }
                        if (counter1 == 1) {
                            board[i][j]  = potentialNumbers[i][j].returnValueOnIndex(indexOfCandidate);
                        }
                        counter1 = 0;

                        if ((counter2 % 7) == 0) {
                            checkSquare(potentialNumbers, board, i, j);
                        }
                        if ((counter2 % 9) == 0) {
                            checkRow(potentialNumbers, board, i, j);
                        }
                        if ((counter2 % 10) == 0) {
                            checkColumn(potentialNumbers, board, i, j);
                        }
                        counter2++;
                    } else {
                        if (checkBoard[i][j] == false) {
                            potentialNumbers[i][j].remove();
                            removeBadNumbersInColumn(potentialNumbers, board, i, j);
                            removeBadNumbersInRow(potentialNumbers, board, i, j);
                            removeBadNumbersInSquare(potentialNumbers, board, i, j);
                            checkBoard[i][j] = true;
                        }
                    }

                    checkNumber = board[i][j];
                    if (checkNumber > 0) {
                        counter++;
                    }
                }
            }

            if (counter == 81) {
                break;
            }
            counter = 0;
        }

        System.out.print(Arrays.deepToString(board));
    }

    public static void removeBadNumbersInRow(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        for (int k = 0; k < LENGTH; k++) {
            potentialNumbers[i][k].setTo0(board[i][j]);
        } 
    }

    public static void removeBadNumbersInColumn(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        for (int k = 0; k < LENGTH; k++) {
            potentialNumbers[k][j].setTo0(board[i][j]);
        }
    }

    public static void removeBadNumbersInSquare(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        int k = i;
        int l = j;

        while ((i % 3) != 0) {
            i--;
        }
        while ((j % 3) != 0) {
            j--;
        }

        for (int a = i; a < a + 3; a++) {
            for (int b = j; b < b + 3; b++)  {
                potentialNumbers[a][b].setTo0(board[k][l]);
            }
        }
    }

    public static void checkSquare(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        int[] countingArr = new int[LENGTH];

        while (i % 3 != 0) {
            i--;
        }
        while (j % 3 != 0) {
            j--;
        }
        
        for (int a = i; a < a + 3; a++) {
            for (int b = j; b < b + 3; b++) {
                for (int k = 0; k < LENGTH; k++) {
                    if (potentialNumbers[a][b].returnValueOnIndex(k) > 0) {
                        countingArr[k] = countingArr[k] + 1;
                    }
                }
            }
        }

        for (int a = i; a < a + 3; a++) {
            for (int b = j; b < b + 3; b++) {
                for (int k = 0; k < LENGTH; k++) {
                    if (countingArr[k] == 1) {
                        board[a][b] = potentialNumbers[a][b].returnValueOnIndex(k) + 1;
                    }
                }
            }
        }
    }

    public static void checkRow(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        int[] countingArr = new int[LENGTH];
        
        for (int k = 0; k < LENGTH; k++) {
            if (potentialNumbers[i][k].returnValueOnIndex(k) > 0) {
                countingArr[k] = countingArr[k] + 1;
            }
        }

        for (int k = 0; i < LENGTH; i++) {
            if (countingArr[k] == 1) {
                board[i][k] = potentialNumbers[i][k].returnValueOnIndex(k) + 1;
            }
        }
    }

    public static void checkColumn(Vector[][] potentialNumbers, int[][] board, int i, int j) {
        int[] countingArr = new int[LENGTH];

        for (int k = 0; k < LENGTH; k++) {
            if (potentialNumbers[k][j].returnValueOnIndex(k) > 0) {
                countingArr[k] = countingArr[k] + 1;
            }
        }

        for (int k = 0; i < LENGTH; i++) {
            if (countingArr[k] == 1) {
                board[k][j] = potentialNumbers[k][j].returnValueOnIndex(k) + 1;
            }
        }
    }
}
