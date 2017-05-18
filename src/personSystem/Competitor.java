package src.personSystem;

public class Competitor extends Person {

    private int id;

    public Competitor(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id=id;

    }

    public int getId(){
        return id;
    }


}
