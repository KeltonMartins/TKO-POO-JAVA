public class Animal{
    private String species;
    private String sound;
    private int age;

    public Animal(String species, String sound){
        this.species = species;
        this.sound = sound;
    }

    public String makeSound(){
        if (this.age == 0){
            return "---";
        }
        if (this.age >= 4){
            return "RIP";
        }
        return this.sound;
    }

    public void ageBy(int increment){
        this.age += increment;
        if (this.age >= 4){
            this.age = 4;
            System.out.println("warning: " + this.species + " morreu");
        }
    }

    public String toString(){
        return this.species + ":" + this.age + ":" + this.sound;
    }
}