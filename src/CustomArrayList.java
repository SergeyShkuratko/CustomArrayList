public class CustomArrayList<T> {

    private Object[] array;
    private static final int START_CAPACITY = 10;
    private int currentCapacity = START_CAPACITY;
    private int currentIndex = 0;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public CustomArrayList() {
        this.array = new Object[START_CAPACITY];
    }

    public void add(T element) {
        if (currentIndex > array.length - 1) {
            increaseArray();
        }
        array[currentIndex] = element;
        size++;
        currentIndex++;

    }

    private void increaseArray() {
        Object[] newArray = new Object[currentCapacity * 2];
        System.arraycopy(array, 0, newArray, 0, currentCapacity);
        currentCapacity = currentCapacity * 2;
        array = newArray;
    }

    public void addByIndex(T element, int index) {
        if (size + 1 >= array.length) {
            increaseArray();
        }
        Object[] beforeIndexArray = new Object[index + 1];
        Object[] afterIndexArray = new Object[array.length - index - 1];
        System.arraycopy(array, 0, beforeIndexArray, 0, index);
        System.arraycopy(array, index, afterIndexArray, 0, array.length - index - 1);
        beforeIndexArray[index] = element;
        System.arraycopy(beforeIndexArray, 0, array, 0, beforeIndexArray.length);
        System.arraycopy(afterIndexArray, 0, array, index + 1, afterIndexArray.length);
        size++;
    }

    public void setByIndex(T element, int index) {
        checkIndex(index);
        array[index] = element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > array.length) {
            throw new RuntimeException("Incorrect index");
        }
    }

    public void removeByIndex(int index) {
        throw new UnsupportedOperationException();
    }

    public void remove(T element) {
        throw new UnsupportedOperationException();
    }

    public Object getByIndex(int index) {
        checkIndex(index);
        return array[index];
    }

    public boolean contains(T element) {
        if (indexOf(element) >= 0) {
            return true;
        }
        return false;
    }

    public int indexOf(T element) {
        int i = 0;
        for (Object val : array) {
            if (element.equals(val)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
