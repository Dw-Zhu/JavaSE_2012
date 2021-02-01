package homework.test;

import java.io.File;

/**
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        File file=new File("test.txt");
        if(file.exists()){
            file.delete();
            System.out.println("删除成功!");
        }else {
            System.out.println("该文件不存在!");
        }
    }
}
