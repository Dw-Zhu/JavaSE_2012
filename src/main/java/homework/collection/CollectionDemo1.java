package homework.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JAVA集合框架
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        /*
        int size()--返回当前集合的元素个数
         */
        int size=c.size();
        System.out.println("size:" + size);
        /*
        boolean isEmpty()--判断当前集合是否为空集,为空返回true
         */
        boolean isEmpty=c.isEmpty();
        System.out.println("是否为空集:" + isEmpty);

        /*
        清空合集
         */
        c.clear();

        System.out.println(c);
        System.out.println("size:" + c.size());
        System.out.println("是否为空集:" + c.isEmpty());


    }
}
