package homework.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合之间的操作
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:" + c1);

        Collection c2=new HashSet();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2:" + c1);

        /*
        boolean addAll(Collection c)
        将给定集合的所有元素添加后当前集合发生了变化则返回true
         */
        c1.addAll(c2);
        System.out.println("c1:" + c1);

        c1.add(c2);
        System.out.println("c1:"+c1);



    }
}
