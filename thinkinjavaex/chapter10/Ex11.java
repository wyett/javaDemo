// thinkinjava/chapter10/Ex11.java

class Ex11 {
    private class Ex11Base implements Ex11Interface {
        public void f(){
            System.out.println("Ex11Base.f()");
        }
    }
    public Ex11Interface callEx11Base(){
        return new Ex11Base();
    }
    public static void main(String[] args){
        Ex11 e = new Ex11();
        e.callEx11Base().f();
    }
}

