package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;

public class Controller {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntalTimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntalTimer);
        Storage.addFrivilig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createFrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        FrivilligForening frivilligForening =
                new FrivilligForening(navn, mobil, maksAntalTimer, foreningsNavn, antalPersoner);
        return frivilligForening;
    }


    public static void InitStorage() {
        LocalDate start = LocalDate.of(2020, 06, 04);
        LocalDate slut = LocalDate.of(2020, 06, 06);

        Festival festival = createFestival("NotrhSide", start, slut);

        createFrivillig("Jane", "Tlf 12345677", 20);
        createFrivillig("Lone Hansen", "Tlf78787878", 25);
        createFrivillig("Anders Mikkelsen", "Tlf 55555555", 10);

        createFrivilligForening("Christan Madsen", "Tlfnr 23232323", 100,
                "Erhversakademi Aarhus", 40);

        LocalDate førstJobDato = LocalDate.of(2020, 06, 04);
        LocalDate andenJobDato = LocalDate.of(2020, 06, 05);
        LocalDate sidstJobDato = LocalDate.of(2020, 06, 06);


        String string = "";
        for (int i = 1; i <= 9; i++) {
            if (i <= 3) {
                string = "T" + i;
                Job job1 = festival.createJob(string, "Rengøring", førstJobDato, 100, 5);
            } else if (i < 3 && i <= 6) {
                string = "T" + i;
                Job job2 = festival.createJob(string, "Rengøring", andenJobDato, 100, 5);
            } else {
                string = "T" + i;
                Job job3 = festival.createJob(string, "Rengøring", sidstJobDato, 100, 5);
            }


        }
    }

    public static Vagt tagVagt(Job job, Frivillig frivillig, int timer) {
        Vagt vagt = null;
        try {
            if (frivillig.ledigeTimer() - timer >= 0 && job.ikkeBesatteTimer() - timer >= 0) {
                 vagt = job.createVagt(timer);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return vagt;
    }
}
