package classTeaching.week3;

public class People {
    public String name;
    public String address;
    public int age;
    public String telephone;

    public People() {

    }

    public People(String name, String address, int age, String telephone) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone != null && !telephone.equals("")) {
            this.telephone = telephone;
        }
    }

    @Override
    public String toString() {
        return "姓名" + name + ",地址" + address + ",年龄" + age + ",电话号码:" + telephone;
    }
}
