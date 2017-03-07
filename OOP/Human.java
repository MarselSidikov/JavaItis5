class Human {
	// fields
	int marks[];
	String name;

	// empty constructor 
	Human() {
		name = "DEFAULT NAME";
	}
	
	// overload constructor with parameters
	Human(String humanName) {
		name = humanName;
	}

	// overload constructor with parameters
	Human(String humanName, int[] humanMarks) {
		name = humanName;
		marks = humanMarks;
	}

	// method
	double averageOfMarks() {
		double average = 0;
		for (int i = 0; i < marks.length; i++) {
			average = average + marks[i];
		}

		return average / marks.length;
	}
}