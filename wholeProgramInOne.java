import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class wholeProgramInOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // List of Lunch Roulette participants

        List<String> nameListplay = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        int numberOfPlyers = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/TextLunchRouletteTest.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                nameListplay.add(s);
                nameList.add(s);
                numberOfPlyers++;
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        // List and collection of topics

        List<String> topicList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/topicsLunchRoulette.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                topicList.add(s);
            }
            br.close();

        } catch (Exception ex) {
            return;
        }

        // START OF ROULETTE
        // The program starts here and runs until quit is entered in the main menu

        boolean playing = true;
        int round = 0;

        while (playing) {

            // Main menu: Welcome to / welcome back to Lunch Roulette + choose option

            if (round == 0) {
                System.out.println("\n\nHello and welcome to the Lunch Roulette!");
                System.out.println(
                        "This is the game where we see which three lucky people are going to have lunch together!\nHere are your options:\n");
            } else if (round > 0) {
                System.out.println("\n\nHello and welcome back to the Lunch Roulette!");
                System.out.println("What do you want to do now?\n");
            }

            System.out.println(
                    "Type 'play' to play Lunch Roulette\nType 'add' to add a person\nType 'remove' to remove a person\nType 'see list' to see participant list\nType 'quit' to stop playing\n");
            System.out.print("I want to ");
            String playerInput = scanner.nextLine();

            // Play! Get groups of three

            if (playerInput.equals("play")) {

                boolean play = true;
                while (play) {
                    System.out.println("\nAlrighty let's go.");
                    System.out.println("Here's your team and your topic to talk about:\n");
                    List<String> lunchGroupOfThree = new ArrayList<>();
                    Random random = new Random();

                    // boolean isAdded = false;

                    for (int i = 0; i < 3; i++) {

                        int randomInt = random.nextInt(nameListplay.size());
                        String randomPerson = nameListplay.get(randomInt);

                        lunchGroupOfThree.add(randomPerson);
                        nameListplay.remove(randomInt);
                    }

                    int randomIntTopics = random.nextInt(topicList.size());
                    String randomTopic = topicList.get(randomIntTopics);

                    System.out.println(lunchGroupOfThree);
                    System.out.println(randomTopic);
                    System.out.println("\nHappy lunching!\n");

                    System.out.println("Do you want to get one more group? Type yes or no");
                    String optionInput = scanner.nextLine();

                    if (optionInput.equals("no")) {
                        play = false;
                        System.out.println("\nOkay, have fun!\n");
                    } else if (optionInput.equals("yes")) {

                    }
                }
            }

            // Add a person to the list of Lunch Roulette participants

            if (playerInput.equals("add")) {

                System.out.println(
                        "\nPlease enter the names you want to add one at a time. Type 'stop' to stop adding names");
                List<String> listOfAddedNames = new ArrayList<>();

                boolean add = true;
                while (add) {
                    String addNameInput = scanner.nextLine();

                    if (addNameInput.equals("stop")) {
                        add = false;
                    } else {
                        listOfAddedNames.add(addNameInput);
                        nameList.add(addNameInput);
                        nameListplay.add(addNameInput); // Göra så att textfilen läses in varje gång man ska spela för
                                                        // då uppdateras listan inför varje gång och då behövs inte den
                                                        // här raden kod
                        try {
                            BufferedWriter bw = new BufferedWriter(new FileWriter(
                                    "/Users/emelie.stromberg/Desktop/Coding/VSCode/lunchRoulette/TextLunchRouletteTest.txt"));
                            bw.write(nameList + ""); // lös pls så att det går att printa en hel lista bara utan krångel
                            bw.close();

                        } catch (Exception ex) {
                            return;
                        }
                    }
                }
                System.out.println("\nWelcome to the new members of the Lunch Roulette:" + listOfAddedNames + "\n");
                System.out.println("Here is the updated memberlist: " + nameList);
            }

            // Remove a person to the list of Lunch Roulette participants

            if (playerInput.equals("remove")) {
                System.out.println(
                        "\nPlease enter the names you want to remove one at a time. Type 'stop' to stop removing names");
                List<String> listOfRemovedNames = new ArrayList<>();

                boolean remove = true;
                while (remove) {
                    String removeNameInput = scanner.nextLine();
                    if (removeNameInput.equals("stop")) {
                        remove = false;
                    } else {
                        listOfRemovedNames.add(removeNameInput);
                        nameList.remove(removeNameInput);
                    }
                }
                System.out.println("\nHere are the people who are leaving the Lunch Roulette: " + listOfRemovedNames);
                System.out
                        .println("Here is your updated list of the participants of Lunch Roulette: " + nameList + "\n");
            }

            // See the list of all Lunch Roulette participants

            if (playerInput.equals("see list")) {
                System.err.println(
                        "\nThere are " + numberOfPlyers + " people who participates in Lunch Roulette:\n" + nameList);
            }

            // Quit the game. Shut down Lunch Roulette

            if (playerInput.equals("quit")) {
                playing = false;
                System.out.println("\nOkay, have a good day! Bye!\n");
            }

            round++;
            // else {
            // System.out.println("\nSorry, that is not an option. Put your glasses on
            // smh\n");
            // }

        }
    }
}
