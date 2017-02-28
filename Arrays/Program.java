class Program {
	public static void main(String[] args) {
		int a[] = new int[5];
		a[0] = 6;
		a[1] = -7;
		a[2] = 8;
		a[3] = 10;
		a[4] = -3;

		// can replace int a[] = {6, -7, 8, 10, -3};

		/**
		int i = 0;
		while (i < 5) {
			System.out.print(a[i] + " ");
			i = i + 1; // i++;
		}

		System.out.println();
		i = 4;

		while (i >= 0) {
			System.out.print(a[i] + " ");
			i--;
		}
		**/

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}