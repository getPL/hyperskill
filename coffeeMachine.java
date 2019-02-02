package done;

import java.util.Scanner;

class coffeeMachine {

    private static final Scanner sc = new Scanner(System.in);
    private static boolean isEnabled = true;
    private static Status state = Status.MAINMENU;

    private static int water = 400;
    private static int milk = 540;
    private static int coffeebeans = 120;
    private static int cups = 9;
    private static int money = 550;


    public static void main(String[] args) {

        while (isEnabled) {

            switch(state) {

                case MAINMENU:
                    chooseAction();
                    break;
                case BUYING:
                    buyCoffee();
                    break;
                case TAKING:
                    takeMoney();
                    break;
                case FILLING:
                    fillMachine();
                    break;
                case GETTING:
                    getInfo();
                    break;
                case TURNINGOFF:
                    isEnabled = false;
                    break;
            }
        }

    }


    private enum Status {
        MAINMENU,
        BUYING,
        FILLING,
        TAKING,
        GETTING,
        TURNINGOFF
    }

    private static String checkInput() {
        return sc.next();
    }

    private static void chooseAction() {
        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        String action = checkInput();
        System.out.println();
        switch(action) {
            case "buy":
                state = Status.BUYING;
                break;
            case "fill":
                state = Status.FILLING;
                break;
            case "take":
                state = Status.TAKING;
                break;
            case "remaining":
                state = Status.GETTING;
                break;
            case "exit":
                state = Status.TURNINGOFF;
                break;
            default:
                System.out.println("I cannot understand you. Please try again");
                break;
        }
    }

    private static void buyCoffee() {
        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = checkInput();

        switch(coffeeType) {
            case "1":
                if (water >= 250 && coffeebeans >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    coffeebeans -= 16;
                    money += 4;
                    cups -= 1;
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (coffeebeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && coffeebeans >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 350;
                    milk -= 75;
                    coffeebeans -= 20;
                    money += 7;
                    cups -= 1;
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeebeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && coffeebeans >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 200;
                    milk -= 100;
                    coffeebeans -= 12;
                    money += 6;
                    cups -= 1;
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (coffeebeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Sorry, I cannot understand you.");
                break;
        }
        System.out.println();
        state = Status.MAINMENU;
    }

    private static void fillMachine() {

        System.out.print("Write how many ml of water do you want to add: ");
        water += Integer.parseInt(checkInput());

        System.out.print("Write how many ml of milk do you want to add: ");
        milk += Integer.parseInt(checkInput());

        System.out.print("Write how many grams of coffee beans do you want to add: ");
        coffeebeans += Integer.parseInt(checkInput());

        System.out.print("Write how many disposable cups of coffee do you want to add: ");
        cups += Integer.parseInt(checkInput());
        System.out.println();

        state = Status.MAINMENU;
    }

    private static void getInfo() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeebeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();
        state = Status.MAINMENU;
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
        state = Status.MAINMENU;
    }

}

