package homework.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
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
	}
}
