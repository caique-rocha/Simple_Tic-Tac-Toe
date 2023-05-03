package tictactoe;


import java.util.Scanner;

public class Main {

    static boolean xPlayer = true;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] matrixGame = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrixGame[i][j] = ' ';
            }
        }

        playGame(scanner, matrixGame);

    }

    private static void playGame(Scanner scanner, char[][] matrixGame) {


        StringBuilder arrayGame = new StringBuilder();
        boolean xWins = false;
        boolean oWins = false;

        String coordinates = scanner.nextLine().trim();
        int x = coordinates.charAt(0);
        int y = coordinates.charAt(coordinates.length() - 1);

        // Checks if input are valid coordinates using ASCII table values
        if (49 <= x && x <= 51 && 49 <= y && y <= 51) {

            x = (int) coordinates.charAt(0)  - '0';
            y =  (int) coordinates.charAt(coordinates.length() - 1) - '0';

            // Checks if the cell is not occupied
            if (matrixGame[x - 1][y - 1]  == 'X' || matrixGame[x - 1][y - 1]  == 'O') {

                System.out.println("This cell is occupied! Choose another one!");
                playGame(scanner, matrixGame);
            } else {

                // Check whose turn it is to play
                matrixGame[x - 1][y - 1] = xPlayer ? 'X' : 'O';
                xPlayer = !xPlayer; // Change player
                printMatrixGame(matrixGame);

                for (char[] chars : matrixGame) {
                    for (char aChar : chars) {
                        arrayGame.append(aChar);
                    }
                }

                for (int i = 0; i < 3; i++) {

                    // check rows and columns for X
                    if (arrayGame.charAt(i * 3) == 'X' && arrayGame.charAt(i * 3 + 1) == 'X' && arrayGame.charAt(i * 3 + 2) == 'X' ||
                            arrayGame.charAt(i) == 'X' && arrayGame.charAt(i + 3) == 'X' && arrayGame.charAt(i + 6) == 'X') {

                        xWins = true;

                    }
                    // check rows and columns for O
                    if (arrayGame.charAt(i * 3) == 'O' && arrayGame.charAt(i * 3 + 1) == 'O' && arrayGame.charAt(i * 3 + 2) == 'O' ||
                            arrayGame.charAt(i) == 'O' && arrayGame.charAt(i + 3) == 'O' && arrayGame.charAt(i + 6) == 'O') {

                        oWins = true;

                    }
                }

                // checks diagonals for the X
                if (arrayGame.charAt(0) == 'X' && arrayGame.charAt(4) == 'X' && arrayGame.charAt(8) == 'X' ||
                        arrayGame.charAt(6) == 'X' && arrayGame.charAt(4) == 'X' && arrayGame.charAt(2) == 'X') {
                    xWins = true;
                }
                // checks diagonals for the O
                if (arrayGame.charAt(0) == 'O' && arrayGame.charAt(4) == 'O' && arrayGame.charAt(8) == 'O' ||
                        arrayGame.charAt(6) == 'O' && arrayGame.charAt(4) == 'O' && arrayGame.charAt(2) == 'O') {
                    oWins = true;
                }


                if (!arrayGame.toString().contains(" ") && !xWins && !oWins){
                    System.out.println("Draw");
                } else if (xWins) {
                    System.out.println("X wins");
                } else if (oWins){
                    System.out.println("O wins");
                } else {
                    playGame(scanner, matrixGame);
                }
            }

        } else {
            if (57 < x || 57 < y) {
                System.out.println("You should enter numbers!");

            } else {
                System.out.println("Coordinates should be from 1 to 3!");

            }
            playGame(scanner, matrixGame);
        }
    }

    private static void printMatrixGame(char[][] matrixGame) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", matrixGame[0][0], matrixGame[0][1], matrixGame[0][2]);
        System.out.printf("| %c %c %c |%n", matrixGame[1][0], matrixGame[1][1], matrixGame[1][2]);
        System.out.printf("| %c %c %c |%n", matrixGame[2][0], matrixGame[2][1], matrixGame[2][2]);
        System.out.println("---------");
    }
}