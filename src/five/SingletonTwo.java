package five;

public class SingletonTwo {
        private static SingletonTwo instance;
        private SingletonTwo() {}
        public static synchronized SingletonTwo getInstance() {
            if (instance == null) {
                instance = new SingletonTwo();
            }
            return instance;
        }
}
