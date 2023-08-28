public class Opgavebog {
    public static void main(String[] args){
        System.out.println(1+2+3+4+5+6+7+8+9);

        System.out.println(4.0*(1.0-1/3+1/5-1/7+1/9-1/11));

        // Tilnærme sig pi
        System.out.println(4.0*(1.0-1/3+1/5-1/7+1/9-1/11+1/13));

        //cirkel omkreds
        System.out.println(2*5.5*3.141592);

        //cirkel areal
        double ans1=(double)Math.pow(5.5,2);
        double pi=(double)Math.PI;

        System.out.println(ans1*pi);

        //rektangel areal
        System.out.println(4.5*7.9);

        //rektangel omkreds
        System.out.println(2*(4.5+7.9));
    }
}
