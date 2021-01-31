package string;

/**
 * 频繁修改字符串的性能损耗
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String str = "a";
        for(int i=0;i<1000000;i++){
            str = str + "a";
        }
        System.out.println("程序结束了");
    }
}
