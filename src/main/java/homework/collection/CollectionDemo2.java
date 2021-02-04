package homework.collection;

import collection.Point;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合的某些操作是受元素equals方法影响的,例如contains,remove操作
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c=new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        System.out.println(c);

        Point p=new Point(1,2);
        /*
        boolean contains(Object o)--判断当前集合是否包含给定元素
         */
        boolean contains=c.contains(p);
        System.out.println("是否包含:" + contains);
        /*
        remove方法删除当前集合中给定元素equals比较为true的元素
         */
        c.remove(p);
        System.out.println(c);
    }
}
