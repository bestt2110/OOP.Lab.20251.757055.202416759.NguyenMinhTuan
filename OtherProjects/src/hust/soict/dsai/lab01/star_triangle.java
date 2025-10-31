package hust.soict.dsai.lab01;
import java.util.Scanner;
public class star_triangle {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter height: ");
		int n = keyboard.nextInt();
		int m = 2*n + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j<=n-i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j<=2*i-1; j++) {
				System.out.print("*");
			}
			for (int j = n+i; j<=m-1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}	
	}
}
