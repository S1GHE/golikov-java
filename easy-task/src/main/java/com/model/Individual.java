package main.java.com.model;

public class Individual extends Employee {
    private String firstName;
    private String lastName;
    private boolean hasChildren;
    private int age;

    public Individual(long id, String email, String phone, String address, BankAccount bankAccount,
                      String firstName, String lastName, boolean hasChildren, int age) {
        super(id, email, phone, address, bankAccount);
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasChildren = hasChildren;
        this.age = age;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public boolean getHasChildren(){
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
