class Program {
	public static void main(String[] args) {
		System.out.println("someStaticValue from SomeClass:" + SomeClass.someStaticValue);
		SomeClass.someStaticValue = 500;
		System.out.println("someStaticValue from SomeClass:" + SomeClass.someStaticValue);
		// SomeClass.someValue = 10;
		SomeClass a = new SomeClass();
		
		System.out.println("someStaticValue from a before initialize:" + a.someStaticValue);
		a.someValue = 10;
		a.someStaticValue = 100;

		SomeClass b = new SomeClass();

		System.out.println("someValue from a: " 
			+ a.someValue);
		System.out.println("someValue from b: " 
			+ b.someValue);
		System.out.println("someStaticValue from a: " 
			+ a.someStaticValue);
		System.out.println("someStaticValue from b: " 
			+ b.someStaticValue);
	}
}