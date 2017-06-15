package view;


import model.Cell;
import type.Seed;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ui {

    Scanner scanner;

    public Ui() {
    }

    public static void printBoard(Cell[] board) {

        String boardString = new String(
                "-------\n|" + printCell(board[0].getContent()) + "|" + printCell(board[1].getContent()) + "|" + printCell(board[2].getContent()) + "|\n" +
                        "-------\n|" + printCell(board[3].getContent()) + "|" + printCell(board[4].getContent()) + "|" + printCell(board[5].getContent()) + "|\n" +
                        "-------\n|" + printCell(board[6].getContent()) + "|" + printCell(board[7].getContent()) + "|" + printCell(board[8].getContent()) + "|\n" +
                        "-------\n");

        System.out.println(boardString);
    }

    public static void printRoundInfo(Seed player) {
        System.out.println("Player "+player+" enter your move ([0-9]):");
    }

    public static void print(String value) {
        System.out.println(value);
    }

    public static String printCell(Seed players) {
        switch (players) {
            case NOUGHT:
                return("O");
            case CROSS:
                return("X");
            default:
                return(" ");
        }
    }

    public static Integer getUserInput() throws InputMismatchException {
        Scanner user_input = new Scanner(System.in);
        return user_input.nextInt();
    }
}
