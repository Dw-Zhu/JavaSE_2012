package homework.day11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 生成10个0-100的随机数并存入一个List集合中并输出
 * 之后将集合元素翻转:第一个在最后一个，最后一个在第一个。
 * 以此类推，并输出
 * 
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++){
            int randNum=(int)(Math.random()*101);
            if(list.contains(randNum)){
                i--;
                continue;
            }
            list.add(randNum);
        }
        System.out.println(list);
        Collections.reverse(list);
//        for (int i=0;i<list.size()/2;i++){
//            Integer in=list.get(i);
//            in=list.set(list.size()-1-i,in);
//            list.set(i,in);
//        }
        System.out.println(list);
    }
}
