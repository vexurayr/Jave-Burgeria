// This program is a small burger game about creating a burger the customer asks for to get the most points
import java.util.Stack;
import java.util.Scanner;

class BurgerMain extends BurgerClasses{
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Burger burger = new Burger();
        Customer customer = new Customer();
        ScoreTracker scoreTracker = new ScoreTracker();
        Stack<String> customerOrder = new Stack<String>();
        String userInput = "nothing";
        int score = 0;
        int points = 0;

        Intro();
        // Loops the entire game so the user can play as long as they want, a main menu of sorts
        do {
            boolean orderComplete = false;
            System.out.println("What would you like to do?");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("1 -> Start A New Order");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("2 -> Display Your Score");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Quit -> Exit The Game");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.print("Input: ");
            userInput = scanner.nextLine();
            System.out.print("\n");
            switch (userInput) {
                // Loops the gameplay section until the user completes the customer's order,
                // right or wrong
                case "1":
                    System.out.println("The order just came in-");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    customer.CreateNewOrder();
                    customerOrder = customer.ReturnOrder();
                    System.out.println("Let's make a burger!");
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    do {
                        System.out.println("1 -> Add an Ingredient");
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("2 -> Remove the Previous Ingredient");
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("3 -> The Burger is Ready");
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.print("Input: ");
                        userInput = scanner.nextLine();
                        System.out.print("\n");
                        switch (userInput) {
                            case "1":
                                burger.AddIngredient();
                                break;

                            case "2":
                                burger.RemoveIngredient();
                                break;

                            case "3":
                                points = burger.BurgerFinished(customerOrder);
                                scoreTracker.AddToScore(points);
                                orderComplete = true;
                                break;

                            default:
                                System.out.println("Please input 1, 2, or 3.\n");
                                try {
                                    Thread.sleep(600);
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                        }
                    } while (!orderComplete);
                    break;

                case "2":
                    score = scoreTracker.GetScore();
                    System.out.println("Your current score is: " + score + "\n");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;

                case "Quit":
                    System.out.println("Goodbye, my friend.");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    score = scoreTracker.GetScore();
                    System.out.print("Oh, before you go, your final score was: " + score + "\n\n");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Please input 1, 2, or Quit.\n");
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
            }
        } while (!userInput.equals("Quit"));
    }
}