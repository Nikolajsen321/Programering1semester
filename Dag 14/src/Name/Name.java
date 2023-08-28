package Name;

import javax.management.StringValueExp;
import java.util.Random;

public class Name {
    private String firstName;
    private String lastName;

    private String middleName;

    private String secondName;

    private String thirdName;

    private String empty = null;

    private  char charMiddleName = '\u0000';

    public Name() {

    }

    public Name(String firstName1, String secondName1,String lastName1) {
        this.firstName = firstName1;
        this.secondName = secondName1;
        this.lastName = lastName1;

    }

    public Name(String firstName1, String secondName1, String thirdName1, String lastName1) {
        this.firstName = firstName1;
        this.secondName = secondName1;
        this.thirdName = thirdName1;
        this.lastName = lastName1;
    }


    public void setFirstName(String firstName1) {
        this.firstName = firstName1;

    }

    public String getFirstName() {
        return firstName;

    }

    public void setMiddleName(String middleName1) {
        if (middleName1 == "") {
            this.middleName = empty;
        } else {
            this.middleName = middleName1;
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName1) {
        this.lastName = lastName1;
    }

    public String getLastName() {

        return lastName;
    }

    public String getUserName()
    {
        String numberMid = "";
        double mNumberMid = 0;
        String firstTwo = firstName.substring(0, 2);
        firstTwo = firstTwo.toUpperCase();
        if(middleName == null)
        {
             mNumberMid = Math.random() * 10.0;
              numberMid = Double.toString(mNumberMid);
             numberMid = numberMid.substring(0,1);
//             this.charMiddleName = '\u0000';

        }else
        {
            mNumberMid = middleName.length();
            numberMid = Double.toString(mNumberMid);
            numberMid = numberMid.substring(0,1);
            this.charMiddleName = numberMid.charAt(0);
        }
        String lastTwo = lastName.substring(lastName.length() - 2, lastName.length());
        lastTwo = lastTwo.toLowerCase();

        return firstTwo + numberMid + lastTwo;
    }

    public String getInts()
    {
        String ints = "";
        String firstInt = firstName.substring(0,1);
        String midInt ="";

        String lastInt = lastName.substring(0,1);
        if(middleName == null)
        {
         midInt ="";

        }else
        {
            midInt = middleName.substring(0,1);
        }

        ints = firstInt + midInt + lastInt;
        return ints;
    }
    public String  getCryptoInits()
    {
        int count = 2;
        char crypFirst = firstName.charAt(0);
        char crypMidle = (char) charMiddleName;


        if ( crypMidle == '\u0000')
        {
            crypMidle = '\u0000';
        }else
        {
            crypMidle = middleName.charAt(0);
            int crypMidle1 = (int) crypMidle;
            crypMidle1 = crypMidle1 + count;
            crypMidle = (char) crypMidle1;
        }

        char crypLast = lastName.charAt(0);

        String cryp = "";

        int crypFirst1 = (int) crypFirst;
        crypFirst1 = crypFirst1 +count;
        crypFirst = (char)crypFirst1;






        int crypLast1 = (int) crypLast;
        crypLast1 = crypLast1 +count;
        crypLast = (char)crypLast1;

        if(crypMidle == '\u0000')
        {
            cryp = String.valueOf(crypFirst) + String.valueOf(crypLast);
        }else
        {
            cryp = String.valueOf(crypFirst) + String.valueOf(crypMidle) + String.valueOf(crypLast);
        }


        return cryp;



    }


    @Override
    public String toString() {
        if (middleName == null && thirdName == null)
        {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        } else if ( middleName == null  ) {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", thirdName='" + thirdName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';

        } else if(middleName == null && secondName == null) {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        } else;
         return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                '}';
    }
    }

