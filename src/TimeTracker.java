import javax.swing.*;

public class TimeTracker extends Thread{

    private long startTime;
    private long stopTime;
    private long totalTime;
    boolean running = false;

    public void startTimeTracking() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public void stopTimeTracking() {
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

    public void printElapsedTime(JLabel jLabel) {
        while (running) {
            jLabel.setText(Long.toString(getElapsedTime()));
        }
    }

    @Override
    public void run() {
        startTimeTracking();
    }

    @Override
    public void interrupt() {
        stopTimeTracking();
    }
}
