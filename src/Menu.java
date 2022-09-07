// imports allow you to use code already written by others.  It is good to explore and learn libraries.  The names around the dots often give you a hint to the originator of the code.
import java.util.Scanner; //library for user input
import java.lang.Math; //library for random numbers
import java.util.Arrays;

public class Menu {
    // Instance Variables
    public final String DEFAULT = "\u001B[0m";  // Default Terminal Color
    public final String[][] COLORS = { // 2D Array of ANSI Terminal Colors
        {"Default",DEFAULT},
        {"Red", "\u001B[31m"}, 
        {"Green", "\u001B[32m"}, 
        {"Yellow", "\u001B[33m"}, 
        {"Blue", "\u001B[34m"}, 
        {"Purple", "\u001B[35m"}, 
        {"Cyan", "\u001B[36m"}, 
        {"White", "\u001B[37m"}, 
    };
    // 2D column location for data
    public final int NAME = 0;
    public final int ANSI = 1;  // ANSI is the "standard" for terminal codes

    // Constructor on this Object takes control of menu events and actions
    public Menu() {
        Scanner sc = new Scanner(System.in);  // using Java Scanner Object
        
        boolean quit = false;
        while (!quit) {
            try {  // scan for Input
                this.print();  // print Menu
                int choice = sc.nextInt();  // using method from Java Scanner Object
                System.out.print("" + choice + ": ");
                quit = this.action(choice);  // take action
                Thread.sleep(700);
                System.out.print("\033[H\033[2J");
            } catch (Exception e) {
                if (sc.hasNextLine()) {
                    sc.nextLine(); // error: clear buffer
                    System.out.println(e + ": Not a number, try again.");    
                }
            }
        }
        sc.close();
    }

    // Print the menu options to Terminal
    private void print() {
        //System.out.println commands below is used to present a Menu to the user. 
        System.out.println("-------------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Addition");
        System.out.println("2 - Spinning Donut");
        System.out.println("3 - My diminishing patience with Java bec I cant get X11 to work");
        System.out.println("0 - Quit");
        System.out.println("-------------------------\n");
    }

    // Stolen spinning donut code lmfao
    private void donut() {
        int k;
        double A = 0, B = 0, i, j;
        double[] z = new double[1760];
        char[] b = new char[1760];
        System.out.print("\u001b[2J");
        for (; ; ) {
            Arrays.fill(b, 0, 1760, ' ');
            Arrays.fill(z, 0, 1760, 0);
            for (j = 0; 6.28 > j; j += 0.07)
                for (i = 0; 6.28 > i; i += 0.02) {
                    double c = Math.sin(i),
                            d = Math.cos(j),
                            e = Math.sin(A),
                            f = Math.sin(j),
                            g = Math.cos(A),
                            h = d + 2,
                            D = 1 / (c * h * e + f * g + 5),
                            l = Math.cos(i),
                            m = Math.cos(B),
                            n = Math.sin(B),
                            t = c * h * g - f * e;
                    int x = (int) (40 + 30 * D * (l * h * m - t * n)),
                            y = (int) (12 + 15 * D * (l * h * n + t * m)),
                            o = x + 80 * y,
                            N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                    if (22 > y && y > 0 && x > 0 && 80 > x && D > z[o]) {
                        z[o] = D;
                        b[o] = new char[]{'.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@'}[Math.max(N, 0)];
                    }
                }
            System.out.print("\u001b[H");
            for (k = 0; 1761 > k; k++)
                System.out.print(k % 80 > 0 ? b[k] : 10);
            A += 0.04;
            B += 0.02;
        }
    }

    // Private method to perform action and return true if action is to quit/exit
    private boolean action(int selection) {
        boolean quit = false;
        
        switch (selection) {  // Switch or Switch/Case is Control Flow statement and is used to evaluate the user selection
            case 0:  
                System.out.print("Goodbye, World!");
                quit = true;
                break;
            case 1:
                System.out.println("Addition");
                Scanner sc = new Scanner(System.in);
                System.out.print("a: ");
                int a = sc.nextInt();
                System.out.print("b: ");
                int b = sc.nextInt();
                int c = a + b;
                System.out.println(a + " + " + b + " = " + c);
                break;
            case 2:
                this.donut();
            case 3:
                String bar = "####################";
                for (int i = 0; i < 20; i++) {  // fixed length loading bar
                    bar = bar.substring(0, bar.length()-1);
                    try {
                        Thread.sleep(300);  // delay for loading
                        System.out.print("\033[H\033[2J");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.print(bar);
                }
                break;
                    
            default:
                //Prints error message from console
                System.out.print("Unexpected choice, try again.");
        }
        System.out.println(DEFAULT);  // make sure to reset color and provide new line
        return quit;
    }

    // Static driver/tester method
    static public void main(String[] args)  {  
        new Menu(); // starting Menu object
    }

}