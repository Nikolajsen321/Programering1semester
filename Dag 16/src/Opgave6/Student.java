package Opgave6;

public class Student {
    private String name = "";
    private int age = 0;
    private boolean active;


    public Student(String name1, int age1, boolean active1)
    {
        this.name = name1;
        this.age = age1;
        this.active = active1;
    }
    public Student()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        if(active) {
            return "Name: " + name  + "\n" + "Age: " + age + "\n" + "Active: " + "Yes";
        } else {
            return "Name: " + name + '\'' + "\n" + "Age: " + age + "\n" +"Active: " + "No";

        }
    }
}
