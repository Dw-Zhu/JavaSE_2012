package homework.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5之后推出了一个特性:泛型
 */
public class CollectionDemo5 {
    public static void main(String[] args) {
        /*
        Collection接口定义
        public interface Collection<E>...
        E:表示的是一个类型
        而Collection中的方法,如:
        boolean add(E e)参数的类型也使用的是Collection上声明的泛型E
         */
        Collection<String> c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");

        Iterator<String> it=c.iterator();
        while (it.hasNext()){
            String str=it.next();
            System.out.println(str);
        }
    }
}
