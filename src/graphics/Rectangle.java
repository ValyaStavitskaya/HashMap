package graphics;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input height");
        int height = scanner.nextInt();
        System.out.println("Please, input width");
        int width = scanner.nextInt();
        for (int i=1; i<=height; i++)
        {
            for (int j=1; j<=width; j++)
            {
                if (i==1 || j==1 || i==height || j==width )
                    System.out.print("*");
                else
                    System.out.print(" ");

            }
            System.out.println();
        }
    }
}
