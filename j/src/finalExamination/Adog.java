package finalExamination;

public class Adog {
    String name;
    String breed;
    int age;

    public Adog() {

    }

    public Adog(String name, String breed, int age) {
        super();
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public void bark() {
        System.out.print("汪汪汪！！");
    }

    public String toString() {
        return "名字:" + name + ",品种:" + breed + ",年龄:" + age;
    }

    public boolean equals(Adog d) {
        return d.age == this.age && d.breed.equals(this.breed) && d.name.equals(this.name);
    }
}
