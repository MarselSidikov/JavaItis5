class Program {
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int x = 6;
		int y = 7;

		swap(x, y);
		System.out.println("X: " + x + " , Y: " + y);
		
		int b[] = {1, 2, 3, 4, 5};
		swap(b, 1, 3);
		System.out.println("b[1]: " + b[1] + " , b[3]: " + b[3]);
	}
}