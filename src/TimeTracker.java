import javax.swing.*;

public class TimeTracker {

    private long startTime;
    private long stopTime;
    private long totalTime;
    private boolean running = false;
    JLabel jLabel;

    TimeTracker(JLabel time) {
        jLabel = time;
    }


    public boolean isRunning() {
        return running;
    }

    public void startTimeTracking() {
        startTime = System.currentTimeMillis();
        running = true;
    }

    public void stopTimeTracking() {
        stopTime = System.currentTimeMillis();
        totalTime = stopTime - startTime;
        running = false;
    }

    public long getElapsedTime() {
        if (running) {
            return System.currentTimeMillis() - startTime;
        } else {
            return totalTime;
        }
    }

    /*public void printElapsedTime(JLabel jLabel) {
        while () {
            jLabel.setText(Long.toString(getElapsedTime()));
            System.out.println("From another thread!");
        }
    }*/
}
