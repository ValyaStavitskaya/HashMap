package graphics;

import java.util.Scanner;

public class Envelop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input height");
        int height = scanner.nextInt();
        System.out.println("Please, input width");
        int width = scanner.nextInt();
        int shift;
        char s;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    s = '*';
                } else {
                    if (j == 0 || j == width - 1) {
                        s = '*';
                    } else {
                        shift = Math.toIntExact(Math.round((double) width / (double) height * (i + 1)));

                        if (j == shift - 1 || j == width - shift) {
                            s = '*';
                        } else {
                            s = ' ';
                        }
                    }
                }

                if (j == width - 1) {
                    System.out.println(s);
                } else {
                    System.out.print(s);
                }
            }
        }
    }
}
