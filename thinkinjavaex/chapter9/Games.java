// thinkinjavaex/chapter9/Games.java

import java.util.*;
// import java.util.*;
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
        print("Toss Coin");
        switch(rand.nextInt(2)){
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
}

class CoinTossFactory implements GameFactory {
    public Game getGame(){
        return new CoinToss();
    }
}

class DiceThrow implements Game {
    Random rand = new Random();
    public void play(){
        print("point is " + rand.nextInt(6) + 1 );
    }
}

class DiceThrowFactory implements  GameFactory {
    public Game getGame() {
        return new DiceThrow();
    }
}

public class Games {
    public static void playGame(GameFactory factory){
        Game g = factory.getGame();
        g.play();
    }
    public static void main(String[] args){
        playGame(new CoinTossFactory());
        playGame(new DiceThrowFactory());
    }
}







