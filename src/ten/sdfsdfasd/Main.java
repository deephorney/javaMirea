import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

// Интерфейс Programmer
interface Programmer {
    void doCoding();
}

// Реализация интерфейса Programmer - Junior
@Component
class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is coding...");
    }
}

// Реализация интерфейса Programmer - Middle
@Component
class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding...");
    }
}

// Реализация интерфейса Programmer - Senior
@Component
class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding...");
    }
}

// Конфигурационный класс для сканирования компонентов
@ComponentScan
class AppConfig {
}

public class Main {
    public static void main(String[] args) {
        // Создаем ApplicationContext на основе конфигурационного класса AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем название бина из аргументов командной строки
        String beanName = args[0];

        // Получаем бин из контекста по его названию
        Programmer programmer = (Programmer) context.getBean(beanName);

        // Вызываем метод doCoding() для бина
        programmer.doCoding();
    }
}
