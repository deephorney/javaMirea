package eight;


import java.util.ArrayList;
import java.util.List;

interface Mediator {
    void sendMessage(String message, Colleague colleague);
}

abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void receive(String message);
    public abstract void send(String message);
}

class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;
    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }
    @Override
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague col : colleagues) {
            if (col != colleague) {
                col.receive(message);
            }
        }
    }
}

class ConcreteColleague extends Colleague {
    public ConcreteColleague(Mediator mediator) {
        super(mediator);
    }
    @Override
    public void receive(String message) {
        System.out.println("Пришло: " + message);
    }
    @Override
    public void send(String message) {
        System.out.println("Отправили: " + message);
        mediator.sendMessage(message, this);
    }
}
public class MainBroker {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague colleague1 = new ConcreteColleague(mediator);
        ConcreteColleague colleague2 = new ConcreteColleague(mediator);

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);

        colleague1.send("Привет2!");
        colleague2.send("Привет1!");
    }
}
