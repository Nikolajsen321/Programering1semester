package Game;

import java.util.ArrayList;


public class Team {
    private String name;

    private ArrayList<Player> players;

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Player> getPlayers(){return players;}

    public void setPlayers(ArrayList<Player>players1){this.players = players1;}

    public void addPlayers(Player player1)
    {
        players.add(player1);
    }

    public void printPlayers()
    {
//        String string;
        for(Player str : players)
        {
            System.out.println("Navn " + str.getName() + "\t" +"Alder " + str.getAge() + " Score " + str.getScore());
        }
    }

    public double calcAverageAge()
    {
        double sum = 0;
        for(Player element : players)
        {
           sum += element.getAge();
        }
        return  sum / players.size();
    }

    public int calcTotalScore()
    {
        int sum = 0;
        for(Player element : players)
        {
            sum += element.getScore();
        }
        return sum;
    }

    public int calOldPlayers(int ageLimit)
    {
        int sum  = 0;
        for(Player element : players)
        {
           if(element.getAge() > ageLimit)
           {
               sum += element.getScore();
           }
        }
        return sum;
    }

    public int maxScore()
    {
       int maximum = players.get(0).getScore();
       for(Player element : players)
       {
           if(element.getScore() > maximum)
           {
               maximum = element.getScore();
           }
       }
       return maximum;
    }
    public ArrayList<String> bestPlayerNames()
    {
        ArrayList<String> bestPlayer = new ArrayList<>();
        String string = "";

        for(Player element : players)
        {
            if(maxScore() == element.getScore())
            {
                bestPlayer.add(String.valueOf(element));
//                bestPlayer.add(element.getName());
            }
        }
        return bestPlayer;
    }


    @Override
    public String toString() {
        String string ="Team{" +
                 name + '\'' +
                '}';

        for(Player element : players)
        {
            string += "\n" + element.getName();
        }
        return string;
    }
}
