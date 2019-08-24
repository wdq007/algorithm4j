

public class MultiProcess extends Thread {
    public MultiProcess(String name){
        super(name);

    }
    public void run(){
        for(int i=0;i<=10;i++) {
            System.out.println(getName() + "Running"+i);

        }
    }

}

class MultiProcessTest {
    public static void main(String[] args){
        System.out.println("main1");
        MultiProcess mp1 = new MultiProcess("T1");
        MultiProcess mp2 = new MultiProcess("T2");
        mp1.start();
        mp2.start();
        System.out.println("main2");

    }
}
