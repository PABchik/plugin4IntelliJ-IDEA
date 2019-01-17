import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Formatter;

public class TimeTracker {

    private long startTime;
    private long stopTime;
    private long totalTime;
    private boolean running = false;
    private boolean paused = false;
    private long elapsedTime = 0;
    JLabel jLabel;

    TimeTracker(JLabel time) {
        jLabel = time;
    }


    public boolean isRunning() {
        return running;
    }


    public boolean isPaused() {
        return paused;
    }

    public void pauseTimeTracking() {
        elapsedTime += System.currentTimeMillis() - startTime;
        paused = true;
    }

    public void startTimeTracking() {
        startTime = System.currentTimeMillis();
        paused = false;
        running = true;

    }

    public void stopTimeTracking() {
        stopTime = System.currentTimeMillis();
        totalTime = elapsedTime + stopTime - startTime;
        running = false;
    }

    public String getElapsedTime() {
        if (running && !paused) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            long elTime = (System.currentTimeMillis() - startTime + elapsedTime) / 1000 ;
            return decimalFormat.format(elTime / 3600 % 24) + ":" +
                    decimalFormat.format(elTime / 60 % 60) + ":" +
                    decimalFormat.format(elTime % 60);
        } else if (paused){
            DecimalFormat decimalFormat = new DecimalFormat("00");
            long elTime = (elapsedTime) / 1000 ;
            return decimalFormat.format(elTime / 3600 % 24) + ":" +
                    decimalFormat.format(elTime / 60 % 60) + ":" +
                    decimalFormat.format(elTime % 60);
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
