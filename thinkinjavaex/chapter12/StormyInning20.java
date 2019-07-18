// thinkinjava/chapter12/StormyInning20.java

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
class UmpireArgument extends BaseballException {}
class ThrownFromGame extends UmpireArgument {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul, UmpireArgument;
    public void questionableCall() throws UmpireArgument {}
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning20 extends Inning implements Storm{
    public StormyInning20()
    throws RainedOut, BaseballException {}
    public StormyInning20(String s)
    throws Foul, BaseballException {}
    // 被覆盖的方法未抛出RainedOut
    // public void event() throws RainedOut {}
    public void rainHard() throws RainedOut {}
    public void event() {}
    public void atBat() throws PopFoul {}
    public static void main(String[] args){
        try {
            StormyInning20 si = new StormyInning20();
            si.atBat();
        } catch(PopFoul e){
            System.out.println("Pop foul");
        } catch(RainedOut e){
            System.out.println("Rained out");
        } catch(BaseballException e){
            System.out.println("Generic baseball exception");
        }
        try {
            Inning i = new StormyInning20();
            i.atBat();
        } catch(Strike e){
            System.out.println("Strike");
        } catch(Foul e){
            System.out.println("Foul");
        } catch(RainedOut e){
            System.out.println("RainedOut");
        } catch(BaseballException e){
            System.out.println("Generic baseball exception");
        }
    }
}
