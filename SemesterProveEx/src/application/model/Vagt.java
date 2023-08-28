package application.model;

public class Vagt {
    private int timer;
    private Job job;

    Frivillig frivillig;

     Vagt(int timer, Job job) {
        this.timer = timer;
        this.job = job;

    }

    public int getTimer() {
        return timer;
    }

    public Job getJob(){
         return job;
    }

    public void setFrivillig(Frivillig frivillig){
         if(this.frivillig !=frivillig){
             Frivillig gammelFrivilig = this.frivillig;
             if(gammelFrivilig != null){
                 gammelFrivilig.removeVagt(this);
             }
             this.frivillig = frivillig;
             if(frivillig != null){
                 frivillig.addVagt(this);
             }
         }
    }
    public Frivillig getFrivillig(){
         return frivillig;
    }
}
