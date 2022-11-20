package classTeaching.week8;

public class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student() {

    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ñ§ºÅ:" + this.id + ",ÐÕÃû:" + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return false;
        }
        if (obj instanceof Student s) {
            return this.name.equals(s.name) && this.id == s.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (31 + (this.name == null ? 0 : this.name.hashCode())) * 31 + this.id;
    }

    @Override
    public int compareTo(Student s) {
        if (this.getId() == s.getId()) {
            return this.getName().compareTo(s.getName());
        } else {
            return this.getId() - s.getId();
        }
    }
}
