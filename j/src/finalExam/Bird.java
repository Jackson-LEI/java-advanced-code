package finalExam;

public class Bird extends Animal{
    private String color;

    public Bird(){

    }

    public Bird(String breed, int age, String color){
        super(breed,age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void fly(){
        System.out.println("Œ“∑…¿≤!");
    }

    @Override
    public void show() {
        super.show();
        System.out.print("—’…´£∫"+this.color);
    }
}
