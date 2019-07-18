// thinkinjavaex.chapter10.Ex10.java

interface Ex10Interface {
    void say(String s);
}

public class Ex10 {
    Ex10Interface f(Boolean b){
        if(b){
            class Ex10Inner implements Ex10Interface {
                public void say(String s){
                    System.out.println(s);
                }
            }
            return new Ex10Inner();
        }
        return null;
    }
    public static void main(String[] args){
        Ex10 e = new Ex10();
        e.f(true).say("hi");
    }
}