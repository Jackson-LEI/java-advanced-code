package finalExam;

public class Animal {
    private String breed;
    private int age;

    public Animal(){
        super();
    }

    public Animal(String breed, int age){
        this.breed = breed;
        this.age = age;
    }

    public String getBreed(){
        return this.breed;
    }

    public int getAge(){
        return this.age;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void show(){
        System.out.println("∆∑÷÷£∫"+this.breed + "\t" + "ƒÍ¡‰£∫"+this.age);
    }
}
