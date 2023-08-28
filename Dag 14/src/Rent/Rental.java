package Rent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;

public class Rental
{
    private int number = 0;
    private double price = 0;
    private Period days = Period.ofDays(0);
    private LocalDate startDate;

    public Rental(int number1,int days1, double price1,LocalDate startDate1)
    {
        this.number = number1;
        this.price = price1;
        this.days = Period.ofDays(days1);
        this.startDate = startDate1;

    }

    public double getPricePrDay()
    {
        return price;
    }

    public void setDays(int days1)
    {
        this.days = Period.ofDays(days1);
    }

    public int getDays()
    {
        String day = "";
        int dayInt = 0;
        dayInt = days.hashCode();
//        day = days.toString();
//        dayInt = Integer.parseInt(day);

        return dayInt;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public LocalDate getEndDate()
    {
        return getStartDate().withDayOfYear(getDays());
    }
}
