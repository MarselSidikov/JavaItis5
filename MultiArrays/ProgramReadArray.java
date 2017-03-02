import java.util.Scanner;
class ProgramReadArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n;
		int m;

		System.out.println("Enter rows count:");
		n = scanner.nextInt();
		System.out.println("Enter columns count:");
		m = scanner.nextInt();

		int array[][] = new int[n][m];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				array[i][j] = scanner.nextInt();
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}

	}
}