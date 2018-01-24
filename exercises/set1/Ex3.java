import java.util.Scanner;

class Ex3
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.print("x1 = ");
    double x1 = input.nextDouble();
    System.out.print("y1 = ");
    double y1 = input.nextDouble();
    System.out.print("x2 = ");
    double x2 = input.nextDouble();
    System.out.print("y2 = ");
    double y2 = input.nextDouble();

    double result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    System.out.printf("d = %f \n", result);
  }
}
