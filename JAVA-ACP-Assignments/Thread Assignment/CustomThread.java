public class CustomThread extends Thread {
    private Runnable task;
    public CustomThread() {
    }
    public CustomThread(Runnable task) {
        this.task = task;
    }
    @Override
    public void run() {
        if (task != null) {
            task.run();
        }
    }
}
