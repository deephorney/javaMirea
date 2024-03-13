package seven;

interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Запрос");
    }
}
class Proxy implements Subject {
    private RealSubject realSubject;
    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}

public class MainProxy {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}

