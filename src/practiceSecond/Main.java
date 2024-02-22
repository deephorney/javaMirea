package practiceSecond;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Human[] humans = {
                new Human(12, "Vladimir", "Last", LocalDate.of(1999, 5, 11), 70),
                new Human(15, "Artem", "First", LocalDate.of(1990, 10, 7), 75),
                new Human(17, "Anton", "Gold", LocalDate.of(2001, 3, 16), 80),
                new Human(50, "Ivan", "Term", LocalDate.of(2006, 10, 1), 40),
        };

        System.out.println("Сортировка по последней букве фамилии");
        Arrays.stream(humans)
                .sorted(Comparator.comparing(human -> human.lastName.substring(human.lastName.length() - 1)))
                .forEach(human -> System.out.println(human.to_string()));

        System.out.println("\nФильтрация по признаку «возраст больше, чем вес»");
        Arrays.stream(humans)
                .filter(human -> human.age > human.weight)
                .forEach(human -> System.out.println(human.to_string()));

        System.out.println("\nCортировка по дате рождения");
        Arrays.stream(humans)
                .sorted(Comparator.comparing(human -> human.birthday))
                .forEach(human -> System.out.println(human.to_string()));

        int productOfAges = Arrays.stream(humans)
                .mapToInt(human -> human.age)
                .reduce(1, (product, age) -> product * age);
        System.out.println("\nПроизведение возрастов: " + productOfAges);
    }
}
