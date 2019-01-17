import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class TimeTrackerWindow {

    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JTextField yourCurrentTaskTextField;
    private JButton hideButton;

    public TimeTrackerWindow(ToolWindow toolWindow) {

    }

    public JPanel getContent() {
        return mainPanel;
    }
}
