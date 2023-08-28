package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Festival {
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Job> jobs = new ArrayList<>();


    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }


    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        Job job = new Job(kode,beskrivelse,dato,timeHonorar,antalTimer);
        jobs.add(job);
        return job;
    }


    public ArrayList<Job> getJobs(){
        return new ArrayList<>(jobs);
    }

    public int budgetterJobudgift(){
        int samletUdgift = 0;
        for(Job element : jobs){
            samletUdgift += element.getTimeHonorar() * element.getAntalTimer();
        }
        return samletUdgift;
    }


    public int realiseretJobUdgift(){
        int samletUdgift = 0;
        for(Job element : jobs){
           for(Vagt v : element.getVagter()){
               samletUdgift += v.getTimer() * element.getTimeHonorar();
           }
        }
        return samletUdgift;
    }

    public ArrayList<String> gaverTilFrivillige(){
        ArrayList<String> gavertilDem = new ArrayList<>();
        ArrayList<Frivillig> frivilligs = new ArrayList<>();
        String string = "";
        for(Job job : jobs){
            for(Vagt vagt : job.getVagter()){
                frivilligs.add(vagt.getFrivillig());
            }
            int currentMinIndex = 0;
            for(int i = 0; i < frivilligs.size(); i++){
                for(int j = i +1; j < frivilligs.size(); j++){
                    if(frivilligs.get(i).getNavn().compareTo(frivilligs.get(j).getNavn()) < 0){
                        currentMinIndex = j;
                    }

                }
                swapGaver(frivilligs,i,currentMinIndex);
                gavertilDem.add(frivilligs.get(i).udskrivFrivillig());
            }

        }

        return gavertilDem;
    }

    public void swapGaver(ArrayList<Frivillig> frivilligs,int i, int j){
        Frivillig temp = frivilligs.get(i);
        frivilligs.set(i,frivilligs.get(j));
        frivilligs.set(j,temp);

    }



}
