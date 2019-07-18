// thinkinjavaex.chapter15.Ex15.java


class Ex15Base {
    private String s;
    public Ex15Base(String x) { this.s = x; }
    public String returnS() { return s; }
}

class Ex15 {
    public Ex15Base f(final String label){
        return new Ex15Base(label) {};
    }
    public static void main(String[] args){
        Ex15 e = new Ex15();
        //Ex15$1@15db9742
        // System.out.println(e.f("abc"));
        System.out.println(e.f("abc").returnS());
    }
}