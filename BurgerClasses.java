// This file contains all the classes and functions needed to run the game in main
import java.util.Stack;
import java.util.Scanner;

public class BurgerClasses {
    // Kept throwing no line exceptions without this
    public static final Scanner scanner = new Scanner(System.in);

    static class Ingredients {
        public String userInput;
        public String bun = "bun";
        public String burger = "burger";
        public String lettuce = "lettuce";
        public String tomato = "tomato";
        public String onion = "onion";
        public String pickle = "pickle";
        public String cheese = "cheese";
        public String ketchup = "ketchup";
        public String mustard = "mustard";
        public String mayo = "mayo";
        String[] ingredientList = { bun, burger, lettuce, tomato, onion, pickle, cheese, ketchup, mustard, mayo };

        public void SelectIngredient() {
            // Whole thing loops until the user inputs one of the ingredients
            do {
                System.out.print("Type in an ingredient: ");
                userInput = scanner.nextLine();
                System.out.print("\n");
                if (userInput.equals("help")) {
                    Help();
                    userInput = "nothing";
                } else {
                    for (int i = 0; i < ingredientList.length; i++) {
                        if (userInput.equals(ingredientList[i])) {
                            break;
                        }
                        // Only tells the user to give input again after it has checked every ingredient
                        else if (i == 9) {
                            System.out.println(userInput + " is not one of the ingredients.\n");
                            try {
                                Thread.sleep(600);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            userInput = "nothing";
                        }
                    }
                }
            } while (userInput.equals("nothing"));
        }

        public void Help() {
            System.out.println("If you want to select an ingredient, type the name of it in.");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("The ingredients you can choose from are: ");
            for (int i = 0; i < ingredientList.length; i++) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                if (i == (ingredientList.length - 1)) {
                    System.out.println(ingredientList[i] + "\n");
                } else {
                    System.out.print(ingredientList[i] + ", ");
                }
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class Burger extends Ingredients {
        Stack<String> burgerStack = new Stack<String>();

        public void AddIngredient() {
            SelectIngredient();
            burgerStack.push(userInput);
            System.out.println("A " + userInput + " has been added to the burger.\n");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        public void RemoveIngredient() {
            if (burgerStack.empty()) {
                System.out.println("There are no ingredients to remove.\n");
            } else {
                String temp = burgerStack.pop();
                System.out.println("A " + temp + " has been removed from the burger.\n");
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Takes in a stack holding strings values, returns an int
        public int BurgerFinished(Stack<String> customerOrder) {
            int points = 0;
            String burgerItem = "nothing";
            String customerRequest = "nothing";
            boolean comparisonDone = false;
            // Now the two are compared (top to bottom though) and points are given or
            // deducted based on how close the burger is to the order
            while (!comparisonDone) {
                if (burgerStack.empty()) {
                    burgerItem = "nothing";
                } else {
                    burgerItem = burgerStack.pop();
                }

                if (customerOrder.empty()) {
                    customerRequest = "blank";
                } else {
                    customerRequest = customerOrder.pop();
                }

                if (burgerItem.equals(customerRequest)) {
                    System.out.println("Ingredient right. +10 points.");
                    points = (points + 10);
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Ingredient incorrect. -15 points.");
                    points = (points - 15);
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                if (burgerStack.empty() && customerOrder.empty()) {
                    comparisonDone = true;
                }
            }
            System.out.println("You received " + points + " points for completing that order.\n");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return points;
        }
    }

    static class Customer extends Ingredients {
        Stack<String> customerOrder = new Stack<String>();

        // Returns a stack holding string values
        public Stack<String> ReturnOrder() {
            return customerOrder;
        }

        public void CreateNewOrder() {
            int burgerSize = (int) Math.floor(Math.random() * (8 - 2 + 1) + 2); // min = 2, max = 8
            customerOrder.push(bun);
            System.out.print("The customer wants: bun, ");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < burgerSize; i++) {
                int randomIngredient = (int) Math.floor(Math.random() * (9 - 0 + 1) + 0); // min = 0, max = 9
                customerOrder.push(ingredientList[randomIngredient]);
                System.out.print(ingredientList[randomIngredient] + ", ");
                try {
                    Thread.sleep(600);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            customerOrder.push(bun);
            System.out.println("bun\n");
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    static class ScoreTracker {
        private int score = 0;

        // Takes in an int value
        public void AddToScore(int points) {
            score = (score + points);
        }

        // Returns an int
        public int GetScore() {
            return score;
        }
    }

    static void Intro() {
        System.out.println("\n**Starting The Burger Game**\n");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Welcome, to my humble burger abode!");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("We enjoy making the best burgers around. We've turned it into a bit of a game.");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("When a customer gives their order, you gotta make that burger.");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("The order will be given from the bottom to the top, same way you'll be making it.");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(
                "But just so you know, I am using stacks, so the burger and order will be compared top to bottom to determine your score.");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(
                "You'll score 10 points for every correct ingredient, and lose 15 points for every ingredient that doesn't match.");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(
                "Now have fun, and if you don't know what all the available ingredients are, just type 'help' instead of an ingredient.\n");
        try {
            Thread.sleep(600);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
