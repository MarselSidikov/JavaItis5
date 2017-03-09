class Human {
	private String name;
	private int age;

	Human(String humanName, int humanAge) {
		name = humanName;
		
		if (humanAge >= 0 && humanAge <= 120) {
			age = humanAge;
		} else age = 0;
	}

	public String getName() {
		return name;
	}

	// access method - getter
	public int getAge() {
		return age;
	}	
}