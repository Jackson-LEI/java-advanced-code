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
        System.out.print("����������");
    }

    public String toString() {
        return "����:" + name + ",Ʒ��:" + breed + ",����:" + age;
    }

    public boolean equals(Adog d) {
        return d.age == this.age && d.breed.equals(this.breed) && d.name.equals(this.name);
    }
}
