class ProgramIncapsTest {
	public static void main(String[] args) {
		Human human = new Human("Marsel", 23);
		// human.age = -10;
		human.setAge(-10);
		System.out.println(human.getAge());

	}
}