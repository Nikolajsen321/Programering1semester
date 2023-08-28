package Opgave1;

import java.util.ArrayList;

public class PlayerApp {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Player p = new Player("Hans",310,1000,2);
        players.add(p);
        p = new Player("Grethe",160,10,3);
        players.add(p);
        p = new Player("OndeFar",90,900000,4);
        players.add(p);
        p = new Player("OndeMor",100,20000,6);
        players.add(p);
        p = new Player("Heksen",100000,200,9);
        players.add(p);
        p = new Player("Skovhuggeren",1000,200,9);
        players.add(p);
        System.out.println(p.findPlayerLinear(players,4));

        System.out.println(p.findPlayerBinary(players,9));








    }
}
