package socket;

import java.util.Arrays;

/**
 * 测试从数组中删除指定元素
 */
public class Test {
    public static void main(String[] args) {
        int[] allOut={21,56,84,6,3,4,88,9,7,74,22,65};
        int pw=84;
        System.out.println(Arrays.toString(allOut));
        //将pw从数组allOut中删除
        for(int i=0;i<allOut.length;i++){
            if(allOut[i]==pw){
                allOut[i]=allOut[allOut.length-1];
                break;
            }
        }
        allOut=Arrays.copyOf(allOut,allOut.length-1);

        System.out.println(Arrays.toString(allOut));
    }
}
