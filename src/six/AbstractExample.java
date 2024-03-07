package six;

interface ProductA {
    void createA();
}

interface ProductB {
    void createB();
}

interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

class ConcreteProductA implements ProductA {
    @Override
    public void createA() {
        System.out.println("Создан конкретный продукт A");
    }
}

class ConcreteProductB implements ProductB {
    @Override
    public void createB() {
        System.out.println("Создан конкретный продукт B");
    }
}

class ConcreteFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB();
    }
}

// Пример использования
public class AbstractExample {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
        productA.createA();
        productB.createB();
    }
}

