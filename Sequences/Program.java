import java.util.Scanner;

class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int a;
		int sum = 0;

		a = scanner.nextInt();

		while (a != -1) {
			if (a % 2 == 0) {
				sum = sum + a;
			}
			a = scanner.nextInt();
		}

		System.out.println(sum);
	}
}