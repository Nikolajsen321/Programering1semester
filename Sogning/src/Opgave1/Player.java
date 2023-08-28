package Opgave1;

import java.util.ArrayList;

public class Player {
    private String name;
    private int height;
    private int weight;
    private int scoredGoals;

    public Player(String name, int height, int weight, int scoredGoals) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    public Player findPlayerLinear(ArrayList<Player> players, int score){
    Player player = null;
        int i = 0;
        while(player == null && i < players.size()){
            int p = players.get(i).getScoredGoals();
            if(p == score){
                player = players.get(i);
            }else{
                i++;
            }
        }
        return player;
    }
    public Player findPlayerBinary(ArrayList<Player> players, int score){
        Player player = null;
        int left = 0;
        int rigth = players.size()-1;
        while(player == null && left <= rigth) {
            int middel = (left + rigth) / 2;
            Player p = players.get(middel);
            if(p.getScoredGoals() == score){
                player = p;
            }else{
                if (p.getScoredGoals() < score){
                    left = middel + 1;
                }else {
                    rigth = middel - 1;
                }
            }
        }
        return player;
    }

    @Override
    public String toString() {
        return "Opgave1.Player{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", scoredGoals=" + scoredGoals +
                '}';
    }
}
