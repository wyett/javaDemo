// thinkinjavaex/chapter15/CargoShip19.java
import java.util.*;
import com.wyett.util.*;

class Generators{
    public static <T> Collection<T> 
    fill(Collection<T> coll, Generator<T> gen, int n){
        for(int i=0; i<n; i++)
            coll.add(gen.next());
        return coll;
    }
}

class Item{
    private final int id;
    private String description;
    private String destination;
    private double price;
    public Item(int IDnumber, String descr, String whereTo, double price){
        id = IDnumber;
        description = descr;
        destination = whereTo;
        price = price;
        System.out.println(toString());
    }
    public String toString(){
        return id + "," + description + ", price: $" + price + ", to: " + price;
    }
    public void priceChange(double change){
        price += change;
    }
    public static Generator<Item> generator =
        new Generator<Item>(){
            private Random rand = new Random();
            public Item next() {
                return new Item(rand.nextInt(1000), "Test",
                    "China", Math.round(rand.nextDouble() * 1000.0) + 0.99 );
            }
        };
}

class Shelf extends ArrayList<Item>{
    public Shelf(int nItem){
        Generators.fill(this, Item.generator, nItem);
    }
}

class StorageArea extends ArrayList<Shelf>{
    public StorageArea(int nShelves, int nItem){
        for(int i=0; i<nShelves; i++)
            add(new Shelf(nItem));
    }
}



class Deck extends ArrayList<StorageArea>{
    public Deck(int nSA, int nShelves, int nItem){
        for(int i=0; i<nSA; i++)
            add(new StorageArea(nShelves, nItem));
    }
}


class Office {}


public class CargoShip19 extends ArrayList<Deck>{
    // private Office office;
    public CargoShip19(int nDeck, int nSA, int nShelves, int nItem){
        for(int i = 0; i<nDeck; i++)
            add(new Deck(int nSA, int nShelves, int nItem));
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Deck d: this)
            for(StorageArea sa : d)
                for(Shelf s : sa)
                    for(Item it : s){
                        result.append(it);
                        result.append("\n");
                    }
        return result.toString();
    }
    pubilc static void main(String[] args){
        System.out.println(new Deck(2,2,2,2));
    }
}



