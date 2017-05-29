package personSystem;

import exceptions.IncorrectString;


/**
 * Abstract class that represents a person
 */
abstract class Person {

	private String firstName;
	private String lastName;

	private String regex="[a-zA-Z-\\sáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ\\']+";

	/**
	 * Create an instance of Person
	 * @param firstName the firstName of the person
	 * @param lastName the lastName of the person
	 */

	public Person(String firstName, String lastName) throws IncorrectString{
		//the function use getters and setters to check the validity of inputs
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}




	/**
	 * Check the firstName and set it if validity
	 * @param name the new firstName
	 */

	public void setFirstName(String name) throws IncorrectString{
		if (name.matches(regex)){
			firstName = name;
		}
		else{
			//error
			throw new IncorrectString(String.format("firstName not valid : %s", name));
		}
	}

	/**
	 * Check the lastName and set it if validity
	 * @param name the new lastName
	 */
	public void setLastName(String name) throws IncorrectString{
		if (name.matches(regex)){
			lastName = name;
		}
		else{
			//error
			throw new IncorrectString(String.format("lastName not valid : %s", name));

		}
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
