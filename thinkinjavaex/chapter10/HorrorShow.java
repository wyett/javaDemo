// thinkinjavaex.chapter10.HorrorShow.java
// modify HorrorShow.java in chapter9

import static com.wyett.util.Print.*;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destory();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace(){}
    public void destory() {}
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBoold();
}

class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destory() {}
    public void kill() {}
    public void drinkBoold() {}
}

public class HorrorShow {
    static void u(Monster b) {
        b.menace();
    }
    static void v(DangerousMonster d) {
        d.menace();
        d.destory();
    }
    static void w(Lethal l){ l.kill(); }
    public DangerousMonster makeDragonZilla() {
        return new DangerousMonster() {
            public void menace() { print("DangerousMonster  menace()"); }
            public void destory() {print( "DangerousMonster  destory()"); }
        };
    }
    public Vampire makeVeryBadVampire() {
        return new Vampire() {
            public void menace() { print("Vampire  menace()"); }
            public void destory() { print("Vampire  destory()"); }
            public void kill() { print("Vampire  kill()"); }
            public void drinkBoold() { print("Vampire  drinkBoold()"); }
        };
    }
    
    public static void main(String[] args) {
        // DangerousMonster barney = new DragonZilla();
        // u(barney); //向上转型
        // v(barney); //
        // Vampire vlad = new VeryBadVampire();
        // u(vlad); //向上转型，两次
        // v(vlad); //
        // w(vlad); //向上转型
        HorrorShow h = new HorrorShow();
        h.u(h.makeDragonZilla());
        h.v(h.makeDragonZilla());
        h.u(h.makeVeryBadVampire());
        h.v(h.makeVeryBadVampire());
        h.w(h.makeVeryBadVampire());
        
    }
}