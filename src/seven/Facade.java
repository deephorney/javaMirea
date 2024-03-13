package seven;
class ComputerFacade {
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        memory.load();
        hardDrive.read();
    }
}
class Memory {
    public void load() {
        System.out.println("Память: Загрузка");
    }
}
class HardDrive {
    public void read() {
        System.out.println("Жесткий диск: Чтение");
    }
}

public class Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
