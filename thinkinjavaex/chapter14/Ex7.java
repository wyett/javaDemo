// thinkinjava/chapter14/Ex7.java

import static com.wyett.util.Print.*;

class Candy {
    static { print("loading Candy"); }
}

class Gum {
    static { print("loading Gum"); }
}

class Cookie {
    static { print("loading Cookie"); }
}

public class Ex7 {
    public static void main(String[] args) throws Exception{
        if(args.length < 1){
            System.out.println("Usage: \nclass type " +
              "should be inputed beside Candy, Gum or Cookie;");
            System.exit(0);
        }
        // coding one
        // switch(args[0]){
            // case "Candy":
                // new Candy();
                // break;
            // case "Gum":
                // new Gum();
                // break;
            // case "Cookie":
                // new Cookie();
                // break;
            // default:
                // print("Unrecogernized class");
                // break;
        // }
        //coding two
        Class c = null;
        try{
            c.forName(args[0]);
            print(args[0]);
        }catch(ClassNotFoundException e){
            print("couldn't find " + args[0]);
        }

    }
}

