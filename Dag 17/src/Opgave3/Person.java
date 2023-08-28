package Opgave3;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person(String name1,String title1, boolean senior1) {
        this.name = name1;
        this.title = title1;
        this.senior = senior1;
    }
    public Person(String name1,String title1) {
        this.name = name1;
        this.title = title1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSenior() {
        return senior;
    }

    public void setSenior(boolean senior) {
        this.senior = senior;
    }

    @Override
    public String toString() {
        String string =  " ";
        if(senior) {
            string = name + "(senior)" + " " + title;
        }else
        {
            string = name  + " " + title;
        }
        return string;
    }
}
