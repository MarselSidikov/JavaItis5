class ProgramConvert {
	public static void main(String[] args) {
		char digit = '9';

		int integerDigit = digit - '0';

		integerDigit = 5;

		digit = integerDigit + '0';

		char number[] = {'1', '9', '3', '2'};

		int outValue = 0;

		/**
			1-я итерация outValue = 1
			2-я итерация outValue = 1 * 10 + 9 = 19
			3-я итерация outValue = 19 * 10 + 3 = 193
			4-я итерация outVaulue = 193 * 10 + 2 = 1932
		**/
		for (int i = 0; i < number.length; i++) {
			outValue = outValue * 10 + (number[i] - '0');
		}
	}
}