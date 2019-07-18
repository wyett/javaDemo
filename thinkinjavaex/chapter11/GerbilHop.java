// thinkinjavaex/chapter11/GerbilHop.java
import java.util.*;

class Gerbil{
    private int gerbilNumber;
    public Gerbil(int gerbilNum) {
        this.gerbilNumber = gerbilNum;
    }
    public void hop(){
        System.out.println("Gerbil " + gerbilNumber + " is jumping");
    }
}

public class GerbilHop{
    public static void main(String[] args){
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for(int i = 0;i<3;i++)
            gerbils.add(new Gerbil(i));
        for(int i = 0;i<gerbils.size();i++)
            gerbils.get(i).hop();
        for(Gerbil g: gerbils)
            g.hop();
    }
}