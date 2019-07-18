// thinkinjavaex/chapter11/NonCollectionSequence.java

import java.util.*;
import com.wyett.typeinfo.pets.*;

class PetSequence {
    protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence 
    extends PetSequence implements Iterable{
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            public boolean hasNext() {
                return index < pets.length;
            }
            public Pet next(){
                return pets[index++];
            }
            public void remove(){
                throw new UnsupportedAddressTypeException();
            }
        };
    }
    public Iterable<Pet> resvered(){
        return new Iterable<Pet>() {
            public Iterator<Pet> Iterator(){
                return new Iterator<Pet>(){
                    int current = pets.length -1;
                    public boolean hasNext(){
                        return current > -1;
                    }
                    public boolean next(){
                        return pets[current--];
                    }
                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<Pet> randomized(){
        return Iterable<Pet>() {
            public Iterator<Pet> iterator(){
                List<Pet> shuffled =
                    new ArrayList(Arrays.asList(pets));
                Collection.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }
    public static void main(String[] args){
        NonCollectionSequence ns = new NonCollectionSequence();
        System.out.print("normal:")
        for(Pet p: ns)
            System.out.print(p + " ");
        System.out.println();
        System.out.print("reversed:")
        for(Pet p: ns.resvered())
            System.out.print(p + " ");
        System.out.println();
        System.out.print("randomized:")
        for(Pet p: ns.randomized())
            System.out.print(p + " ");
        System.out.println();
    }
}