package homework.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * 聊天室服务端
 */
public class Server {
    private ServerSocket serverSocket;
    private PrintWriter[] allOut={};

    //初始化启动服务端
    public Server(){
        try {
            System.out.println("正在启动服务端...");
            serverSocket=new ServerSocket(8088);
            System.out.println("服务端启动完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务端工作方法
    public void start(){
        try {
            while (true){
                System.out.println("等待客户端链接...");
                Socket socket=serverSocket.accept();
                System.out.println("一个客户端链接了!");

                //启动一个线程处理与客户端的交互
                Runnable handler=new ClientHandler(socket);
                Thread t=new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;

        public ClientHandler(Socket socket){
            this.socket=socket;
            host=socket.getInetAddress().getHostAddress();
        }

        public void run(){
            PrintWriter pw=null;
            try {
                BufferedReader br=new BufferedReader(
                    new InputStreamReader(
                         socket.getInputStream(),"UTF-8"
                    )
                );

                pw=new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"UTF-8"
                                )
                        ),true
                );

                synchronized (Server.class) {
                    allOut = Arrays.copyOf(allOut, allOut.length + 1);
                    allOut[allOut.length - 1] = pw;
                }
                System.out.println(host + "上线了!当前在线人数:" + allOut.length);

                String line;
                while ((line=br.readLine())!=null){
                    System.out.println("客户端说:" + line);
                    synchronized (Server.class){
                        for(int i=0;i<allOut.length;i++){
                            allOut[i].println(host+"说:"+line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                synchronized (Server.class){
                    for(int i=0;i<allOut.length;i++){
                        if(pw==allOut[i]){
                            allOut[i]=allOut[allOut.length-1];
                            allOut=Arrays.copyOf(allOut,allOut.length-1);
                            break;
                        }
                    }
                    System.out.println(host + "下线了!当前在线人数:" + allOut.length);
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }

}
