import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class Test {
    public static void main(String args[]) throws Exception {

        File file = new File("C:\\Users\\Matej\\Documents\\programiranje 1\\VSC\\Random\\src\\sudoku.txt");
        Scanner sc = new Scanner(file);
        Scanner sc2 = new Scanner(System.in);

        int[][] arr = new int[9][9];
        int[][][] arr1 = new int[1000][9][9];
        int boardNumber = 0;
        int i = 0;
        int j = 0;
        String string = "a";
        String skipGrid = "Grid";
        String condition = "a";
        String checkCondition = "Y";

        System.out.println("would you like to fill 1 board? Type Y for 1 board, N for more boards.");
        condition = sc2.next();
        sc2.close();

        if (condition.equals(checkCondition)) {
            boolean condition1 = true;
        }

        while (sc.hasNext()) {
            string = sc.next();
            if (string.equals(skipGrid)) {
                if (sc.hasNext()) {
                    string = sc.next();
                }
                if (sc.hasNext()) {
                    string = sc.next();
                }
            }
            for (int k = 0; k < string.length(); k++) {
                if (string.charAt(k) <= '9' && string.charAt(k) >= '0') {
                    if (condition.equals(checkCondition)) {
                        if (i < 9) {
                            if (j < 9) {
                                arr[i][j] = (int) (string.charAt(k) - 48);
                                j++;
                            } else {
                                sc.close();
                                throw new Exception("You've inserted more than 9 numbers in row");
                            }
                        } else {
                            sc.close();
                            throw new Exception("The board is already full");
                        }
                    } else {
                        if (i < 9) {
                            if (j < 9) {
                                arr1[boardNumber][i][j] = (int) (string.charAt(k) - 48);
                                j++;
                            } else {
                                sc.close();
                                throw new Exception("You've inserted more than 9 numbers in row");
                            }
                        } else {
                            boardNumber++;
                            i = 0;
                            if (j < 9) {
                                arr1[boardNumber][i][j] = (int) (string.charAt(k) - 48);
                                j++;
                            } else {
                                sc.close();
                                throw new Exception("You've inserted more than 9 numbers in row");
                            }
                        }
                    }
                }
            }
            j = 0;
            i++;
        }
        sc.close();
        for (int index = 0; index <= boardNumber; index++) {
            System.out.println(Arrays.deepToString(arr1[index]));
        }
        //printToTable(arr);
    }

    private static void printToTable(int boardNumber, boolean condition1, int[][][] array1, int[][] array) {

        if (condition1) {
            System.out.println(Arrays.deepToString(array).replace("[", "").replace("]]", "").replace("], ", "\n"));
            System.out.println("\n");
        } else {
            for (int i = 0; i < boardNumber; i++) {
                System.out.println(Arrays.deepToString(array1[boardNumber]).replace("[", "").replace("]]", "").replace("], ", "\n"));
                System.out.println("\n");
            }
        }
    }
}