package thread;

/**
 * 多线程并发的安全问题
 * 当多个线程并发操作同一临界资源,由于线程切换时机不确定,导致执行操作的顺序混乱,出现和
 * 程序设计执行结果不同的情况,严重时可能导致系统瘫痪.
 *
 * 临界资源:操作过程同时只能被单一线程完整执行的资源.
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table=new Table();
        Thread t1=new Thread(){
            public void run(){
                while (true){
                    int bean=table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };

        Thread t2=new Thread(){
            public void run(){
                while (true){
                    int bean=table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };

        t1.start();
        t2.start();
    }
}
class Table{
    private int beans=20;
    /*
    当一个方法使用关键字synchronize修饰后,这个方法称为同步方法.
    即:多个线程不能同时在该方法内部执行.
    将操作临界资源的执行过程从多线程并发操作改为同步有先后顺序的排队执行可以解决
    并发安全问题
     */
    public synchronized int getBeans(){
        if(beans==0){
            throw new RuntimeException("没有豆子了!!!");
        }

        Thread.yield();
        return beans--;
    }
}
