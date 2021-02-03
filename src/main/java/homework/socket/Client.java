package homework.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 聊天客户端
 */
public class Client {
    private Socket socket;

    //构造方法,用来初始化客户端
    public Client(){
        try {
            System.out.println("正在链接服务端...");
            socket=new Socket("127.0.0.1",8088);
            System.out.println("与服务端建立链接!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //客户端开始工作的方法
    public void start(){
        ServerHandler handler=new ServerHandler();
        Thread t=new Thread(handler);
        t.setDaemon(true);
        t.start();
        try(
            PrintWriter pw=new PrintWriter(
                new BufferedWriter(
                     new OutputStreamWriter(
                          socket.getOutputStream(),"UTF-8"
                     )
                ),true
            );
        ){
            //通过输出流给服务端发送一句话
            Scanner scanner=new Scanner(System.in);
            System.out.println("请开始输入内容,单独输入exit退出");
            while(true){
                String line=scanner.nextLine();
                if("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                //最终不再通讯是要关闭socket.(相当于挂电话)
                //socket关闭后,通过socket获取的输入流与输出流就自动关闭了
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //该线程负责读取服务端发送过来的消息
    private class ServerHandler implements Runnable{
        public void run(){
            try (BufferedReader br=new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream(),"UTF-8"
                    )
            );){
                String line;
                while ((line=br.readLine())!=null){
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }

}
