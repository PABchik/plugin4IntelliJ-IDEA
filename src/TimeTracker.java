public class TimeTracker {

    private long startTime;
    private long stopTime;
    private long totalTime;
    boolean running = false;

    public void start() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
        running = false;
        totalTime = stopTime - startTime;
    }

    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return totalTime;
        }
    }
}
