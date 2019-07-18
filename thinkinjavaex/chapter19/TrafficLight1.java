// thinkinjava/chapter19/TrafficLight1.java
package thinkinjavaex.chapter19;

import static com.wyett.util.Print.*;
import static thinkinjavaex.chapter19.Signal.*;

public class TrafficLight1 {
    Signal color = RED;
    public void change() {
        switch(color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }
    public static void main(String[] args) {
        TrafficLight1 t = new TrafficLight1();
        for(int i = 0; i < 7; i++){
            print(t);
            t.change();
            // print(t);
        }
    }
}