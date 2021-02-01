package homework.test;

import java.io.File;

/**
 * 删除目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir=new File("./demo");
        if(dir.exists()){
            dir.delete();
            System.out.println("删除成功!");
        }else{
            System.out.println("目录不存在!");
        }
    }
}
