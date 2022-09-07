import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
// Graphical-User-Interface for Desktop in Java using Java Swing. 
public class MenuJFrame extends JFrame implements ActionListener {
    private JFrame frame;
    private JMenuBar menubar;
    private JMenu menu;
    private JLabel message = new JLabel("Click on Menu to select an action.");
    public final String[] MENUS = { // 1D Array of Menu Choices
        "Hello", "Colors", "Loading bar",  
    };
    // Statics to assist with timer and messaging, single copy (no instance)
    private	static int delay = 20;
    private	static int step = 1;
    private static String hashes = "";

    // Constructor enables the Frame instance, the object "this.frame"
    public MenuJFrame(String title) {
	    // Initializing Key Objects
        System.setProperty("java.awt.headless", "true");
        frame = new JFrame(title);
	    menubar = new JMenuBar();
	    menu = new JMenu("Menu");

        // Initializing Menu objects and adding actions
        for (String mx : MENUS) {
            JMenuItem m = new JMenuItem(mx);
            m.addActionListener(this);
            menu.add(m); 
        }

        // Adding / Connecting Objects
        menubar.add(menu);
        frame.setJMenuBar(menubar);
        frame.add(message);

        // Sets JFrame close operation to Class variable JFrame.EXIT_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // set the size of window based on objects
        frame.setSize(300,200);

        // makes the frame object visible according to properties previously set
        frame.setVisible(true);  // flow of control shifts to frame object
    }

    // event from user selecting a menu option
    public void actionPerformed(ActionEvent e) {
        // local variable to ActinEvent
        String selection = e.getActionCommand();  // menu selection
        String msg; // local variable to create response from action
        final String[] COLORS = {"Red", "Green", "Blue"};  // add more colors here
 	    final String start_msg = "<html>";  // html building
       	final String end_msg = "</html>";
       	final String hash = "#";

        // run code based on the menuItem that was selected
        if ( selection.equals(MENUS[0]) ) {  // Hello Action
            msg = "Hello, World";
            message.setText(msg);
        } else if ( selection.equals(MENUS[1]) ) { // Color Action
            msg = start_msg + "<p>" + selection + "</p>";
            for (String color : COLORS) {
                msg += "<font color=" + color + ">" + color + " </font>";
            }
            msg += end_msg;
            message.setText(msg);
        } else {  // Loading Bar Action
	    String loading = "<p>Loading</p>";
            // Code to run on a Timer
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {  // Method for TimerTask
                    // Static and Local variables used to manage message building
                    int random = (int) (Math.random() * COLORS.length);  // random logic
                    MenuJFrame.hashes +=  "<font color=" + COLORS[random] + ">" + hash + "</font>";
                    String msg = start_msg + loading + hashes + end_msg;
                    message.setText(msg);
                    
	  	            // Shutdown timer and reset data
                    if(MenuJFrame.step++ > MenuJFrame.delay) {
                        MenuJFrame.step = 1; MenuJFrame.hashes="";
                        timer.cancel();
                    }
                };
            };
            // Schedule task and interval
            timer.schedule(task, 200, 200);
            message.setText(start_msg + loading + hash + end_msg);  // prime/initial display
        }
    }

    // Driver turn over control the GUI
    public static void main(String[] args) {
        // Activates an instance of MenuJFrame class, which makes a JFrame object
        new MenuJFrame("Menu");
    }
}
