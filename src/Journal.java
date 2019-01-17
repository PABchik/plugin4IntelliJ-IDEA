import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import java.io.FileWriter;

public class Journal extends AnAction {
    private FileWriter writer;

    public void write() {

    }


    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        if (!TimeTrackerWindow.thread.isAlive()) {
            TimeTrackerWindow.thread.start();
        } else {
            TimeTrackerWindow.thread.interrupt();
        }
    }
}
