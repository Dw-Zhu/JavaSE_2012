package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class Plate {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw=new PrintWriter("plateNumber.txt","UTF-8");
        for(int i=0;i<10;i++){
            pw.println(getPlate());
        }
        System.out.println("生成完毕!");
        pw.close();
    }
    public static StringBuffer getPlate(){
        Random random=new Random();

        //车牌号开头
        String[] carNumberHead={"渝A","渝B","渝C","渝D","渝F","渝G","渝H"};

        //从车牌开头数组随机获取一个字符串,并保存在head中
        String head=carNumberHead[random.nextInt(carNumberHead.length)];

        //定义一个由26个字母组成的车牌数组
        String[] carLetter={"A","B","C","D","E","F","G","H","I","J","K", "L","M",
                "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        //定义一个由0-9的数字组成的车牌数组
        String[] carDigit={"0","1","2","3","4","5","6","7","8","9"};

        //创建一个长度为5的字符数组
        String[] carNumberArray=new String[5];

        //给numberArray数组赋值
        for(int i=0;i<5;i++){
            int type=random.nextInt(5);
            if(type<4){
                carNumberArray[i]=carDigit[random.nextInt(carDigit.length)];
            }else {
                carNumberArray[i]=carLetter[random.nextInt(carLetter.length)];
            }
        }

        //将字符数组转换为字符串
        String carNumber= Arrays.toString(carNumberArray);

        //车牌拼接
        StringBuffer plate=new StringBuffer(head);

        //返回车牌号
        return plate.append(carNumber);
    }
}
