// thinkinjavaex/chapter11/Ex27.java

import java.util.*;

class Command {
    private String s = null;
    public Command(String str){
        this.s = str;
    }
    public void printS(){
        System.out.println(s);
    }
}

class CreateCommand{
    public Queue<Command> returnQueue(String pre, int n){
        Queue<Command> qc = new LinkedList<Command>();
        String s = null;
        for(int i=0; i<n; i++){
            s =  pre + i;
            qc.offer(new Command(s));
        }
        return qc;
    }
}

public class Ex27{
    public static void printQueue(Queue<Command> q){
        while(q.peek() != null){
            q.poll().printS();
        }
    }
    public static void main(String[] args){
        CreateCommand cc = new CreateCommand();
        // Queue<Command> qc = cc.returnQueue("test", 10);
        // while(qc.peek() != null)
            // System.out.println(qc.remove());
        printQueue(cc.returnQueue("test", 10));
        
    }
}