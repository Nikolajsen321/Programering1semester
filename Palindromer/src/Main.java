public class Main {
    public static void main(String[] args) {
        String ord1 = "Hannah";
        String ord2 = "Anna";
        String ord3 = "Mikkel";
        String ord4 = "Gider du pudre dig";

        System.out.println("Er sætningen et palindrom");

        System.out.println(isItPalinDrom(ord1));
        System.out.println(isItPalinDrom(ord2));
        System.out.println(isItPalinDrom(ord3));
        System.out.println(isItPalinDrom(ord4));

    }

    private static boolean isItPalinDrom(String ord) {
        boolean isItPalinDrom = false;
        String reversed = "";
        ord = ord.replace(" ","");
        ord = ord.replace("-","");
        ord = ord.replace("+","");

        for(int i = ord.length() -1; i >= 0 ; i--) {
           char  etBogstav = ord.charAt(i);
            reversed += etBogstav;
        }
        if(ord.equalsIgnoreCase(reversed)){
            isItPalinDrom = true;
        }
        return isItPalinDrom;
    }
}