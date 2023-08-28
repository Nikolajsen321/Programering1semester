//import java.util.Scanner;
//
//public class Opgave2 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        //Scanner variable
//        System.out.println(" \n indtast integers mellem 1 til 99 og programmet vil tælle, " +
//                " \n hvor mange lige/ulige tal der er samt give summen af alle tal " +
//                " \n samt hvor mange gange det største og mindste tal forkommer igen ");
//        int data = input.nextInt();
//
//
//        // konstante variabler
//        int ligeTal = 0;
//        int uligeTal = 0;
//        int biggest = data;
//        int countBiggest = 0;
//        int smallest = data;
//        int countSmallest = 0;
//        int data1 = 0;
//        int sum = 0;
//        int i = 0;
//
//        String metodeString = " ";
//
//        // String variabler
//        String l1 = " ";
//        String række = " ";
//
//        while (data != 0) {
//            // selektion statment der fortæller du har valgt et tal der ikke giver mening
//            if (data >= 1 && data <= 99) {
//
//
//                metodeString = ligeUlige( data );
//                System.out.println( metodeString);
//
//                // 1 selektion statments if else der vurdere om tallet er lige er ulige og lææger til lige/ulige
//
//
//                if (data % 2 == 0 ) {
//                    ligeTal++;
//                    System.out.println(ligeTal + " lige tal ");
//
//                } else {
//                    uligeTal++;
//                    System.out.println(uligeTal + " ulige tal");
//                }
//
//                /* 2 selektions -  if - else statements for at bestemme om det er det størst eller mindst tal
//                samt lægger sammen hvor mange gange det største tal går igen
//                 */
//                if (data < smallest) {
//                    smallest = data;
//                    countSmallest = countSmallest * 0 + 1;
//                    System.out.println(" det mindste tal er nu" + smallest);
//
//                } else if (data == smallest) {
//                    countSmallest++;
//                }
//
//                // Selektion statments der fortællr om det nye tal nu er det største eller det mindste
//                if (data > biggest) {
//                    biggest = data;
//                    countBiggest = countBiggest * 0 + 1;
//                    System.out.println(" det største tal er nu" + biggest);
//
//                } else if (data == biggest) {
//                    countBiggest++;
//                }
//
//            /* if else statment for at vise alle tal der ligges sammen, i++ bruges så der ikke
//            er probelmmer med at få 1+0 så det i stedet bliver 1 og så bliver det fx +3 +6 +7+8
//             */
//                if (data != 0) {
//                    l1 = Integer.toString(data);
//                    række += " + " + l1;
//                } else {
//                    l1 = Integer.toString(data);
//                    række = l1;
//                }
//
//                // selektion statment der fortæller hvad tal der går igen
//                if (data - data1 == 0) {
//                    System.out.println(data + " tallet går igen");
//                }
//                data1 = data;
//
//                sum += data;
//
//                System.out.println(" summen i alt er" + række + " = " + sum + " og mindste tal" +
//                        smallest + "forkommer " + countSmallest + " det største forkommer" +
//                        biggest + " forkommer " + countBiggest);
//
//                i++;
//                //ny input
//                data = input.nextInt();
//            }
//            // if -else statement der starter linje 30
//            else {
//                System.out.println(" prøve igen");
//                data = input.nextInt();
//            }
//            // end of loop
//        }
//        // ude for loop
//        System.out.println(" Det største tal blev altså " + biggest + " Det mindste bliver" + smallest +
//                " Der er " + ligeTal + " ligetal og" + uligeTal + " ulige tal" +
//                " summen er i alt " + række + " = " + sum);
//    }
//
//    public static void ligeUlige(int tal){
//        int countLige = 0;
//        int countUlige = 0;
//        int addValue = 0;
//
//        String countString = " ";
//        String result = " ";
//
//
//        if( tal % 2 == 0){
//            System.out.println( );
//            countLige ++;
//            addValue = countLige;
//
//            countString = Integer.toString( addValue);
//            result = countString + " Lige tal ";
//
//        }else {
//            countUlige++;
//            countString = Integer.toString( countUlige);
//            System.out.println(countString + " Ulige tal");
//
//        }
//    }
//
//}
