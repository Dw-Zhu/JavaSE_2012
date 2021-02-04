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

        Collection c3=new ArrayList();
        c3.add("android");
        c3.add("c++");
        System.out.println("c3:"+c3);
        /*
        boolean containsAll(Collection c)
        判断当前集合是否包含给定集合中所有的元素,全包含则返回true
         */
        boolean containsAll=c1.containsAll(c3);
        System.out.println("全包含:"+containsAll);

        /*
        删除当前集合中与给定集合的共有元素
         */
        c1.removeAll(c3);
        System.out.println("c1:"+c1);//c1中与c3共有的元素被删除了
        System.out.println("c3:"+c3);//c3不收影响
    }
}
