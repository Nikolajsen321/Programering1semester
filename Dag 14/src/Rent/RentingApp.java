package Rent;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RentingApp {
    public static void main(String[] args)
    {
        Rental rental1 = new Rental(1,20,3000, LocalDate.of(2020,1,30));

        System.out.println(rental1.getStartDate());
        System.out.println(rental1.getEndDate());
        System.out.println(rental1.getDays());
    }

}
