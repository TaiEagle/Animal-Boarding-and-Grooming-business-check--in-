//Tai Osborne 
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;
    
    

    // Constructor
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("Dog");

    }

    // Breed accessor and mutator
    public String getBreed() {
        return breed;
    }
    public void setBreed(String _dogBreed) {
        this.breed = _dogBreed;
    }
    

}
