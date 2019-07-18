// thinkinjavaex/chapter15/Ex2.java

class Robat {
    private String name;
    public Robat(String name) { this.name = name; }
    public String toString(){
        return name;
    }
}

public class Ex2<T>{
    private T a, b, c;
    public Ex2(T a, T b, T c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setA(T a){ this.a = a; }
    public void setB(T b){ this.b = b; }
    public void setC(T c){ this.c = c; }
    public T getA(){ return a; }
    public T getB(){ return b; }
    public T getC(){ return c; }
    public String toString(){
        return a + ", " + b + ", " + c;
    }
    public static void main(String[] args){
        Robat a = new Robat("aaa");
        Robat b = new Robat("bbb");
        Robat c = new Robat("ccc");
        Ex2<Robat> ex2 = new Ex2<Robat>(a, b, c);
        System.out.println(ex2);
    }
}