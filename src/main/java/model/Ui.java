package model;


import type.Player;

import java.util.Scanner;

public class Ui {

    private char[] board;

    public Ui() {
        board = new char[8];
    }

    public void printBoard() {
        System.out.println("----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i] + " | ");
            }
            System.out.println("");
            System.out.println("----------");
        }
    }

    public void print(String value) {
        System.out.println(value);
    }

    public void printCell(Player players) {
        switch (players) {
            case NOUGHT:
                this.print("O");
                break;
            case CROSS:
                this.print("X");
                break;
        }
    }

    public void paint() {
        for (int row = 0; row < ; ++row) {
            board[row].this.printCell(Player players);
            print(" ");
            if (row < row - 1) {
                print("-----------");
            }
        }
    }

    public static int getUserInput(String input) {
        Scanner user_input = new Scanner(System.in);
        System.out.print(input);
        return user_input.nextInt();
    }

    public void pressAnyKeyToContinue() {
        this.print("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {

        }

    }
}
