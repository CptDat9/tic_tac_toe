import java.util.Scanner;

public class TicTacToe {
    private static final int BOARD_SIZE = 3;
    private static char currentPlayerSymbol = 'X';
    private static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initBoard();
        displayBoard();
        while (!isGameOver()) {
            getPlayerMove();
            displayBoard();
            if (isGameOver()) {
                break;
            }
            currentPlayerSymbol = (currentPlayerSymbol == 'X') ? 'O' : 'X';
        }
        scanner.close();
    }

    private static void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isGameOver() {
        if (checkWin()) {
            System.out.println("Nguoi choi " + currentPlayerSymbol + " wins!");
            return true;
        }
        if (checkDraw()) {
            System.out.println("Hoa!");
            return true;
        }
        return false;
    }

    private static boolean checkWin() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                return true;
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
                return true;
        }
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
                || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' '))
            return true;
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }

    private static void getPlayerMove() {
        int row, col;
        while (true) {
            try {
                System.out.println("Den luot cua nguoi choi " + currentPlayerSymbol + ":");
                System.out.print("Nhap hang (0-2): ");
                row = scanner.nextInt();
                System.out.print("Nhap cot (0-2): ");
                col = scanner.nextInt();
                if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == ' ') {
                    board[row][col] = currentPlayerSymbol;
                    break;
                } else {
                    System.out.println("Buoc di nay khong hop le");
                }
            } catch (Exception e) {
                System.out.println("Khong hop le. Hay nhap gia tri tu 0-2");
                scanner.next(); 
            }
        }
    }
}
