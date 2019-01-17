import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeTrackerWindow {

    private TimeTracker timeTracker;

    private JPanel mainPanel;
    private JButton playB;
    private JButton pauseB;
    private JButton stopB;
    private JTextField yourCurrentTaskTextField;
    private JButton hideB;
    private JLabel time;

    public TimeTrackerWindow(ToolWindow toolWindow) {

        timeTracker = new TimeTracker(time);

        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!timeTracker.isAlive()) {
                    timeTracker.run();
                }
            }
        });

        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeTracker.isAlive()) {
                    timeTracker.interrupt();
                }
            }
        });
    }

    public JPanel getContent() {
        return mainPanel;
    }
}
