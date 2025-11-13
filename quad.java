import java.util.Scanner;
public class quad {
    public static void main(String[] args) {
        int a,b,c;
        double d,r1,r2;
        System.out.println("Enter values for a b and c:");
        Scanner sc=new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        if (a==0)
        {
            System.out.println("A cannot be negative");
        }
        else{
            d=(b*b)-(4*a*c);
            if (d<0)
            {
                System.out.println("there are no real solution");
            }
            else if(d==0)
            {
                System.out.println("The roots are equal");
                r1=-b/(2*a);
                System.out.println("The roots are:"+r1);
            }
            else 
            {
                System.out.println("Roots are complex");
                r1=-b/(2*a);
                r2= Math.sqrt((d)/(2*a));
                System.out.println("Real part:"+r1);
                System.out.println("Imaginary part:"+r2);
            }
            sc.close();
        }

    }
}
