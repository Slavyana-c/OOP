import java.util.Scanner;

class Ex1
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    double km, miles;

    System.out.print("km = ");
    km = input.nextDouble();
    miles = km * 0.625;

    System.out.printf("%.3f km = %.3f miles \n", km, miles);
  }
}
