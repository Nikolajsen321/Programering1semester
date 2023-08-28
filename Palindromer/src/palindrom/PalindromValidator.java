package palindrom;

public class PalindromValidator implements PalindromValidatorI {

    @Override
    public boolean erGyldigtPalindrom(String ord) {
        boolean isItPalinDrom = false;
        String reversed = "";
        ord = ord.replace(" ", "");
        ord = ord.replace("-","");
        ord = ord.replace("+","");
        ord = ord.replace("?","");
        ord = ord.replace("=","");
        ord = ord.replace(",","");
        ord = ord.replace(">","");
        ord = ord.replace(":","");
        ord = ord.replace("(","");
        ord = ord.replace(")","");
        ord = ord.replace("!","");

        for(int i = ord.length() -1; i >= 0 ; i--) {
            char  etBogstav = ord.charAt(i);
            reversed += etBogstav;
        }
        if(ord.equalsIgnoreCase(reversed)){
            isItPalinDrom = true;
        }
        return isItPalinDrom;
    }


    @Override
    public boolean erGyldigtPalindromPrimtal(int tal) {
        return false;
    }
}
