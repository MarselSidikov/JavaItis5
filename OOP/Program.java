class Program {
	public static void main(String[] args) {
		Human masha;
		masha = new Human("Oleg");
		System.out.println(masha.name);
		/*
		masha.name = "Masha";
		masha.marks = new int[]{3, 4, 5};
		*/

		int mashaMarks[] = {3, 4, 5};
		masha = new Human("Masha", mashaMarks);
		System.out.println(masha.name);
		System.out.println(masha.averageOfMarks());
		Human marsel = masha;
		marsel.name = "Marsel";
		System.out.println(masha.name);

		Human artur = new Human();
		artur.name = "Artur";
		artur.marks = new int[]{5, 5, 5};
		System.out.println(artur.averageOfMarks());

	}
}