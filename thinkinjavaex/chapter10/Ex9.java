// thinkinjavaex.chapter10.Parcel6.java

interface Ex9Interface {
    void say(String s);
}

public class Ex9 {
    // public String s;
    Ex9Interface f(){
        class Ex9Inner implements Ex9Interface {
            public void say(String s){
                System.out.println(s);
            }
        }
        return new Ex9Inner();
    }
    public static void main(String[] args){
        Ex9 e = new Ex9();
        e.f().say("hi");
    }
}