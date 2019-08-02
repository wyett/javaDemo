package datastructuresandalgorithms.list.example;

import java.util.*;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/1 16:53
 * @description: also called reverse polish, acturally,
 * there is no nessary to know the properity rule.
 */

public class PostfixCalculate {
    private PriorityList<Character> plc;
    public PostfixCalculate() {
        plc = new PriorityList<>();
        plc.add('(', 6);
        plc.add('*', 5);
        plc.add('/', 4);
        plc.add(')', 3);
        plc.add('-', 2);
        plc.add('+', 1);
    }

    public static void main(String[] args) {
        PostfixCalculate pc = new PostfixCalculate();
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            java.util.List<Character> lc = new ArrayList<Character>(
                    Arrays.asList(scan.nextLine().chars()
                    .mapToObj(c -> (char)c)
                            .toArray(Character[]:: new)));
            System.out.println(pc.postfixCalculate(pc.infixToPostfix(lc)));
        }
    }

    /**
     * transfer from infix into postfix
     * @param infix normal expression as List<Charactor>
     * @return postfix
     */
    public List<Character>
    infixToPostfix(List<Character> infix) throws EmptyStackException{
        System.out.println(infix);
        List<Character> lpostfix = new ArrayList<>();
        Stack<Character> sc = new Stack<Character>();

        for(Character cinfix : infix) {
            if(plc.contains(cinfix) && cinfix == '(') {
                // if cinfix is '(', push into stack
                sc.push(cinfix);
            }else if(plc.contains(cinfix) && cinfix == ')') {
                /**
                 * if cinfix is ')' and size > 0, pop from stack
                 * and push into lpostfix, while size > 0
                 */
                while (sc.size() > 0 && sc.peek() != '(') {
                    lpostfix.add(sc.pop());
                }
                while (sc.size() > 0 && sc.peek() == '(') {
                    sc.pop();
                }
            } else if (plc.contains(cinfix) && cinfix != '(' && cinfix != ')') {
                /**
                 * if priority value of top elem is less than priority
                 * value of cinfix, push cinfix into sc;
                 * else, pop elem and add it into lpostfix, util priority
                 * value of top elem is less than priority, then push cinfix
                 * into sc;
                 */
                while(sc.size() > 0 && plc.getPriorityValue(sc.peek()) >=
                        plc.getPriorityValue(cinfix)) {
                    if(sc.peek() != '(' ) {
                        lpostfix.add(sc.pop());
                    } else {
                        break;
                    }
                }
                sc.push(cinfix);
            } else {
                lpostfix.add(cinfix);
            }
        }
        // pop elem remain in sc and push into lpostfix
        while(sc.size() > 0) {
            lpostfix.add(sc.pop());
        }

        return lpostfix;
    }

    /**
     * @param postfix List<Charactor> of posifix to calculate
     * @return final result
     */
    public int postfixCalculate(List<Character> postfix) throws EmptyStackException{
        System.out.println(postfix);
        Stack<Integer> si = new Stack<>();

        for(Character s: postfix ) {
            if(plc.contains(s) && si.size() > 1) {
                int firstElem =  si.pop();
                int secondElem = si.pop();
                si.push(calculate(secondElem, firstElem, s));
                System.out.println(si + "," + firstElem + "," + secondElem);
            } else if(!plc.contains(s)) {
                if(Character.isDigit(s)){
                    si.push(Integer.parseInt(String.valueOf(s)));
                }
                System.out.println(si);
            }
        }

        return si.pop();
    }

    /**
     * @param elem1
     * @param elem2
     * @param operator
     * @return
     */
    public int calculate(int elem1, int elem2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = elem1 + elem2;
                break;
            case '-':
                result = elem1 - elem2;
                break;
            case '*':
                result = elem1 * elem2;
                break;
            case '/':
                result = elem1 / elem2;
                break;
            default:
        }
        return result;
    }
}
