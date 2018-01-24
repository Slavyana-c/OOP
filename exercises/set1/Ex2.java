import java.util.Scanner;

class Ex2
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int hours = 0, minutes = 0, seconds = 0;

    System.out.print("Time in seconds:");
    seconds = input.nextInt();
    minutes = seconds / 60;
    seconds %= 60;
    hours = minutes / 60;
    minutes %= 60;

    System.out.printf("%d hours, %d minutes, %d seconds\n",
                        hours, minutes, seconds);
  }
}
