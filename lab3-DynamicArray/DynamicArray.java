public class DynamicArray<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(){
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(T element){
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        size++;
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removed= data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null; 
        size--;
        return removed;
    }
    
    public int size(){
        return size;
    }   

    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = data.length * 2;
        T[] newData = (T[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}