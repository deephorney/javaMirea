package ru.mirea.trenatsat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoPrinter implements CommandLineRunner {

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String lastName;

    @Value("${student.group}")
    private String group;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("VALUE");
        System.out.println("Student Name: " + name);
        System.out.println("Student Last Name: " + lastName);
        System.out.println("Student Group: " + group);
    }
}
