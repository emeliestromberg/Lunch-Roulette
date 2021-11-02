import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class oldVerisionWholeProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> nameList = new ArrayList<>();

        // String[] nameList = { "Nora", "Emelie", "Wilja", "Karin", "Ulrika", "Sofia",
        // "Magnus" };
        nameList.add("Nora");
        nameList.add("Emelie");
        nameList.add("Wilja");
        nameList.add("Karin");
        nameList.add("Ulrika");
        nameList.add("Sofia");
        nameList.add("Magnus");

        System.out.println("\n\nHello and welcome to the Lunch Roulette!");
        System.out.println(
                "The game where we see which three lucky people are going to have lunch together!\nHere are your options:\n");
        System.out.println(
                "Type 'play' to play Lunch Roulette\nType 'add' to add a person\nType 'remove' to remove a person\nType 'quit' to not play\n");
        System.out.print("I want to ");
        String playerInput = scanner.nextLine();

        if (playerInput.equals("play")) {

            for (int j = 0; j < 100; j++) {
                System.out.println("\nAlrighty let's go.");
                System.out.println("Here's your team:\n");
                List<String> lunchGroupOfThree = new ArrayList<>();

                for (int i = 0; i < 3; i++) {

                    Random random = new Random();
                    int randomInt = random.nextInt(nameList.size());
                    String randomPerson = nameList.get(randomInt);

                    lunchGroupOfThree.add(randomPerson);
                    nameList.remove(randomInt);
                }

                System.out.println(lunchGroupOfThree);
                System.out.println("\nHappy lunching!\n");

                System.out.println("Do you want to get one more group? Type yes or no");
                String optionInput = scanner.nextLine();

                if (optionInput.equals("no")) {
                    j = 100;
                    System.out.println("\nOkay, have fun! Bye!\n");
                } else if (optionInput.equals("yes")) {

                }
            }
        }

        if (playerInput.equals("add")) {

            System.out.println(
                    "\nPlease enter the names you want to add one at a time. Type 'stop' to stop adding names");
            List<String> listOfAddedNames = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                String addNameInput = scanner.nextLine();

                if (addNameInput.equals("stop")) {
                    i = 100;
                } else {
                    listOfAddedNames.add(addNameInput);
                    nameList.add(addNameInput);
                }
            }
            System.out.println("\nWelcome to the new members of the Lunch Roulette:" + listOfAddedNames + "\n");
            System.out.println("Here is the updated memberlist: " + nameList);
        }

        if (playerInput.equals("remove")) {
            System.out.println(
                    "\nPlease enter the names you want to remove one at a time. Type 'stop' to stop removing names");
            List<String> listOfRemovedNames = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                String removeNameInput = scanner.nextLine();
                if (removeNameInput.equals("stop")) {
                    i = 100;
                } else {
                    listOfRemovedNames.add(removeNameInput);
                    nameList.remove(removeNameInput);
                }
            }
            System.out.println("\nHere are the people who are leaving the Lunch Roulette: " + listOfRemovedNames);
            System.out.println("Here is your updated list of the participants of Lunch Roulette: " + nameList + "\n");
        }

        if (playerInput.equals("quit")) {
            System.out.println("\nOkay, have a good day! Bye!\n");
        }

        // else {
        // System.out.println("\nSorry, that is not an option. Put your glasses on
        // smh\n");
        // }
    }

}