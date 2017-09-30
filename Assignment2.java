/* Good Work
 * Score 9.5 + extra credit 3.5; Total Score = 10
 *
 */

package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Assignment2 e = new Assignment2();
        e.employeeSalary(42);
        e.addDigits(1234);
        e.printPerfectNumber(100);
        Solution.triangle();

    }

    //1 
    // score 1.5
    private static final double HOURS1 = 36.0;
    private static final double HOURS2 = 36.0 + 5;
    private static final double HOURS3 = 48.0;

    private static final double SALARY1 = 15.0;
    private static final double SALARY2 = 15.0 * 1.5;
    private static final double SALARY3 = 15.0 * 2;

    public double employeeSalary(double hours) { // for hours greater than 48 the pay should be equal to 48hrs but not 0
        double salary = 0.0;
        if (hours <= 0) {
            return 0.0;
        } else if (hours <= HOURS1) {
            salary = hours * SALARY1;
        } else if (hours > HOURS1 && hours <= HOURS2) {
            salary = HOURS1 * SALARY1 + (hours - HOURS1) * SALARY2;
        } else if (hours > HOURS2 && hours <= HOURS3) {
            salary = HOURS1 * SALARY1 + (HOURS2 - HOURS1) * SALARY2 + (hours - HOURS2) * SALARY3;
        } else {
            salary = 0.0;
            System.out.println("Input is invalidate");
        }
        System.out.println(salary);
        return salary;
    }

    //2
    //score 2
    public int addDigits(int input) {
        int sum = 0;
        if (input < 10) {
            sum = input;
        }
        while (input > 9) {
            sum = 0;
            while (input >0) {
                int rem;
                rem = input % 10;
                sum += rem;
                input /= 10;
            }
            input = sum;
        }

        System.out.println(sum);
        return sum;
    }

    //3
    // score 2
    public void printPerfectNumber(int n) {
        for (int i = 1; i < n; i++) {
            int divisor = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    divisor += j;
                }
            }
            if (divisor == i) {
                System.out.print(i + " ");
            }
        }
    }

}

//4
// score 2 + extra credit 0.5
class Pizza {
    String type;
    double price;
    double points;
    public Pizza() {
        type = "";
        price = 0.0;
        points = 0.0;
    }

    public Pizza(String type) {
        this.type = type;
        price = 0.0;
        points = 0.0;
    }

    public Pizza(String type, double price) {
        this.type = type;
        this.price = price;
        points = 0.0;
    }

    public Pizza(String type, double price, double points) {
        this.type = type;
        this.price = price;
        this.points = points;
    }
}

//5
// score 2 + extra credit 1
class Customer{
    String name;
    HashMap<Pizza, Integer> pizzaOrder;
    //PizzaOrder[] orders;

    public Customer(String name) {
        this.name = name;
        pizzaOrder = new HashMap<Pizza, Integer>();
    }

    public double total_price() {
        double sum = 0;
        for (Map.Entry<Pizza, Integer> entry : pizzaOrder.entrySet()) {
            sum += entry.getKey().price * entry.getValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Customer ciera = new Customer("Ciera");
        Pizza pizza1 = new Pizza("cheese", 2.5);
        ciera.pizzaOrder.put(pizza1, 2);
        System.out.println(ciera.total_price());
    }
}

//6
// extra credit 2
class Solution {
    public static void triangle() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("Please input how many rows: ");
        int rows = input.nextInt();
        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    System.out.print("*");
                } else if (j == i - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
        for (int i = 0; i < rows; i++) {
            System.out.print("*");
        }
    }
}
