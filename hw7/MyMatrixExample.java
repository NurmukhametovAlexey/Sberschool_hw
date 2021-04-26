package ru.sbrf.lesson7.hw7;

public class MyMatrixExample {
    public static void main(String[] args) {
        System.out.println("Square Matrix:");

        MyMatrix myMatrix = new MyMatrix(5,5);

        myMatrix.randomFill();
        myMatrix.print();

        System.out.println();

        for(var el: myMatrix)
            System.out.print(el + " ");

        System.out.println("\n\nMore cols:");
        MyMatrix myMatrix2 = new MyMatrix(2,7);

        myMatrix2.randomFill();
        myMatrix2.print();

        System.out.println();

        for(var el: myMatrix2)
            System.out.print(el + " ");

        System.out.println("\n\nMore rows:");

        MyMatrix myMatrix3 = new MyMatrix(6,3);

        myMatrix3.randomFill();
        myMatrix3.print();

        System.out.println();

        for(var el: myMatrix3)
            System.out.print(el + " ");
    }
}
