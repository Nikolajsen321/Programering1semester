package Opgave3;

public class RentalApp {
    public static void main(String[] args) {
        Rental r1 = new Rental(2,"20/4/2023",20);
        Rental r2 = new Rental(3,"20/5/2023",30);

        Car bmw = new Car("Abdadsa",2016);
        bmw.setDayPrice(200);
        r1.addCar(bmw);

        Car mercedes = new Car("daswasd",2009);
        mercedes.setDayPrice(100);
        r1.addCar(mercedes);

        Car volvo = new Car("oiajpdasdjpa",2020);
        volvo.setDayPrice(300);
        r2.addCar(volvo);

        Car peugot = new Car("mmmdndada",2001);
        peugot.setDayPrice(100);
        r2.addCar(peugot);

        Car skoda = new Car("skoda",1990);
        skoda.setDayPrice(400);
        r2.addCar(skoda);

        System.out.println("For bilerne i udlejning 1 vil den samlede pris for " + r1.getDays() + " dage " +
                " være på = ");
        System.out.println(r1.getPrice());

        System.out.println("For bilerne i udlejning 2 vil den samlede pris for " + r2.getDays() + " dage " +
                " Være på  = " );
        System.out.println(r2.getPrice() + " " + volvo.getLicense());

        System.out.println("For bilerne fra lejning nr. 1 ");
        for(Car element : r1.getCars()){
            System.out.println(element.getLicense() + " " + element.getDayPrice() + " " + element.getPurchaseYear());
        }

    }
}
