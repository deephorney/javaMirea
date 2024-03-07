package six;

interface Prototype extends Cloneable {
    Prototype clone();
}

class ConcretePrototype implements Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    @Override
    public Prototype clone() {
        return new ConcretePrototype(this.field);
    }

    public void setField(String field) {
        this.field = field;
    }

    public void display() {
        System.out.println("Значение поля: " + field);
    }
}

public class PrototypeExample {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Оригинал");
        ConcretePrototype clone = (ConcretePrototype) original.clone();

        original.display();
        clone.display();

        clone.setField("Клон");

        original.display();
        clone.display();
    }
}
