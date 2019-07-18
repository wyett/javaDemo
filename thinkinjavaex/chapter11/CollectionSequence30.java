// thinkinjavaex.chapter11.CollectionSequence30.java

import com.wyett.typeinfo.pets.*;
import java.util.*;

public class CollectionSequence30 implement Collection<Pet> {
    private Pet[] pets = Pets.createArray(8);
    public int size() { return pets.length; }
    public Iterator<Pet> iterator(){
        return new Iterator<Pet>(){
            private int index = 0;
            public boolean hasNext(){
                return index < pets.length;
            }
            public Pet next(){
                return pets[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        }
    }
    public void clear(){
        if(this.size()!=0){
            for(Pet p: pets)
                p = null;
        }
    }
    
    public void retainAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
    public void removeAll(Collection<?> c){
        throw new UnsupportedOperationException();
    }
    public boolean addAll(Collection<? extends Pet> c){
        throw new UnsupportedOperationException();
    }
    public boolean contains(Object o){
        throw new UnsupportedOperationException();
    }
    public boolean isEmpty(){
        return (this.size()==0? true: false);
    }
    public boolean containsAll(Collection<?> c){
        return new UnsupportedOperationException();
    }
    public boolean remove(Object o){
        return new UnsupportedOperationException();
    }
    public boolean add(Pet p){
        return new UnsupportedOperationException();
    }
    public Object[] toArrays(){
        return pets;
    }
    public <T> T[] toArrays(T[] a){
        return new UnsupportedOperationException();
    }
    public static void main(String[] args){
        CollectionSequence30 c = new CollectionSequence30();
        InterfaceVsIterator.display(c);
        InterfaceVsIterator.display(c.iterator());
    }
}
