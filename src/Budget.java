import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Budget {

    static ArrayList<String> months = new ArrayList<>(Arrays.asList(
        "january",
        "february",
        "march",
        "april",
        "may",
        "june",
        "july",
        "august",
        "september",
        "october",
        "november",
        "december"
    ));

    private HashMap<String, Integer> monthlyExpenses;
    private HashMap<String, Integer> monthlyBudget;

    public Budget() {
        this.monthlyExpenses = new HashMap<>();
        this.monthlyBudget = new HashMap<>();
    }

    public void setMonthlyExpenses() {

        Scanner scanner = new Scanner(System.in);

        for (String month : months) {
        
            System.out.println("Enter the monthly expenses for " + month + ": ");
            String input = scanner.nextLine();
            this.monthlyExpenses.put(month, Integer.parseInt(input));

        }

        
    }
    
    public void setMonthlyBudget() {
     
        Scanner scanner = new Scanner(System.in);

        for (String month : months) {
        
            System.out.println("Enter the monthly budget for " + month + ": ");
            String input = scanner.nextLine();
            this.monthlyBudget.put(month, Integer.parseInt(input));

        }

    }

    public int findDifference() {
        int sum = 0;

        for (String month : months) {
            sum += monthlyBudget.get(month);
            sum -= monthlyExpenses.get(month);
        }

        return sum;
    }

    public void findDifferenceToString() {
        System.out.println("Your difference is " + this.findDifference());
    }

    public static void main(String[] args) {
        Budget budget = new Budget();
        budget.setMonthlyBudget();
        budget.setMonthlyExpenses();
        budget.findDifferenceToString();
    }
}