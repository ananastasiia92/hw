package Seminars.sem3.hw;

import java.time.LocalDate;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String bornDate;
    private long phoneNumber;
    private String gender;

    public Person(String lastName, String firstName, String middleName, String bornDate, long phoneNumber, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBornDate() {
        return bornDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("<%s> <%s> <%s> <%s> <%s> <%s> %n", lastName, firstName, middleName, bornDate, phoneNumber, gender);
    }
    
}
