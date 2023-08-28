package Name;

public class Main {
    public static void main(String[] args)
    {

        Name navn1 = new Name();
        Name navn2 = new Name("Nikolaj", "Anton", "Christansen");
        Name navn3 = new Name("Nikolaj","Anton","Bent","Christiansen");
        Name navn4 = new Name("Nikolaj","Karsten","Kjeld","Andersen");


        navn1.setFirstName("Nikolaj");
        navn1.setMiddleName("Kahr");
        navn1.setLastName("Christiansen");
        System.out.println(navn1.getFirstName() + " " + navn1.getMiddleName() + " " + navn1.getLastName());
        System.out.println(navn1.getUserName());
        System.out.println(navn1.getInts());
        System.out.println();
        System.out.println(navn2.toString());
        System.out.println(navn2.getUserName());
        System.out.println(navn2.getInts());
        System.out.println();
        System.out.println(navn3.toString());
        System.out.println(navn3.getUserName());
        System.out.println(navn3.getInts());




         char a = (char)97 + 2;
        System.out.println(a);
        System.out.println(navn1.getCryptoInits());
        System.out.println();
        System.out.println(navn2.getCryptoInits());

        System.out.println();
        System.out.println(navn4.toString());

    }
}
