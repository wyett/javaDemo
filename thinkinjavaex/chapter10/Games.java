// thinkinjava/chapter10/Games.java

import java.util.*;
import static com.wyett.util.Print.*;

interface Game {
    void play();
}

interface GameFactory {
    Game getGame();
}

class CoinToss implements Game {
    Random rand = new Random();
    public void play(){
        switch(rand.nextInt(6)) {
            case 0:
                print("");
                return;
            case 1:
                print("");
                return;
            default:
                print("");
                return;
        }
    }
    public static GameFactory fact = 
        new GameFactory(){
            public Game getGame(){
                return new CoinToss();
            }
        };
}

class DiceThrow implements Game {
    Random rand = new Random();
    public void play(){
        print("point is " + rand.nextInt(6) + 1 );
    }
    public static GameFactory fact = 
        new GameFactory(){
            public Game getGame(){
                return new DiceThrow();
            }
        };
}

public class Games {
    public static void playGame(GameFactory factory){
        Game g = factory.getGame();
        g.play();
    }
    public static void main(String[] args){
        playGame(CoinToss.fact);
        playGame(DiceThrow.fact);
    }
}






