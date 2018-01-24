import java.util.Scanner;

class Ex4
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    double x1, x2, discriminant;

    System.out.print("a = ");
    double a = input.nextDouble();
    System.out.print("b = ");
    double b = input.nextDouble();
    System.out.print("c = ");
    double c = input.nextDouble();

    if(a == 0) System.out.println("This is not a quadratic equation!");
    else
    {
        discriminant = (b * b) - (4 * a * c);
        if(discriminant < 0) System.out.println("The equation has no real roots.");
        else if (discriminant == 0)
        {
          System.out.println("The equation has one real root.");
          x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
          System.out.printf("x = %f \n", x1);
        }
        else if (discriminant > 0)
        {
          System.out.println("The equation has two real roots.");
          x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
          x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
          System.out.printf("x1 = %f \n", x1);
          System.out.printf("x2 = %f \n", x2);
        }
    }
  }
}
