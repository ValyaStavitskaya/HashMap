package homeWork2;

import org.w3c.dom.ls.LSOutput;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        //averageN();
        //deposit();
        //evenOrNot();
        //isSimple();
        divisors();
    }
    //Программа, которая находит среднее арифметическое значение двух чисел
    static void average(){
        Scanner scanner = new Scanner(System.in);
        float num1 = scanner.nextFloat();
        float num2 = scanner.nextFloat();
        float average = (num1+num2)/2;
        System.out.println(average);
    }
    //Программа, которая находит среднее арифметическое значение произвольного количества чисел
    static void averageN(){
        Scanner scanner = new Scanner(System.in);
        float sum = 0;
        int count = 0;
        while (scanner.hasNextFloat()){
            float a = scanner.nextFloat();
            count++;
            sum += a;
        }
        sum = sum/count;
        System.out.println(sum);
    }
    //Программу, которая предлагает пользователю ввести сумму денежного вклада в гривнах,
    // процент годовых, которые выплачивает банк, длительность вклада (лет).
    // Вывести накопленную сумму денег за каждый год и начисленные проценты.
    public static void deposit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input deposit amount");
        BigDecimal sumDeposit = scanner.nextBigDecimal();
        System.out.println("Please input count of years for deposit");
        int countOfYear = scanner.nextInt();
        System.out.println("Please input the deposit percentage");
        BigDecimal percent = scanner.nextBigDecimal();

        BigDecimal additionalSum;


        for (int i = 0; i < countOfYear; i++) {
            additionalSum = sumDeposit.multiply(percent).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
            sumDeposit = sumDeposit.add(additionalSum);
            System.out.println("Year " + (i + 1) + ": interest is " + additionalSum.toPlainString() + ", Sum of deposit is " + sumDeposit.toPlainString());
        }

    }

    // Ввести число, определить четное или нет.

    public static void evenOrNot(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number");
        int number = scanner.nextInt();
        if(number%2==0)
            System.out.println("Number is even");
        else
            System.out.println("Number is not even");

    }

    //Ввести число, определить простое ли оно

    public static void isSimple(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number");
        Integer number = scanner.nextInt();
        BigInteger bigInteger = BigInteger.valueOf(number);
        boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(number));
        if(probablePrime)
            System.out.println("Number is simple");
        else
            System.out.println("Number is not simple");

    }

    //Ввести число, определить каким числам оно кратно

    public static void divisors(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number");
        int number = scanner.nextInt();
        for (int i = 2, limit = (int)Math.ceil(Math.sqrt(number)); i <= limit; ) {
            if (number % i == 0) {
                number = number / i;
                limit = (int)Math.ceil(Math.sqrt(number));
                System.out.print(i + " ");
            }
            else {
                i++;
            }
        }
        if (number > 1) System.out.println(number);
    }

}
