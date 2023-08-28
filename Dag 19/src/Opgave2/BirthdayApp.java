package Opgave2;

public class BirthdayApp {
    public static void main(String[] args) {

        //Giver gaver
        Person guest1 = new Person("Jens",20);
        Gift givenGift1 = new Gift("Penge");
        givenGift1.setPrice(2000);
        givenGift1.setGiftGiver(guest1);

        Person guest2 = new Person("Hans",30);
        Gift givenGift2 = new Gift("Cykkel");
        givenGift2.setPrice(5000);
        givenGift2.setGiftGiver(guest2);
        System.out.println(givenGift1.getGiftGiver());
        //reciver gaver
        Person birthdayPerson = new Person("Karsen", 19);
        //Tilføjer gaverne til Arraylisten  giftReciving
        birthdayPerson.addGifts(givenGift1);
        birthdayPerson.addGifts(givenGift2);
        System.out.println(givenGift2.getGiftGiver());

        System.out.println(guest1.toString() + " giver en gave " + givenGift1.getDescription() + " der har "+
                "en pris på "+ givenGift1.getPrice());
        System.out.println(guest2.toString() + " giver en gave " + givenGift2.getDescription() + " der har "+
                "en pris på "+ givenGift2.getPrice()+ " Kr");

        System.out.println(birthdayPerson.toString() + " får altså i alt  for  " + birthdayPerson.sumOfValueFromAllGifts());
        System.out.println("Han modtager altså følgende gaver " + birthdayPerson.recivedGifts().get(0) +" og en " +
                birthdayPerson.recivedGifts().get(1));


    }
}
