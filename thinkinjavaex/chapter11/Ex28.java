// thinkinjavaex/chapter11/Ex28.java

import java.util.*;

public class Ex28 {
    public static void main(String[] args){
        PriorityQueue<Double> pd = 
            new PriorityQueue<Double>();
        Random rand = new Random();
        for(int i=0; i<10; i++){
            pd.offer(rand.nextDouble()*i);
        }
        while(pd.peek() != null){
            System.out.print(pd.poll() + " ");
        }
    }
}