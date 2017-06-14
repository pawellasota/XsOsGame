package model;


import type.Player;
import type.Seed;

import java.util.Scanner;

public class Ui {

    private char[] board;

    public Ui() {
        board = new char[8];
    }

    public static void printBoard(Cell[] board) {
//        for (Cell cell : board) {
//            cell.setContent();
//        }
//        System.out.println("----------");
//        System.out.println("|"+board[0].getContent()+"|"+board[1].getContent()+"|"+board[2].getContent());
//        printCell(board[0].getContent());
//        System.out.println("----------");
//        System.out.println("|"+board[3].getContent()+"|"+board[4].getContent()+"|"+board[5].getContent());
//        System.out.println("----------");
//        System.out.println("|"+board[6].getContent()+"|"+board[7].getContent()+"|"+board[8].getContent());
//        System.out.println("----------");
        System.out.println("----------");
        printCell(board[0].getContent());
        printCell(board[1].getContent());
        printCell(board[2].getContent());
        System.out.println("");
        System.out.println("----------");
        printCell(board[3].getContent());
        printCell(board[4].getContent());
        printCell(board[5].getContent());
        System.out.println("");
        System.out.println("----------");
        printCell(board[6].getContent());
        printCell(board[7].getContent());
        printCell(board[8].getContent());
        System.out.println("");
        System.out.println("----------");
    }


    public static void print(String value) {
        System.out.println(value);
    }

    public static void printCell(Seed players) {
        switch (players) {
            case NOUGHT:
                print("|O|");
                break;
            case CROSS:
                print("|X|");
                break;
            default:
                print("| |");
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
