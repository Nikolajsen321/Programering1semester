package Model;

import Controller.Controller;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der hæves på en konto med saldo under 0");

		KontoType kontotype1 = Controller.createKontoType("Opsparing","En konto type til at spare penge op");
		Konto k1 = Controller.createKonto(kontotype);
		Konto k2 = Controller.createKonto(kontotype1);

		Controller.foretagTransaktion(k1, 100);
		Controller.foretagTransaktion(k2, 100);
		System.out.println("Navn er " + kontotype1.getNavn() + " Beskrivelse " + kontotype1.getBeskrivelse() );
		System.out.println(k1.toString());
		System.out.println(k2.toString());
		Controller.foretagTransaktion(k1, -200);
		System.out.println(k1.toString());
		Controller.foretagTransaktion(k1, 500);
		System.out.println(k1.toString());
		Controller.foretagTransaktion(k1, 900);
		Controller.kontoTilstand(k1,Tilstand.SPAERRET);
		System.out.println(k1.getTilstand());
		Controller.foretagTransaktion(k1, -200); // giver exception
		Controller.kontoTilstand(k1,Tilstand.AABEN);
		System.out.println(k1.getTilstand());
		Controller.foretagTransaktion(k1,100);
		System.out.println(k1.toString());




	}
}
