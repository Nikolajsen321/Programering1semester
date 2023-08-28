package ex3student;

public class Stars {
    public static void main(String[] args) {
        System.out.println(" Række A");
        exA(10);

        System.out.println();

        System.out.println(" Række B");
        exB(10);

        System.out.println();

        System.out.println(" Række C");
        exC(10);

    }

    public static void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);

            // print stars
            int starCount = rowCount + 1 - row;
            for (int i = 1; i <= starCount; i++) {
                System.out.print('*');
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(' ');
            }

            // new line
            System.out.println();
        }

    }
    public static void exB(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);

            // print dashes
            int dashCount = rowCount - row;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(' ');
            }

            // print stars
            int starCount = rowCount - dashCount - 1;
            for (int i = 0; i <= starCount; i++) {
                System.out.print('*');
            }



            // new line
            System.out.println();
        }

    }
    public static void exC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {

            // print row number
            System.out.printf("%2d: ", row);

            int dashCount = rowCount - row +1 ;
            for (int i = 10; i > dashCount; i--) {
                System.out.print(' ');
            }

            // print stars
            int starCount =  rowCount - dashCount  +1;
            for (int i = 10; i >= starCount; i--) {
                System.out.print('*');
            }

            // new line
            System.out.println();
        }

    }
}
