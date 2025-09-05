//Tai Osborne 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.sql.rowset.spi.SyncResolver;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    static String userInput;
    
    
    // Instance variables (if needed)

    public static void main(String[] args) {
        //Scanner scnr = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();
        menuSwitch();//menu loop
        
        
        
        }
        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    public static void menuSwitch(){//menu loop
        Scanner scnr = new Scanner(System.in); //Scanner object used for other methods
        do {
            
            displayMenu();
            userInput = scnr.next();
            switch(userInput){
                case "1":
                intakeNewDog(scnr);  //intake a new dog
                
                break;

                case "2":
                intakeNewMonkey(scnr); //intake  a new monkey
                break;

                case "3":
                reserveAnimal(scnr); //reserve an animal
                break;

                case "4":
                printDogs();//prints all of the dogs that are in service and available
                break;

                case "5":
                printMonkey();//prints all of the monkeys that are in service and available
                break;

                case "6":
                printAnimals();//Prints both monkey and dogs that are in service and available
                break;
                

                default:
                System.out.println("Improper input"); //input validation 
            } 
        }while (!userInput.equals("q"));
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        /* 
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        */
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
        /* 
        Monkey Monkey1 = new Monkey("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "in service", false, "United States", "9.8", "5'8", "23", "One");
        Monkey Monkey2 = new Monkey("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "in service", false, "United States", "9.8", "5'8", "23", "One");
        Monkey Monkey3 = new Monkey("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada", "9.8", "5'8", "23", "One");

        monkeyList.add(Monkey1);
        monkeyList.add(Monkey2);
        monkeyList.add(Monkey3);
        */
    }


//Input validation for the boolean type to prevent possible premature program termination 
public static Boolean inputValidation(String type, Scanner scanner){//parameters are the type of aniamal and a scanner object
    Boolean reserved = false; 
    Boolean retry = true;
    String temp;
    do {
        try {
            System.out.printf("Is the %s resevred, type true or false.\n", type);
            
            reserved = scanner.nextBoolean();
            retry = false;
        }
        catch (InputMismatchException excpt) {
            temp = scanner.nextLine(); //clear the input buffer
            System.out.println("Invalid input.");
        }
    } while (retry);
    return reserved;
}


    
    
    public static void intakeNewDog(Scanner scanner) { //intake a new dog
        
        System.out.println("What is the dog's name?");//User input to instantiate dog object
        String name = scanner.next();

        System.out.println("What is the dog's breed?");
        String breed = scanner.next();

        System.out.println("What is the dog's gender?");
        String gender = scanner.next();

        System.out.println("What is the dog's age?");
        String age = scanner.next();

        System.out.println("What is the dog's weight");
        String weight = scanner.next();

        System.out.println("What is the dog's acquisition date?");
        String acqDate = scanner.next();

        String tempInput = scanner.nextLine();
        System.out.println("What is the dog's acquisition country?");
        String acqCountry = scanner.nextLine();

        
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();

        Boolean reserved = inputValidation("dog", scanner); //boolean input validation 

        tempInput = scanner.nextLine();
        System.out.println("What is the dog's service country?");
        String inServiceCountry = scanner.nextLine();

        for(Dog dog: dogList) {//checks if the dog object is already in dogList
            
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        Dog newDogIntake = new Dog(name, breed, gender, age, weight, acqDate, acqCountry, trainingStatus, reserved, inServiceCountry);
        dogList.add(newDogIntake);//create dog object and add it to dogList
    }



        
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {//intake a new monkey
            System.out.println("What is the Monkey's name?");
            String name = scanner.next();

            System.out.println("What is the Monkey's breed?");
            String breed = scanner.next();

            System.out.println("What is the Monkey's gender?");
            String gender = scanner.next();
            
            System.out.println("What is the Monkey's age?");
            String age = scanner.next();

            System.out.println("What is the Monkey's weight");
            String weight = scanner.next();

            System.out.println("What is the Monkey's acquisition date?");
            String acqDate = scanner.next();

            String tempInput2 = scanner.nextLine();
            System.out.println("What is the Monkey's acquisition country?");
            String acqCountry = scanner.nextLine();

            System.out.println("What is the Monkey's training status?");
            String trainingStatus = scanner.nextLine();

            Boolean reserved = inputValidation("dog", scanner);
            

            tempInput2 = scanner.nextLine();
            System.out.println("What is the Monkey's service country?");
            String inServiceCountry = scanner.nextLine();

            System.out.println("What is the Monkey's tail length?");
            String tailLength = scanner.next();

            System.out.println("What is the Monkey's height?");
            String height = scanner.next();

            System.out.println("What is the Monkey's body length?");
            String bodyLength = scanner.next();

            System.out.println("What is the Monkey's species?");
            String species = scanner.next();

            for(Monkey m: monkeyList) { //Checks if the monkey object is already in the monkeyList
                if(m.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis dog is already in our system\n\n");
                    return; //returns to menu
                }
            }
        
        Monkey mon1 = new Monkey(name, breed, gender, age, weight, acqDate, acqCountry, 
        trainingStatus, reserved, inServiceCountry, tailLength, height, bodyLength, species);
        monkeyList.add(mon1);//create monkey object and add it to monkeyList
            
            
        }

        
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner){
            Boolean retry = true;
            String animalType = "Null";
            String location = "Null";
            int notFoundCounter = 0;
            


            do{
                System.out.println("What is the type of animal?");
                animalType = scanner.next();
                if (animalType.equalsIgnoreCase("dog") || animalType.equalsIgnoreCase("monkey")){//checks if it is one of the animals
                    
                    retry = false;
                }
                
                }while(retry);


            
            
            
            String temp = scanner.nextLine();
            System.out.println("What country are you in?");//gets the service country 
            location = scanner.nextLine();
        
            

            if (animalType.equalsIgnoreCase("Dog")){//parses through the dog list to find the first dog that is in the entered country and is not reserved
                for (Dog d : dogList){
                    if(location.equalsIgnoreCase(d.getInServiceLocation()) && d.getReserved()== false){

                        System.out.println("\n\n" + d.getName() + " is available here is their information: \n\n");//prints the dogs information 
                        System.out.printf("Name: %-8s Animal type: %-5s Breed: %-12s Gender: %-8s Age: %-4s Weight: %-5s Acquisition date: %-12s Acquisition location: %-15s \n\n", d.getName(),
                        d.getAnimalType(), d.getBreed(), d.getGender(), d.getAge(), d.getWeight(),
                        d.getAcquisitionDate(), d.getAcquisitionLocation());

                        System.out.printf("Reserved: %-8s Service location: %-15s Training status: %-8s\n",  d.getReserved(), d.getInServiceLocation(), d.getTrainingStatus());
                        d.setReserved(true);
                        ++notFoundCounter;
                        break;
                    }
                }
            }
            else if (animalType.equalsIgnoreCase("Monkey")){//parses through the monkey list to find the first monkey that is in the entered country and is not reserved
                for (Monkey m: monkeyList){
                if (location.equalsIgnoreCase(m.getInServiceLocation()) && m.getReserved()== false) {

                    System.out.println("\n\n" + m.getName() + " is available here is their information: \n\n"); //prints the monkeys information 
                    System.out.printf("Name: %-8s Animal type: %-5s Breed: %-12s Gender: %-8s Age: %-4s Weight: %-5s Acquisition date: %-12s Acquisition location: %-15s \n", m.getName(),
                    m.getAnimalType(), m.getBreed(), m.getGender(), m.getAge(), m.getWeight(),
                    m.getAcquisitionDate(), m.getAcquisitionLocation());

                    System.out.printf("Reserved: %-8s Service location: %-15s Training status: %-8s",   m.getReserved(), m.getInServiceLocation(), m.getTrainingStatus());
                    m.setReserved(true);
                    ++notFoundCounter;
                    break;
                    
                }
            }
            }
            if (notFoundCounter == 0){
                System.out.println("\n\nThere is no animal's available right now."); //user feedback if there is no available animal
            }

        }

        
        
        public static void printDogs(){//Prints only the dogs in dogList that is in service and is not reserved
            int count = 0;
            String type = "Dog";
            String emptyString = "";
            
            for (Dog d : dogList){
                if(d.getReserved() == false && d.getTrainingStatus().equalsIgnoreCase("in service")){
                ++count;
                System.out.printf(" \n\n%-85s %s %d \n" , emptyString, type, count);
                System.out.printf("Name: %-8s Animal type: %-5s Breed: %-12s Gender: %-8s Age: %-4s Weight: %-5s Acquisition date: %-12s Acquisition location: %-15s Reserved: %-8s\n", d.getName(),
                d.getAnimalType(), d.getBreed(), d.getGender(), d.getAge(), d.getWeight(),
                d.getAcquisitionDate(), d.getAcquisitionLocation(), d.getReserved());

                System.out.printf("Service location: %-15s Training status: %-8s \n",  d.getInServiceLocation(), d.getTrainingStatus());


                }
                
            }
        }
        
        public static void printMonkey(){//Prints only the monkeys in monkeyList that is in service and is not reserved
            int count = 0;
            String type = "Monkey";
            String emptyString = "";
            for (Monkey m : monkeyList){
                if(m.getReserved() == false && m.getTrainingStatus().equalsIgnoreCase("in service")){
                ++count;
                System.out.printf(" \n\n%-85s %s %d \n" , emptyString, type, count);
                System.out.printf("Name: %-8s Animal type: %-5s Breed: %-12s Gender: %-8s Age: %-4s Weight: %-5s Acquisition date: %-12s Acquisition location: %-15s Reserved: %-8s\n", m.getName(),
                m.getAnimalType(), m.getBreed(), m.getGender(), m.getAge(), m.getWeight(),
                m.getAcquisitionDate(), m.getAcquisitionLocation(), m.getReserved());

                System.out.printf("Service location: %-15s Training status: %-8s \n",  m.getInServiceLocation(), m.getTrainingStatus());


                
                }
            }
        }
       
        public static void printAnimals() {
            printMonkey();
            printDogs();
        }
}

