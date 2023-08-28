package test;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromGeneratorTest
{
    ArrayList<String> palindromdatoer;

    @BeforeEach
    void setUp() throws Exception
    {
        palindromdatoer = new ArrayList<String>();

//        URL url = getClass().getResource("test-palindrom-datoer.txt");
        File fileNavn = new File("C:\\Users\\nikol\\OneDrive\\Skrivebord\\Datamatiker\\programering\\PRO1 23V\\Palindromer\\src\\test\\test-palindrom.txt");
        File palindromTxt = new File(fileNavn.getPath());
        Scanner palindromScanner = new Scanner(palindromTxt);
        while (palindromScanner.hasNextLine())
        {
            String data = palindromScanner.nextLine();
            palindromdatoer.add(data);
        }
        palindromScanner.close();
    }

    @Test
    void test()
    {
        fail("Not yet implemented");
    }

}
