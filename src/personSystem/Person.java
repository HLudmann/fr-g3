package personSystem;

abstract class Person {

	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName){
			this.firstName = firstName;
			this.lastName = lastName;

	}


	public void setFirstName(String name) {
		firstName = name;
	}

	public void setLastName(String name) {
		lastName = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
