import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TimeTrackerWindow implements Runnable {

    private TimeTracker timeTracker;

    private JPanel mainPanel;
    private JButton playB;
    private JButton pauseB;
    private JButton stopB;
    private JTextField yourCurrentTaskTextField;
    private JButton hideB;
    private JLabel time;
    private JTextField filePath;


    FileWriter writer;

    private Date startDateTime;
    private Date endDateTime;

    private Thread thread;

    public TimeTrackerWindow(ToolWindow toolWindow) {



        timeTracker = new TimeTracker(time);

        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!timeTracker.isRunning()) {
                    startDateTime = new Date();
                    start();
                    timeTracker.startTimeTracking();
                } else if (timeTracker.isPaused()) {
                    timeTracker.startTimeTracking();
                }
            }
        });

        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeTracker.isRunning()) {
                    timeTracker.stopTimeTracking();
                    endDateTime = new Date();
                    stop();
                    try {
                        writer = new FileWriter(filePath.getText(), true);
                        writer.write("\r\n\r\nStarted at " + startDateTime.toString());
                        writer.write("\r\nEnded at " + endDateTime.toString());
                        writer.write("\r\nDuration " + time.getText());
                        writer.write("\r\nTask name \"" + yourCurrentTaskTextField.getText() + "\"");
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }

        });

        pauseB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeTracker.pauseTimeTracking();
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
