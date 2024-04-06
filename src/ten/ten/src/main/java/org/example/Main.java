package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        String programmerType = args[0];
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Programmer programmer = (Programmer) context.getBean(programmerType);
        programmer.doCoding();

    }
}
