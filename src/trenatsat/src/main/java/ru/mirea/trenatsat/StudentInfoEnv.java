package ru.mirea.trenatsat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoEnv implements CommandLineRunner {

    @Autowired
    private Environment env;

    @Override
    public void run(String... args) throws Exception {
        String name = env.getProperty("student.name");
        String lastName = env.getProperty("student.last_name");
        String group = env.getProperty("student.group");

        System.out.println("ENV");
        System.out.println("Student Name: " + name);
        System.out.println("Student Last Name: " + lastName);
        System.out.println("Student Group: " + group);
    }
}
