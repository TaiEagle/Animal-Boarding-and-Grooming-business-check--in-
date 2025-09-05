//Tai Osborne 
class Monkey extends RescueAnimal{
    //instance variables
    private String breed;
    private String tailLength;
    private String height;
    private String bodyLength;
    private String species;
    
    public Monkey(String name, String breed, String gender, String age, //constructor 
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry, 
    String tailLength, String height, String bodyLength, String species){
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
        setAnimalType("Monkey");
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);

    }
    public void setBreed(String _breed){ //Monkey breed accessor and mutator
        this.breed = _breed;
    } 
    public String getBreed(){
        return this.breed;
    }

    public void setTailLength(String tailLength_){//Monkey tail length accessor and mutator 
        this.tailLength = tailLength_;
    }
    public String getTailLength(){
        return this.tailLength;
    }

    public void setHeight(String height_){//Monkey height accessor and mutator 
        this.height = height_;
    }
    public String getHeight(){
        return this.height;
    }

    public void setBodyLength(String bodyLength_){//Monkey body length accessor and mutator 
        this.bodyLength = bodyLength_;
    }
    public String getBodyLength(){
        return this.bodyLength;
    }

    public void setSpecies(String species_){//Monkey species accessor and mutator 
        this.species = species_;
    }
    public String getSpecies(){
        return this.species;
    }
}