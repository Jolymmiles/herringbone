import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int end_digit = sc.nextInt();
        for (int count_on_line = 1; count_on_line < end_digit+1; count_on_line += 1) {
            for (int count_on_string = 0; count_on_string < end_digit - count_on_line; count_on_string += 1) {
                System.out.print(" ");
            }
            for (int stars = 0; stars < count_on_line*2-1; stars += 1) {
                System.out.print("*");
            }
            System.out.println();
            }
        }
    }

