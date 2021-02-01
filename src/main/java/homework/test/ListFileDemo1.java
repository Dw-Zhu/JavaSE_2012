package homework.test;

import java.io.File;

/**
 * 获取一个目录中的所有子项
 */
public class ListFileDemo1 {
    public static void main(String[] args) {
        File dir=new File(".");
        if(dir.isDirectory()){
            File[] subs=dir.listFiles();
            System.out.println(subs.length);
            for(int i=0;i<subs.length;i++){
                System.out.println(subs[i].getName());
            }
        }
    }
}
