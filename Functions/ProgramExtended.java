class ProgramExtended {
	// сделать функцию, которая возвращает копию массива
	public static int[] copyOf(int array[]) {
		int[] resultArray = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			resultArray[i] = array[i];
		}

		return resultArray;
	}

	public static int[] badCopyOf(int array[]) {
		int[] resultArray = array;
		return resultArray;
	}

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4};

		int copyGood[] = copyOf(a);
		System.out.println("CREATE GOOD COPY");
		int copyBad[] = badCopyOf(a);
		System.out.println("CREATE BAD COPY");


		System.out.println("ORIGINAL:");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		a[3] = 10;

		System.out.println();
		System.out.println("ORIGINAL AFTER CHANGE:");

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println();
		System.out.println("GOOD COPY:");

		for (int i = 0; i < copyGood.length; i++) {
			System.out.print(copyGood[i] + " ");
		}

		System.out.println();
		System.out.println("BAD COPY:");

		for (int i = 0; i < copyBad.length; i++) {
			System.out.print(copyBad[i] + " ");
		}
	} 
}