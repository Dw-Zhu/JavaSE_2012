package thread;

/**
 * sleep方法要求必须处理中断异常.(Thread还提供了其他会导致县城阻塞的方法,很多都要求处理
 * 这个异常,情况是一样的.)
 *
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中,此时该线程的interrupt(中断)方法被调用时,会中断
 * 这个阻塞过程,此时该方法会抛出中断异常.
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin=new Thread(){
            public void run(){
                System.out.println("三上悠亚:刚美容玩,睡一会儿吧...");
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    System.out.println("三上悠亚:o yes!o yes!o yes!o yes!");
                }
                System.out.println("三上悠亚:!!!~~~");
            }
        };

        Thread huang=new Thread(){
            public void run(){
                System.out.println("毕福剑:花姑娘米西米西");
                for(int i=0;i<5;i++){
                    System.out.println("嘿咻!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("毕福剑:一库~");
                lin.interrupt();
            }
        };
        lin.start();
        huang.start();
    }
}
