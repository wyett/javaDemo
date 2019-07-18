// thinkinjavaex/chapter12/Sequence12.java

interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence12{
    private Object[] items;
    private int next = 0;
    public Sequence12(int size){
        items = new Object[size];
    }
    public void add(Object x) throws ArrayIndexOutOfBoundsException{
        if(next == items.length)
            throw new ArrayIndexOutOfBoundsException();
        if(next < items.length)
            items[next++] = x;
    }
    private class Sequence12Selector implements Selector {
        private int i = 0;
        public boolean end(){
            return i == items.length;
        }
        public Object current(){
            return items[i];
        }
        public void next(){
            if(i < items.length)
                i++;
        }
    }
    public Selector selector(){
        return new Sequence12Selector();
    }
    public static void main(String[] args){
        Sequence12 s = new Sequence12(10);
        for(int i=0; i< s.items.length; i++)
            s.add(Integer.toString(i));
        Selector ss = s.selector();
        while(!ss.end()){
            System.out.println(ss.current());
            ss.next();
        }
        System.out.println("-------");
        s.add(Integer.toString(10));
    }
    
}