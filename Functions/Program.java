class Program {
	public static int sum(int a, int b) {
		int result = a + b;
		return result;
	}

	public static int sum(int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int x = 7;
		int y = 8;
		int sumXY = sum(x, y);
		System.out.println(sumXY);
		int a[] = {3, 6, 7, 9};
		int resultSum = sum(a);
	}
}