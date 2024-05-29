package UIs.Utilities;
import javax.swing.*;

public class calendarPanel {

    public static JPanel getCalendarPanel(){
        // Components for the calendar panel
        final JPanel calendarPanel = new JPanel();
        JLabel calendarTitle = new JLabel("Calendar");

        calendarPanel.add(calendarTitle);

        return calendarPanel;
    }
}
