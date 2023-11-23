public class Threads extends Thread {

    private static TP05 a = new TP05("TP05", 400, 500, 10, 10);
    private int max;

    public Threads() 
    {
    }

    public void getInfo(int max) 
    {
        this.max = max;
    }

    public void setInfo(String i) {
        Thread currentThread = Thread.currentThread();

        if (currentThread.getName().equals("Thread-4")) {
            if (a != null) {
                a.setL1(i);
            } else {
                System.out.println("Erro");
            }
        } else {
            if (a != null) {
                a.setL2(i);
            } else {
                System.out.println("Erro");
            }
        }
    }

    public void setEnd() 
    {
        Thread currentThread = Thread.currentThread();

        if (currentThread.getName().equals("Thread-4")) {
            if (a != null) {
                a.setLabel1();
                System.out.println(currentThread.getPriority());
            } else {
                System.out.println("Erro");
            }
        } else {
            if (a != null) {
                a.setLabel2();
                System.out.println(currentThread.getPriority());
            } else {
                System.out.println("Erro");
            }
        }
    }


    public void run() {
        for (int i = 0; i < max; i++) {
            this.setInfo(i + "");
        }
        this.setEnd();
    }

    public static void main(String[] args) {
        new Threads();
    }
}
