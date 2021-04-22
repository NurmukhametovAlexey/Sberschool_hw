package ru.sbrf.lesson2.hw2;
import java.util.Scanner;
/**
 * The Abracadabra class is for putting text in a box of '*' symbols
 */
public class Abracadabra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину и ширину рамку (целые числа)");
        int len = Integer.parseInt(scanner.nextLine());
        int wid = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите строку для печати (длина не должна превышать ширину рамки)");
        String str = scanner.nextLine();

        boxing(wid, len, str);
    }
    /**
     * Print the text centered inside the box of '*' characters.
     * In case the box is to small to fit the text, an error message is passed to stderr.
     *
     * @param  width    width of the box
     * @param  length   length of the box
     * @param  text     text to put inside
     */
    public static void boxing(int width, int length, String text) {
        if (text.length() + 2 > width || length < 3) {
            System.err.println("Ошибка");
            return;
        }
        int textVerticalPos = (length-1)/2;
        printEdge(width);
        for (int j = 1; j < length-1; j++) {
            if (j == textVerticalPos)
                printTextInterior(width, text);
            else
                printEmptyInterior(width);
        }
        printEdge(width);
    }
    /**
     * Print the edge of the box filled with '*' characters.
     *
     * @param  width  width of the box
     */
    private static void printEdge(int width) {
        for (int i = 0; i < width; i++)
            System.out.print('*');
        System.out.print('\n');
    }
    /**
     * Print the empty interior of the box.
     *
     * @param  width  width of the box
     */
    private static void printEmptyInterior(int width) {
        System.out.print('*');
        for (int i = 1; i < width -1; i++)
            System.out.print(' ');
        System.out.println('*');
    }
    /**
     * Print the interior of the box with centered text.
     *
     * @param  width  width of the box
     * @param  text   text to print inside
     */
    private static void printTextInterior(int width, String text) {
        int textStart = (width - text.length())/2;
        System.out.print('*');
        for (int i = 1; i < width -1; i++) {
            if(i == textStart) {
                System.out.print(text);
                i += text.length() - 1;
            }
            else
                System.out.print(' ');
        }
        System.out.println('*');
    }
}
