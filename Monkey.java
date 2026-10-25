package grazioso;

// Monkey class inherits from RescueAnimal
public class Monkey extends RescueAnimal {

    // Monkey-specific instance variables
	private String species;
    private double tailLength;
    private double height;
    private double bodyLength;

    // Constructor that initializes all monkey attributes
    public Monkey(String name, String species, String gender, String age,
            String weight, double tailLength, double height,
            double bodyLength, String acquisitionDate,
            String acquisitionCountry, String trainingStatus,
            boolean reserved, String inServiceCountry) {

  setName(name);
  setSpecies(species);
  setGender(gender);
  setAge(age);
  setWeight(weight);
  setTailLength(tailLength);
  setHeight(height);
  setBodyLength(bodyLength);
  setAcquisitionDate(acquisitionDate);
  setAcquisitionLocation(acquisitionCountry);
  setTrainingStatus(trainingStatus);
  setReserved(reserved);
  setInServiceCountry(inServiceCountry);
  setAnimalType("monkey");
}
    // Accessor for species
    public String getSpecies() {
        return species;
    }

    // Mutator for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // Accessor for tail length
    public double getTailLength() {
        return tailLength;
    }

    // Mutator for tail length
    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    // Accessor for height
    public double getHeight() {
        return height;
    }

    // Mutator for height
    public void setHeight(double height) {
        this.height = height;
    }
    
    // Accessor for body length
    public double getBodyLength() {
        return bodyLength;
    }

    // Mutator for body length
    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }
}