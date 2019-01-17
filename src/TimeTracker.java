import javax.swing.*;

public class TimeTracker extends Thread{

    private long startTime;
    private long stopTime;
    private long totalTime;
    JLabel jLabel;

    TimeTracker(JLabel time) {
        jLabel = time;
    }

    public void startTimeTracking() {
        startTime = System.currentTimeMillis();
    }

    public void stopTimeTracking() {
        stopTime = System.currentTimeMillis();
        totalTime = stopTime - startTime;
    }

    public long getElapsedTime() {
        if (isAlive()) {
            return System.currentTimeMillis() - startTime;
        } else {
            return totalTime;
        }
    }

    public void printElapsedTime(JLabel jLabel) {
        while (isAlive()) {
            jLabel.setText(Long.toString(getElapsedTime()));
            System.out.println("From another thread!");
        }
    }

    @Override
    public void run() {
        startTimeTracking();
        printElapsedTime(jLabel);
    }

    @Override
    public void interrupt() {
        stopTimeTracking();
    }
}
