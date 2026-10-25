package grazioso;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

    // ArrayList to hold all dogs in the system
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();

    // ArrayList to hold all monkeys in the system
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    public static void main(String[] args) {

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Stores the user's menu selection
        String menuChoice = "";

        // Load sample data for testing
        initializeDogList();
        initializeMonkeyList();

        // Menu loop continues until user enters q
        while (!menuChoice.equalsIgnoreCase("q")) {
            displayMenu();
            menuChoice = scanner.nextLine();

            // Process the user's menu choice
            switch (menuChoice.toLowerCase()) {
                case "1":
                    intakeNewDog(scanner);
                    break;
                case "2":
                    intakeNewMonkey(scanner);
                    break;
                case "3":
                    reserveAnimal(scanner);
                    break;
                case "4":
                    printAnimals("dog");
                    break;
                case "5":
                    printAnimals("monkey");
                    break;
                case "6":
                    printAnimals("available");
                    break;
                case "q":
                    System.out.println("Goodbye.");
                    break;
                default:
                    // Input validation for invalid menu entries
                    System.out.println("Invalid input. Please enter a valid menu option.");
                    break;
            }
        }

        // Close scanner before program ends
        scanner.close();
    }

    // Displays the menu options to the user
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print all in-service animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Adds sample dogs to the dog list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6",
                "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2",
                "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6",
                "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }

    // Adds sample monkeys to the monkey list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Bubbles", "Capuchin", "female", "2", "15.2",
                10.0, 12.0, 18.0, "01-15-2021", "Brazil", "Phase I", false, "Brazil");
        Monkey monkey2 = new Monkey("George", "Macaque", "male", "4", "20.5",
                11.0, 14.0, 19.0, "03-20-2020", "India", "in service", false, "India");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
    }

    // Intake a new dog and add it to the dog list
    public static void intakeNewDog(Scanner scanner) {

        // Ask user for the dog's name
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();

        // Check whether the dog is already in the system
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return;
            }
        }

        // Collect the rest of the dog's information from the user
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();

        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();

        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();

        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();

        System.out.println("What is the dog's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the dog's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the dog reserved? Enter true or false:");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("What is the dog's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Create a new Dog object using the entered information
        Dog dog = new Dog(name, breed, gender, age, weight, acquisitionDate,
                acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        // Add the new dog to the dog list
        dogList.add(dog);

        System.out.println("Dog added successfully.");
    }

    // Intake a new monkey and add it to the monkey list
    public static void intakeNewMonkey(Scanner scanner) {

        // Ask user for the monkey's name
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();

        // Check whether the monkey is already in the system
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }
        }

        // Ask user for monkey species
        System.out.println("What is the monkey's species?");
        String species = scanner.nextLine();

        // Validate that the monkey species is one of the approved species
        if (!species.equalsIgnoreCase("Capuchin") &&
            !species.equalsIgnoreCase("Guenon") &&
            !species.equalsIgnoreCase("Macaque") &&
            !species.equalsIgnoreCase("Marmoset") &&
            !species.equalsIgnoreCase("Squirrel monkey") &&
            !species.equalsIgnoreCase("Tamarin")) {
            System.out.println("That is not a valid monkey species.");
            return;
        }

        // Collect the rest of the monkey's information from the user
        System.out.println("What is the monkey's gender?");
        String gender = scanner.nextLine();

        System.out.println("What is the monkey's age?");
        String age = scanner.nextLine();

        System.out.println("What is the monkey's weight?");
        String weight = scanner.nextLine();

        System.out.println("What is the monkey's tail length?");
        double tailLength;
        double height;
        double bodyLength;
        try {
            tailLength = Double.parseDouble(scanner.nextLine());

            System.out.println("What is the monkey's height?");
            height = Double.parseDouble(scanner.nextLine());

            System.out.println("What is the monkey's body length?");
            bodyLength = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid measurement. Please enter a number.");
            return;
        }

        System.out.println("What is the monkey's acquisition date?");
        String acquisitionDate = scanner.nextLine();

        System.out.println("What is the monkey's acquisition country?");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the monkey's training status?");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the monkey reserved? Enter true or false:");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("What is the monkey's in-service country?");
        String inServiceCountry = scanner.nextLine();

        // Create a new Monkey object using the entered information
        Monkey monkey = new Monkey(name, species, gender, age, weight,
                tailLength, height, bodyLength, acquisitionDate,
                acquisitionCountry, trainingStatus, reserved, inServiceCountry);

        // Add the new monkey to the monkey list
        monkeyList.add(monkey);

        System.out.println("Monkey added successfully.");
    }

    // Reserve the first available animal of the requested type and country
    public static void reserveAnimal(Scanner scanner) {

        // Ask user which type of animal they want to reserve
        System.out.println("Enter animal type (dog or monkey):");
        String animalType = scanner.nextLine();

        // Ask user for the desired in-service country
        System.out.println("Enter the in-service country:");
        String country = scanner.nextLine();

        // Search the dog list if the user entered dog
        if (animalType.equalsIgnoreCase("dog")) {
            for (Dog dog : dogList) {

                // Reserve the first dog that matches the country,
                // is in service, and is not already reserved
                if (dog.getInServiceCountry().equalsIgnoreCase(country)
                        && dog.getTrainingStatus().equalsIgnoreCase("in service")
                        && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println(dog.getName() + " has been reserved.");
                    return;
                }
            }

            // Message shown if no matching dog is available
            System.out.println("No available dog found for that country.");
        }

        // Search the monkey list if the user entered monkey
        else if (animalType.equalsIgnoreCase("monkey")) {
            for (Monkey monkey : monkeyList) {

                // Reserve the first monkey that matches the country,
                // is in service, and is not already reserved
                if (monkey.getInServiceCountry().equalsIgnoreCase(country)
                        && monkey.getTrainingStatus().equalsIgnoreCase("in service")
                        && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println(monkey.getName() + " has been reserved.");
                    return;
                }
            }

            // Message shown if no matching monkey is available
            System.out.println("No available monkey found for that country.");
        }

        // Message shown if the user enters an invalid animal type
        else {
            System.out.println("Invalid animal type.");
        }
    }

    // Print animal information based on the requested list type
    public static void printAnimals(String listType) {

        // Print all dogs in the dog list
        if (listType.equalsIgnoreCase("dog")) {
            System.out.println("\nList of Dogs:");
            for (Dog dog : dogList) {
                System.out.println("Name: " + dog.getName()
                        + " | Training Status: " + dog.getTrainingStatus()
                        + " | Acquisition Country: " + dog.getAcquisitionLocation()
                        + " | Reserved: " + dog.getReserved());
            }
        }

        // Print all monkeys in the monkey list
        else if (listType.equalsIgnoreCase("monkey")) {
            System.out.println("\nList of Monkeys:");
            for (Monkey monkey : monkeyList) {
                System.out.println("Name: " + monkey.getName()
                        + " | Training Status: " + monkey.getTrainingStatus()
                        + " | Acquisition Country: " + monkey.getAcquisitionLocation()
                        + " | Reserved: " + monkey.getReserved());
            }
        }

        // Print all animals that are in service and not reserved
        else if (listType.equalsIgnoreCase("available")) {
            System.out.println("\nList of Available Animals:");

            // Check dogs for availability
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println("Name: " + dog.getName()
                            + " | Type: Dog"
                            + " | In-Service Country: " + dog.getInServiceCountry()
                            + " | Reserved: " + dog.getReserved());
                }
            }

            // Check monkeys for availability
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println("Name: " + monkey.getName()
                            + " | Type: Monkey"
                            + " | In-Service Country: " + monkey.getInServiceCountry()
                            + " | Reserved: " + monkey.getReserved());
                }
            }
        }

        // Handle invalid list type input
        else {
            System.out.println("Invalid list type.");
        }
    }
}