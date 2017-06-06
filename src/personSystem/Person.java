package personSystem;

import exceptions.IncorrectString;

abstract class Person {

	private String firstName;
	private String lastName;

	private static String regex="[a-zA-Z0-9Ã¡Ã Ã¢Ã¤Ã£Ã¥Ã§Ã©Ã¨ÃªÃ«Ã­Ã¬Ã®Ã¯Ã±Ã³Ã²Ã´Ã¶ÃµÃºÃ¹Ã»Ã¼Ã½Ã¿Ã¦Å“Ã�Ã€Ã‚Ã„ÃƒÃ…Ã‡Ã‰ÃˆÃŠÃ‹Ã�ÃŒÃŽÃ�Ã‘Ã“Ã’Ã”Ã–Ã•ÃšÃ™Ã›ÃœÃ�Å¸Ã†Å’Ã¸ÄŸ]+";

	public Person() {
	}

	public Person(String firstName, String lastName) throws IncorrectString{
			this.setFirstName(firstName);
			this.setLastName(lastName);
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
