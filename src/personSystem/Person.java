package personSystem;

abstract class Person {

	private String firstName;
	private String lastName;

	private String regex="[a-zA-Z-\\sáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒ]+";

	public Person(String firstName, String lastName){
			this.setFirstName(firstName);
			this.setLastName(lastName);
	}





	public void setFirstName(String name) {
		if (name.matches(regex)){
			firstName = name;
		}
		else{
			//error
		}
	}

	public void setLastName(String name) {
		if (name.matches(regex)){
			lastName = name;
		}
		else{
			//error
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
