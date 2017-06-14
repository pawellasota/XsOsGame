package model;


import type.Player;

import java.util.Scanner;

public class Ui {

    private char[] board;

    public Ui() {
        board = new char[8];
    }

    public static void printBoard(Cell[] board) {
        System.out.println("----------");
        System.out.println("|"+board[0].getContent()+"|"+board[1].getContent()+"|"+board[2].getContent());
        System.out.println("----------");
        System.out.println("|"+board[3].getContent()+"|"+board[4].getContent()+"|"+board[5].getContent());
        System.out.println("----------");
        System.out.println("|"+board[6].getContent()+"|"+board[7].getContent()+"|"+board[8].getContent());
        System.out.println("----------");
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

//    public void paint() {
//        for (int row = 0; row < ; ++row) {
//            board[row].this.printCell(Player players);
//            print(" ");
//            if (row < row - 1) {
//                print("-----------");
//            }
//        }
//    }

    public static int getUserInput() {
        Scanner user_input = new Scanner(System.in);
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
