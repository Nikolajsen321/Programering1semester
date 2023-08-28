package loopstemplate;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.awt.*;

public class Gui extends Application {
	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------
	private void drawShapes(GraphicsContext gc) {
//		// Replace the statement here with your code.
//		// faktor
//		int faktor = 2;
//		int seizeX = 10 * faktor;
//		int seizeY = 4 * faktor;
//
//		// draw an arrowhead at (100,75)
//		int x = 100;
//		int y = 75;
//
//		gc.strokeLine(x, y, x + seizeX, y -seizeY);
//		gc.strokeLine(x, y, x + seizeX, y + seizeY);
//// draw an arrowhead at (25,140)
//		x = 100;
//		y = 125;
//		gc.strokeLine(x, y, x +seizeX, y - 4);
//		gc.strokeLine(x, y, x + seizeX, y + 4);
//// arrowhead at (20,50)

//		 x = 100;
//		 y = 100;
//		seizeX = -40 ;
//		 seizeY = 10;
//
//		gc.strokeLine(x, y, x + seizeX, y + seizeY);
//		gc.strokeLine(x, y, x  + seizeX, y - seizeY);

//		gc.strokeLine(10, 10, 150, 80);

		//eksempel 3

//		int x1 = 100; // starting point
//		int y1 = 200;
//		int x2 = 20; //end point
//		int y2 =10;
//
//		while(x2<=180){
//			gc.strokeLine(x1,y1,x2,y2);
//			x2 = x2 + 40; }

		// exercise 2

//			int x1 = 100; // starting point
//			int y1 = 100;
//			int x2 = 20; //end point
//			int y2 =10;
//
//			while(x2<=180){
//				gc.strokeLine(x1,y1,x2,y2);
//				x2 =x2 + 20;
//		}

		// eksempel 4 streger

//		int x1 = 20; // starting point (x2, y2)
//		int y1 = 190;
//		int x2 = 180; // end point (x2, y2)
//		int y2 = 10;
//		while(x1<=180) {
//			gc.strokeLine(x1,y1,x2,y2);
//			x1 = x1 + 40;
//			x2 = x2 - 40;
//		}

		// exercise 3 streger

		//figur 1

//		int x1 = 30;  // start punkt for x1 og y1
//		int y1 = 20;
//		int y2 = 180;
//
//		while(x1 <= 180){
//			gc.strokeLine(x1,y1,x1,y2);
//			x1 = x1 +40;
//
//		}
//
//		//figur 2

//		int x1 = 20;  // start punkt for x1 og y1
//		int y1 = 20;
//		int x2 = 180;
//		int y2 = 20;
//
//		while(y1 <= 180){
//			gc.strokeLine(x1,y1,x2,y1);
//			y1 = y1 +40;
//			y2 = y2 + 30;
//
//		}


		// figur 3
//
//		int x1 = 90 ;  // start punkt  (x1 og y1)
//		int y1 = 20;
//		int x2 = 100;  // slut punkt for x og y  (x2 og y2)
//		int y2 = 20;
//
//		while(y1 <= 180) {
//			gc.strokeLine(x1, y1, x2, y2);
//			y1 = y1 + 40;
//			y2 = y2 + 40;
//			x1 = x1 - 20;
//			x2 = x2 + 20;
//		}
//

//		Eksempel 5 cirkler og elipser

		// bennyter metoden  " gc.strokOval()"
		// tegner en eclipse inde i en rektangel hvor venstre upper hjørne er ved (20,80) og længden 160 og højden 60

//		gc.strokeOval(20,80,160,50);

		/* Hvis man vil tegne en cirkel  med centre (90, 110) og radius 40   skal man regne på
		venstre over hjørne om den græsende rektangel: (90 - 40, 110 - 40 = (50,70))

		areal og omkreds af cirkel:
		A = pi * r^2
		O = 2 * r * pi
		Formel for tegne cirkel centre (x,y) og radius r
		gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
		 */

		//gc.strokeOval(50,70,80,80);


		//eksempel 6
		/* family af cirkels  */

//		int x = 50;
//		int y = 100;
//		int r = 40;
//
//		while(x <= 150){
//			gc.strokeOval(x-r,y-r,2*r,2*r);
//			x = x +25;
//		}

		//Exercise 4 cirkler og elipser

////		figur 1 cirkler // her er x og y konstant da alle cirkler skal have samme centrum
		// men forskelige diameter
//		int x = 100;
//		int y = 100;
//		int r = 20;
//
//		while(r <= 150){
//			// hjørnet af rektangel er x -r og y-r der hvor rektangel og cirkel mødes, 2*r er længden og brede
//			// for en cirkel
//			gc.strokeOval(x-r,y-r,2 * r, 2 * r);
//			r = r +25;
//		}

		// figur 2 cirkler
// rigtig
//		int x = 20;
//		int y = 100;
//		int r = 10;
//
//		// her er y konstant da det kun er ud af x- aksen og r - radiusen der skal ændre sig
//
//		while (r <= 150) {
//			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//			x = x + 10;
//			r = r + 10;
//		}


//			// figur 3

		// rigtig figur

//		int x = 80;
//		int y = 40;
//		int l = 40;
//		int h = 100;
//
//		while(l<= 220){
//			gc.strokeOval(x,y,l,h);
//			x = x - 15;
//			l = l + 30;
//		}
//

		//Exercise 5
		// Datamatiker
		// her skal den udskrive ordet datamatiker, hvor man benytter koordinat x er konstant
		/* men den flyytter så fra  y - aksen og her

		 */

		int x =20;
		int y = 176;

		String s = " Datamatiker ";
		int i = 0;
		while(i <= 10) {
			s = s.substring(0,s.length() - 1);
			gc.strokeText(s,x,y);
			y -= 16;
			i ++;

		}

//

//		Eksempel 7 vil tegne 20 vertikale linjer med for - statement  og en afstand på 8 først ved x = 10
//
//		int y1 = 30; //start point
//		int y2 = 180; // end point
//		for(int i = 0; i < 20; i++){
//			int x = 10 + i * 8;
//			gc.strokeLine(x,y1,x,y2);
//		}

		// exercise 6  x - akse

		// laver x - aksen for mit koordinatsystem.
//		int x1 = 0;
//		int y1 = 180;
//		int x2 = 190;
//		int y2 = 180;
//		gc.strokeLine(x1,y1,x2,y2);
//////
//////		// ændre hvor lan hen aff x- aksen pilen er
//		x1 = 195;
//////// her laver jeg pilen til linjen;
//		gc.strokeLine(x1 ,y1,x1 - 10,y1+5);
//		gc.strokeLine(x1 ,y1,x1 -10,y1+-5);
////
////		// nu skal jeg lave en for løkke for at lave 11 prikker på- aksen
//		x1 = 0;
//		int tal1 = 0;
//		for(int i = 0; i < 11; i++){
//			x1 = x1 + 16;
//
//			if( i % 5 == 0 ){
//				y1 = 170;
//				y2 = 180;
//				String s = Integer.toString(i);
//				gc.strokeText(s,x1 -2,195);
////				tal1 = tal1 + 5;
//			} else
//			y1 = 175;
//			y2 = 185;
//			gc.strokeLine(x1,y1,x1,y2);
//		}

		// Exercise 7 lav teksten Datamatiker nu med for statment;

//		int x = 20;
//		int y = 170;
//		String s = " Datamatiker ";
//
//		for(int i = 0; i < 11; i++){
//			s = s.substring(0,s.length() - 1);
//			gc.fillText(s,x,y);
//			y -= 15;
//
//		}

		// Exercise 8

//		int x1 = 160;
//
//		int y1 = 80;
//		int y2 = 90 ;
//
//		for(int i = 0; i < 10; i++){
//			gc.strokeLine(x1,y1,x1,y2);
//			y1 +=2;
//			y2 += 11;
////			y1 +=4;
////			y2 += 12;
//			x1 -= 16;

//
//		}
		// Exercise 9 (Skal bruge en while statment)

//		int i = 0;
//		int x = 10;
//		int y1 = 85;
//		int y2 = 90 ;
//
//		while(i < 12){
//			gc.strokeLine(x,y1,x,y2);
//			x += i * 3 + 4;
////			x += x * 1.25;
//			y1 -=  i -1;
//			y2 += i + 1;
//			i++;
//		}
//		 hint delen
//		int i = 0;
//		double x = 20 ;
//		double y1 = 118;
//		double y2 =  125;
//
//		while ( x < 360 && i<10) {
//			gc.strokeLine(x, y1, x, y2);
//			x =  x + (x * 0.25) ;
//			y1 -=  i +3;  //x/5 ?
//			y2 +=  i -0.05;   // x/2 ??
//			i++;
//
//		}
		// fra klassen
//		double x = 180 ;
//		double y1 = 90;

//		while ( x >= 5) {
//			double y2 = y1 - x *0.2;
//			double y3 = y1 + x *0.5;
//
//			gc.strokeLine(x, y1, x, y3);
//			gc.strokeLine(x, y1, x, y2);
//			x-= x * 0.25;


//			for( double x = 180; x >= 5; x -= x*0.25) {
//				double y2 = y1 - x *0.2;
//			double y3 = y1 + x *0.5;
//
//			gc.strokeLine(x, y1, x, y3);
//			gc.strokeLine(x, y1, x, y2);
//
//			}
//
//			}


//	}


		// Eksempel 8 tegne en ring med 3 cirkler

//	private void drawRing(GraphicsContext gc) {
//		int x = 100;
//		int y = 100;
//		int r1 = 25;
//		int r2 = 20;
//		int r3 = 6;
//		gc.strokeOval(x - r1, y - r1, 2 * r1, 2 * r1);
//		gc.strokeOval(x - r2, y - r2, 2 * r2, 2 * r2);
//		gc.strokeOval(x - r3, y - r3, 2 * r3, 2 * r3);
//	}
// metode der tegner en ring med center i (X,y)
//	private void drawRing(GraphicsContext gc, int x ,int y) {
//		int r1 = 25;
//		int r2 = 20;
//		int r3 = 6;
//		gc.strokeOval(x - r1, y - r1, 2 * r1, 2 * r1);
//		gc.strokeOval(x - r2, y - r2, 2 * r2, 2 * r2);
//		gc.fillOval(x - r3, y - r1- r3/2, 2 * r3,  r3);
//		// tegne en ring med center (40,40) og en anden med (120,80)
//	}
//
//		private void drawShapes(GraphicsContext gc){
//		this.drawRing(gc, 120,40);
//		this.drawRing(gc,120,80);
//
//		}


		// Exercise 10 benyt metoden til at lave eksempel 6 med mange cirkler

//	private void drawCircles(GraphicsContext gc,int x, int y, int seize ) {
//		int r = 40;
//		gc.strokeOval(x-r,y-r,2*r, 2*r);
//		for (int r = 20; r < 90; r += 20) {
//
//
//
		}
	}
//	private void drawShapes( GraphicsContext gc){
//		int x = 50;
//		int y =100;
//		while(x < 150) {
//			this.drawCircles(gc, x, y);
//			// y - aksen for +
//			gc.strokeLine(x,y-5,x,y+5);
//			// x - aksen for +
//			gc.strokeLine(x-5,y,x+5,y);
//			x += 25;
//		}

//				this.drawCircles(gc,){
//					gc.strokeLine(x, size / 2, y, x + seize / 2, y);
//
//					gc.strokeLine(x, y - size / 2, x, y + seize / 2);
//				}

//

//



//
//		// Exercise 11 skal man lave + i midten af cirklerne
//
//	}

		// Exercise 12
//	private void drawTriangle( GraphicsContext gc, double x1, double y1,double x2,double y2) {
//
//
//		gc.strokeLine(x1,y1,x2,y2);
//
//
//	}
//	private void drawShapes(GraphicsContext gc){
//
//		this.drawTriangle(gc,40,90,150,90);
//		this.drawTriangle(gc,120,20,150,90);
//		this.drawTriangle(gc,120,20,40,90);
//
//	}


