package practiceOne;

import java.util.function.Predicate;

public class Prac implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return (number > 0) && ((number & (number - 1)) == 0);
    }

    public static void main(String[] args) {
        Prac pow = new Prac();

        System.out.println(pow.test(8));
        System.out.println(pow.test(16));
        System.out.println(pow.test(10));
    }
}

