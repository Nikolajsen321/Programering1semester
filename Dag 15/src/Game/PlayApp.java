package Game;

public class PlayApp
{
    public static void main(String[] args)
    {
        Team team1 = new Team("A");
        Player player1 = new Player("Hans",20,30);
        Player player2 = new Player("Hans2",21,31);
        Player player3 = new Player("Hans3",22,32);
        Player player4 = new Player("Hans4",23,32);

        team1.addPlayers(player1); team1.addPlayers(player2);
        team1.addPlayers(player3); team1.addPlayers(player4);

        team1.printPlayers();

        System.out.println(team1.toString());

        System.out.println("Gennemsnit alder " + team1.calcAverageAge());
        System.out.println("Total score " + team1.calcTotalScore());
        System.out.println("Score beregnet for alt over 21 " + team1.calOldPlayers(21));
        System.out.println("Hvad er max score? " + team1.maxScore());
        System.out.println("Arraylist for bedste player " + team1.bestPlayerNames());



    }
}
