class Program {
	public static void main(String[] args) {
		// on i-position  at array is count of humans with i-age
		// countHumansWithAges[4] = 5; - 5 humans has age 4
		int countHumansWithAges[] = new int[120];

		Human human1 = new Human("Marsel", 23);
		Human human2 = new Human("Artur", 23);
		Human human3 = new Human("Kirill", 25);
		Human human4 = new Human("Denis", 22);
		Human human5 = new Human("Ayaz", 24);
		Human human6 = new Human("Artur", 23);
		// human6.age = -10;
		Human human7 = new Human("Andrey", 25);
		Human human8 = new Human("Robert", 37);

		Human humans[] = {human1,human2,human3,
			human4,human5,human6,human7,human8};


		for (int i = 0; i < humans.length; i++) {
			int currentAge = humans[i].getAge();
			countHumansWithAges[currentAge]++;
		}

		for (int i = 0; i < countHumansWithAges.length; i++) {
			if (countHumansWithAges[i] != 0) {
				System.out.println(i + " " + countHumansWithAges[i]);
			}
		}

		for (int i = humans.length - 1; i >= 0; i--) { // O(N)
			for (int j = 0; j < i; j++) { // O(N + N-1 + N-2 + N-3..) = O(N)
				if (humans[j].getAge() < humans[j+1].getAge()) {
					Human temp = humans[j];
					humans[j] = humans[j+1];
					humans[j+1] = temp;
				}
			}
		}

		for (int i = 0; i < humans.length; i++) {
			System.out.println(humans[i].getAge() + " " + humans[i].getName());
		}
	}
}