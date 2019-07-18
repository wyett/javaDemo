// thinkinjavaex/chapter15/storycharacters/StoryCharactersGenerators.java
package thinkinjavaex.chapter15.storycharacters;
// import thinkinjavaex.chapter15.storycharacters.*;
import java.util.*;
import com.wyett.util.*;

public class StoryCharactersGenerator
implements Generator<StoryCharacters>, Iterable<StoryCharacters> {
    private Class[] types = { GoodGuys.class, BadGuys.class };
    private static Random rand = new Random();
    public StoryCharactersGenerator() {}
    private int size = 0;
    public StoryCharactersGenerator(int sz) {
        size = sz;
    }
    public StoryCharacters next() {
        try{
            return (StoryCharacters)
                types[rand.nextInt(types.length)].newInstance();
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    class StoryCharactersIterator
    implements Iterator<StoryCharacters> {
        int count = size;
        public boolean hasNext() { return count> 0; }
        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    public Iterator<StoryCharacters> iterator(){
        return new StoryCharactersIterator();
    }
    public static void main(String[] args){
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for(int i=0; i<2; i++)
            System.out.println(gen.next());
        for(StoryCharacters c : new StoryCharactersGenerator(2))
            System.out.println(c);
    }
} 

