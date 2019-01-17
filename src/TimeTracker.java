import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Formatter;

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

    public String getElapsedTime() {
        if (running) {
            DecimalFormat elapsedTime = new DecimalFormat("00");
            long elTime = (System.currentTimeMillis() - startTime) / 1000;
//            elapsedTime.format("%s2.2:%s2.2:%s2.2", elTime / 3600 % 24, elTime / 60 % 60, elTime % 60);
            return elapsedTime.format(elTime / 3600 % 24) + ":" +
                    elapsedTime.format(elTime / 60 % 60) + ":" +
                    elapsedTime.format(elTime % 60);
        } else {
            return "00:00:00";
        }
    }

    /*public void printElapsedTime(JLabel jLabel) {
        while () {
            jLabel.setText(Long.toString(getElapsedTime()));
            System.out.println("From another thread!");
        }
    }*/
}
