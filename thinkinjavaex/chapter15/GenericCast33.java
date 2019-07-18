//thinkinjava/chapter15/GenericCast33.java

// class FixedSizeStack<T> {
    // private int index = 0;
    // private Object[] storage;
    // public FixedSizeStack(int size){
        // storage = new Object[size];
    // }
    // int getIndex() { return index; }
    // public void push(T item) { storage[index++] = item;}
    // pop实际并没有执行任何转型。因为T被擦除到它的第一个边界
    // 默认是Object，因此pop实际只是将Object转型为Object
    // @SuppressWarnings("unchecked")
    // public T pop() { return (T)storage[--index]; }
// }

import java.util.*;

class FixedSizeStack<T>{
    private ArrayList<T> storage = new ArrayList<T>();
    public int count() { return storage.size(); }
    public void push(T item) { storage.add(item); }
    public T pop() { return storage.remove(storage.size() - 1); }
}


public class GenericCast33 {
    // public static final int SIZE = 10;
    public static void main(String[] args){
        FixedSizeStack<String> strings =
            new FixedSizeStack<String>();
        for(String s: "A B C D E F G H I J".split(" "))
            strings.push(s);
        // java.lang.ArrayIndexOutOfBoundsException: 10
        // strings.push("oops");
        int currentCount = strings.count();
        for(int i=0; i< currentCount; i++){
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}