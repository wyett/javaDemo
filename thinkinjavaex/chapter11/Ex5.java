// thinkinjavaex/chapter11/Ex5.java

import java.util.*;
import static com.wyett.util.Print.*;

public class Ex5 {
    public static List<Integer> listOfRandomInteger(int length, int n){
        Random rand = new Random();
        List<Integer> cc = new ArrayList<Integer>();
        for(int i=0; i< length; i++)
            cc.add(rand.nextInt(n));
        return cc;
    }
    public static void main(String[] args){
        Random rand = new Random();
        List<Integer> cc = listOfRandomInteger(7, 10);
        print("1: " + cc);
        //add instance
        Integer h = new Integer(rand.nextInt(10));
        cc.add(h);
        print("2: " + cc);
        print("3: " + cc.contains(h));
        //remove the first instance equals to  h
        cc.remove(h);
        print("3.5: " + cc);
        //get
        Integer g = cc.get(2);
        print("4: " + g + " " + cc.indexOf(g));
        //
        Integer j = new Integer(rand.nextInt(10));
        print("5: " + j + " " + cc.indexOf(j));
        print("5.5: " + cc);
        print("6: " + cc.remove(j));
        print("6.5: " + cc);
        print("7: " + cc.remove(g));
        print("8: " + cc);
        //
        cc.add(3, new Integer(rand.nextInt(10)));
        print("9: "+ cc);
        List<Integer> subcc = cc.subList(1,4);
        print("sublist: " + subcc);
        print("10: " + cc.containsAll(subcc));
        // sort sub elements
        Collections.sort(subcc);
        print("Sorted List: " + subcc);
        print("11: " + cc.containsAll(subcc));
        print("11.25: " + cc);
        //shuffle subcc with rand
        Collections.shuffle(subcc, rand);
        print("11.5: " + cc);
        print("shuffled subcc: " + subcc);
        print("12: " + cc.containsAll(subcc));
        //copy
        List<Integer> copy = new ArrayList<Integer>(cc);
        print("12.5: " + cc);
        subcc = Arrays.asList(cc.get(1), cc.get(4));
        print("sub: " + subcc);
        copy.retainAll(subcc);
        print("13: " + copy);
        //remove
        copy = new ArrayList<Integer>(cc);
        copy.remove(2);
        print("14: " + copy);
        copy.removeAll(subcc);
        print("15: " + copy);
        //size
        if(copy.size() > 1)
            copy.set(1, 8);
        print("16: " + copy);
        if(copy.size() > 2)
            copy.addAll(2, subcc);
        print("17:" + copy);
        print("18: " + cc.isEmpty());
        cc.clear();
        print("19: " + cc);
        print("20: " + cc.isEmpty());
        cc.addAll(listOfRandomInteger(4,10));
        print("21: " + cc);
        Object[] o = cc.toArray();
        print("22: " + o[3]);
        Integer[] ia = cc.toArray(new Integer[0]);
        print("23: " + ia[3]);
    }
}



/*
1: [3, 5, 9, 6, 9, 6, 2]
2: [3, 5, 9, 6, 9, 6, 2, 1]
3: true
3.5: [3, 5, 9, 6, 9, 6, 2]
4: 9 2
5: 2 6
5.5: [3, 5, 9, 6, 9, 6, 2]
6: true
6.5: [3, 5, 9, 6, 9, 6]
7: true
8: [3, 5, 6, 9, 6]
9: [3, 5, 6, 8, 9, 6]
sublist: [5, 6, 8]
10: true
Sorted List: [5, 6, 8]
11: true
11.25: [3, 5, 6, 8, 9, 6]
11.5: [3, 6, 8, 5, 9, 6]
shuffled subcc: [6, 8, 5]
12: true
12.5: [3, 6, 8, 5, 9, 6]
sub: [6, 9]
13: [6, 9, 6]
14: [3, 6, 5, 9, 6]
15: [3, 5]
16: [3, 8]
17:[3, 8]
18: false
19: []
20: true
21: [9, 6, 1, 2]
22: 2
23: 2
*/