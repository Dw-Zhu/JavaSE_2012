package homework.test;

import java.io.File;

/**
 * 使用File创建一个目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        File dir=new File("demo");
        if(dir.exists()){
            System.out.println("该文件目录已存在!");
        }else{
            dir.mkdir();
            System.out.println("创建完成!");
        }
    }
}
