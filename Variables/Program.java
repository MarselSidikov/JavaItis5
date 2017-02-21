class Program {
	public static void main(String[] args) {
		int x = 7;
		int y = 3;
		System.out.println("7 / 3 = " + (x / y));
		System.out.println("7 % 3 = " + (x % y));
		int temp = x;
		x = y;
		y = temp;

		x = 7;
		y = 3;

		double d = 7.4;
		d = x / y ;
		System.out.println(d);

		double d2 = 7.8;
		// int x = d2; // error
		x = (int)d2;
		System.out.println(x);

		boolean expression;
		expression = true;
		expression = false;

		char c = 'A';
	}
}