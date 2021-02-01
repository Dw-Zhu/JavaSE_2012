package homework.test;

import java.io.File;

/**
 * 创建一个多及目录
 */
public class MkDirsDemo {
    public static void main(String[] args) {
        File dirs=new File("./a/b/c/d/e/f");
        if(dirs.exists()){
            System.out.println("该目录已存在!");
        }else{
            dirs.mkdirs();
            System.out.println("目录创建完成!");
        }
    }
}
