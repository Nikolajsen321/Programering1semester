import java.util.ArrayList;
import java.util.Collections;

public class Opgave4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Jan");
        list.add("Bent");
        list.add("Thimas");
        list.add("Karsten");
        list.add("Dan");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
