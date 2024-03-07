package six;

enum CoffeeType {
    ESPRESSO,
    AMERICANO,
    CAFFE_LATTE,
    CAPPUCCINO
}

class Coffee {
    public void grindCoffee(){
        System.out.println("Перемалываем");
    }
    public void makeCoffee(){
        System.out.println("Кофе создается");
    }
    public void pourIntoCup(){
        System.out.println("Налили");
    }
}
class Americano extends Coffee {}
class Cappuccino extends Coffee {}
class CaffeLatte extends Coffee {}
class Espresso extends Coffee {}
class SimpleCoffeeFactory {
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new CaffeLatte();
                break;
        }
        return coffee;
    }
}

public class FactoryExample{
    public static void main(String[] args) {
        SimpleCoffeeFactory coffeeFactory = new SimpleCoffeeFactory();

        Coffee americano = coffeeFactory.createCoffee(CoffeeType.AMERICANO);
        Coffee espresso = coffeeFactory.createCoffee(CoffeeType.ESPRESSO);
        Coffee cappuccino = coffeeFactory.createCoffee(CoffeeType.CAPPUCCINO);
        Coffee caffeLatte = coffeeFactory.createCoffee(CoffeeType.CAFFE_LATTE);

        doIt(americano);
        doIt(espresso);
        doIt(cappuccino);
        doIt(caffeLatte);
    }

    private static void doIt(Coffee coffee) {
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
    }
}

