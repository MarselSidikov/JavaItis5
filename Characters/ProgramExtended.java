class ProgramExtended {
	public static void main(String[] args) throws Exception {
		char c = (char)System.in.read();

		if (c >= '0' && c <= '9') {
			System.out.println("It is digit");	
		} else if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
			System.out.println("It is letter");
		}
	}
}