package five;

public class SingletonThree {
    private SingletonThree() {}
    private static class SingletonHolder {
        private static final SingletonThree INSTANCE = new SingletonThree();
    }

    public static SingletonThree getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
