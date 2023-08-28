package Opgave4;

public class Boy {
    private String name;

    public Boy(String name1){
        this.name = name1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String makeBoyString() {
        return "Boy{" +
                "name='" + name + '\'' +
                '}';
    }
}
