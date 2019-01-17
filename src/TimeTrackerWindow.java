import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTrackerWindow implements Runnable {

    private TimeTracker timeTracker;

    private JPanel mainPanel;
    private JButton playB;
    private JButton pauseB;
    private JButton stopB;
    private JTextField yourCurrentTaskTextField;
    private JButton hideB;
    private JLabel time;
    private JTextField cUsersTimeTrackingLogsTextField;

    private Thread thread;

    public TimeTrackerWindow(ToolWindow toolWindow) {



        timeTracker = new TimeTracker(time);

        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!timeTracker.isRunning()) {
                    start();
                    timeTracker.startTimeTracking();
                }
            }
        });

        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeTracker.isRunning()) {
                    timeTracker.stopTimeTracking();
                    stop();
                }
            }

        });

        hideB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolWindow.hide(null);
            }
        });
    }

    public JPanel getContent() {
        return mainPanel;
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    @Override
    public void run() {
        while (timeTracker.isRunning()) {
            time.setText(timeTracker.getElapsedTime());
        }
    }
}
