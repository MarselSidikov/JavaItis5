class Human {
	String name;
	private int age;

	Human(String humanName, int humanAge) {
		name = humanName;
		age = humanAge;
	}

	// access method - getter
	public int getAge() {
		return age;
	}

	// access method - setter
	public void setAge(int humanAge) {
		if (humanAge >= 0 && humanAge <= 120) {
			age = humanAge;
		} else age = 0;
	}
}