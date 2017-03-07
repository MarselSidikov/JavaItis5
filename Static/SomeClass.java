class SomeClass {
	public int someValue;
	public static int someStaticValue;

	static {
		someStaticValue = 1000;
	}
 	SomeClass() {
 		someStaticValue = 200;
 	}
}