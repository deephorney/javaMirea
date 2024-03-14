package eight;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface Container {
    Iterator getIterator();
}

class ConcreteIterator implements Iterator {
    private int[] array;
    private int position;

    public ConcreteIterator(int[] array) {
        this.array = array;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < array.length;
    }

    @Override
    public Integer next() {
        if (this.hasNext()) {
            return array[position++];
        } else {
            return null;
        }
    }
}

class ConcreteContainer implements Container {
    private int[] array;

    public ConcreteContainer(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(array);
    }
}

public class MainItterator {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        Container container = new ConcreteContainer(numbers);
        Iterator iterator = container.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
