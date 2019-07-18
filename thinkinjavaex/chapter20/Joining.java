package thinkinjava.concurrency_ex;
import static com.wyett.util.Print.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/12 20:56
 * @description：TODO
 * @modified By：
 * @version: $
 */
class Sleeper extends Thread {
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try {
            sleep(duration);
        } catch(InterruptedException e){
            print(getName() + " was interrupted. " +
                "isInterrupted(): " + isInterrupted());
        }
        print(getName() + " has awakened");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super(name);
        this.sleeper = sleeper;
        start();
    }
    public void run() {
        try {
            //等到sleeper醒来
            sleeper.join();
        }catch(InterruptedException e) {
            print("Interrupted");
        }
        print(getName() + ": join completed");
    }
}

public class Joining {
    public static void main(String[] args){
        Sleeper sleepy = new Sleeper("Sleepy", 1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy),
                doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
