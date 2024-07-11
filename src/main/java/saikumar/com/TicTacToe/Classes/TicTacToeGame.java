package saikumar.com.TicTacToe.Classes;

import saikumar.com.TicTacToe.Enum.CellValue;

import java.util.Scanner;

public class TicTacToeGame {
    private final Board board;
    private final Player[] players;

    public TicTacToeGame() {
        this.board = new Board();
        this.players = new Player[2];
    }

    private void printWelcome() {
        System.out.println("\n---------------------------");
        System.out.println("Welcome to Tic-Tac-Toe!");

    }

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        String player = "";
        do {
            System.out.println("---------------------------");
            System.out.println("Enter first player name : ");
            player = scanner.nextLine();
            if (player.isEmpty()) System.out.println("Player name cannot be empty!");
        } while (player.isEmpty());
        CellValue player1Pin = CellValue.EMPTY;
        String playerPin = "";
        do {
            System.out.println("Enter first player's pin (X/O) : ");
            playerPin = scanner.nextLine();
            try {
                if (CellValue.valueOf(playerPin).equals(CellValue.X) || CellValue.valueOf(playerPin).equals(CellValue.O) || !CellValue.valueOf(playerPin).equals(CellValue.EMPTY))
                    player1Pin = CellValue.valueOf(playerPin);
                break;
            } catch (Exception e) {
                System.out.printf("Invalid pin for %s%n", player);
                System.out.println("Please try again ! ");
            }
        } while (!player1Pin.equals(CellValue.X) || !player1Pin.equals(CellValue.O) || player1Pin.equals(CellValue.EMPTY));
        players[0] = new Player(player, player1Pin);
        CellValue player2Pin;
        if (player1Pin == CellValue.X) player2Pin = CellValue.O;
        else player2Pin = CellValue.X;
        do {
            System.out.println("Enter second player name : ");
            player = scanner.nextLine();
            if (player.isEmpty()) System.out.println("Player name cannot be empty!");
        } while (player.isEmpty());
        players[1] = new Player(player, player2Pin);
        System.out.println("---------------------------");
        System.out.printf("%s is assigned pin with value %s%n", players[0].name(), players[0].value());
        System.out.printf("%s is assigned pin with value %s%n", players[1].name(), players[1].value());
    }

    private boolean makeCellInsertion(int i, Scanner scanner) {
        System.out.println("---------------------------");
        System.out.printf("%s's turn : %n", players[i].name());
        int row = 0, column = 0;
        while (row < 1 || row > 3) {
            System.out.print("Enter row number (1/2/3) : ");
            row = scanner.nextInt();
            if (row < 1 || row > 3) System.out.println("Invalid row number");
        }
        while (column < 1 || column > 3) {
            System.out.print("Enter column number (1/2/3) : ");
            column = scanner.nextInt();
            if (column < 1 || column > 3) System.out.println("Invalid column number");
        }
        boolean isAssignSuccessful = this.board.assignValueToCell(row, column, players[i].value().toString());
        if (!isAssignSuccessful) {
            System.out.printf("pin is already assigned with value %s%n", this.board.getCellValue(row, column));
            return false;
        }
        System.out.println("Board position after the new insertion : ");
        this.board.displayBoard();
        return true;
    }

    private boolean printWinMessage(int i) {
        boolean isGameWon = this.board.verify();
        if (isGameWon) {
            System.out.println("=========================");
            System.out.println("The game is over!");
            System.out.printf("Congratulations! %s has won the game !", players[i].name());
            System.out.println();
        }
        return isGameWon;
    }

    public void start() {
        this.printWelcome();
        this.getInput();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isPlayerTurnDone = false;
            while (!isPlayerTurnDone) isPlayerTurnDone = makeCellInsertion(0, scanner);
            if (this.printWinMessage(0)) break;
            isPlayerTurnDone = false;
            while (!isPlayerTurnDone) isPlayerTurnDone = makeCellInsertion(1, scanner);
            if (this.printWinMessage(1)) break;
        }
    }
}
