package lab01;
import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] array = new int[n];

        // Nhập phần tử cho mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));

        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        double average = (double) sum / array.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
    }
}
