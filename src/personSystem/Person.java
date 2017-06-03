package personSystem;

import java.util.Date;
import exceptions.IncorrectString;

abstract class Person {

	private String firstName;
	private String lastName;
	private Date bornDate;

	private static String regex="[a-zA-Z-\\sáàâäãåçéèêëíìîïñóòôöõúùûüýÿæœÁÀÂÄÃÅÇÉÈÊËÍÌÎÏÑÓÒÔÖÕÚÙÛÜÝŸÆŒøğ\\']+";

	public Person() {
	}

	public Person(String firstName, String lastName, Date bornDate) throws IncorrectString{
			this.setFirstName(firstName);
			this.setLastName(lastName);
			this.bornDate = bornDate;
	}


	public Date getBornDate() {
		return this.bornDate;
	}

	public void setFirstName(String name) throws IncorrectString{
		if (name.matches(regex)){
			firstName = name;
		}
		else{
			//error
			throw new IncorrectString(String.format("firstName not valid : %s", name));
		}
	}

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
