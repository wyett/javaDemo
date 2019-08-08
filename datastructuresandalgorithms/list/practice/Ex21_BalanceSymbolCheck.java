package datastructuresandalgorithms.list.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 10:17
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex21_BalanceSymbolCheck<E> {
    private class SymbolPair<String> {
        String leftStr;
        String rightStr;

        SymbolPair(String leftStr, String rightStr) {
            this.leftStr = leftStr;
            this.rightStr = rightStr;
        }
    }
    private List<SymbolPair<String>> symbolList;

    public Ex21_BalanceSymbolCheck() {
        initSymbolPairList();
    }

    public void addSymbolPair(String l, String r) {
        symbolList.add(new SymbolPair<>(l, r));
    }

    public void initSymbolPairList() {
        addSymbolPair("/*", "*/");
        addSymbolPair("(", ")");
        addSymbolPair("[", "]");
        addSymbolPair("{", "}");
    }

    public String getSymbolHalf(String s) {
        String anotherHalf = "";
        java.util.Iterator<SymbolPair<String>> symbolItr = symbolList.iterator();
        while(symbolItr.hasNext()) {
            SymbolPair<String> currentPair = symbolItr.next();
            if(currentPair.leftStr == s) {
                anotherHalf = currentPair.rightStr;
                break;
            } else if (currentPair.rightStr == s) {
                anotherHalf = currentPair.leftStr;
                break;
            }
        }
        return anotherHalf;
    }

    public boolean checkBalanceSymbol(List<String> cur) {
        Stack<String> se = new Stack<>();
        Iterator<String> inputList = cur.iterator();
        while(inputList.hasNext()) {
            String nextItem = inputList.next();
            if(getSymbolHalf(nextItem).equals(se.peek())) {
                se.pop();
            } else {
                se.push(nextItem);
            }
        }
        return se.size() == 0;
    }
}









