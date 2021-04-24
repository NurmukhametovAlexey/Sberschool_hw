package ru.sbrf.lesson6.hw6;

import java.util.Scanner;

public class CircularBufferExample {
    public static void main(String[] args) {
        // Choose whichever way you wish

        //manuallyTest();
        autoTest();
    }

    public static void manuallyTest() {
        CircularBuffer myBuffer = new CircularBuffer();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            myBuffer.handleUserCommand(sc.nextLine());
        }
    }

    public static void autoTest() {
        CircularBuffer myBuffer = new CircularBuffer();

        System.out.println("\nEmpty Buffer:\n");

        myBuffer.handleUserCommand("EMPTY");

        myBuffer.handleUserCommand("STATE");

        System.out.println("\nENQ 1; ENQ 2; ENQ 3; ENQ 4; :\n");

        myBuffer.handleUserCommand("ENQ 1");
        myBuffer.handleUserCommand("ENQ 2");
        myBuffer.handleUserCommand("ENQ 3");
        myBuffer.handleUserCommand("ENQ 4");

        myBuffer.handleUserCommand("STATE");

        System.out.println("\nENQ 5; ENQ 6; ENQ 7; ENQ 8; :\n");

        myBuffer.handleUserCommand("ENQ 5");
        myBuffer.handleUserCommand("ENQ 6");
        myBuffer.handleUserCommand("ENQ 7");
        myBuffer.handleUserCommand("ENQ 8");

        myBuffer.handleUserCommand("STATE");

        myBuffer.handleUserCommand("EMPTY");

        System.out.println("\nDEQ; DEQ; DEQ; DEQ; DEQ; :\n");

        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");

        myBuffer.handleUserCommand("STATE");

        System.out.println("\nDEQ; DEQ; DEQ; :\n");

        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");
        myBuffer.handleUserCommand("DEQ");

        myBuffer.handleUserCommand("EMPTY");

        myBuffer.handleUserCommand("STATE");
    }
}
