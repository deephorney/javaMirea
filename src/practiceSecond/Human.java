package practiceSecond;

import java.time.LocalDate;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthday;
    int weight;
    Human(int age, String firstName, String lastName, LocalDate birthday, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.weight = weight;
    }
    public String to_string(){
        String answer = age + " " + firstName + " " + lastName + " " + birthday + " " + weight;
        return answer;
    }
}

