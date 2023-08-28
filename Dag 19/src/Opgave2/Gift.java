package Opgave2;

public class Gift {
    private String description;
    private double price;
    private Person giftGiver;





    public Gift(String description1){
        this.description = description1;
    }

    public Person getGiftGiver()
    {
        return giftGiver;
    }

    public void setGiftGiver(Person person){
        if(giftGiver != person){
            giftGiver = person;
        }
    }

    public void setPrice(double price1){
        this.price = price1;
    }
    public double getPrice() {
        return price;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
