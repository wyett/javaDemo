package com.wyett.thinkinjava.chapter18;
/**
 * @author chelei
 * @date 2019/5/14 19:55
 */

import nu.xom.*;
import java.util.*;

public class People extends ArrayList<Person>{
   public People(String fileName) throws Exception {
      Document doc = new Builder().build(fileName);
      Elements elements =
              doc.getRootElement().getChildElements();
      for(int i = 0; i < elements.size(); i++)
          add(new Person(elements.get(i)));
   }
   public static void main(String[] args) throws Exception {
       People p = new People("People.xml");
       System.out.println(p);
   }
}
