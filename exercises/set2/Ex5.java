import java.util.Scanner;

class Ex5
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your password: ");
    String password = input.nextLine();

    if(password.length() < 8) System.out.println("Password is too short.");
    else
    {
    int uppercase = 0, lowercase = 0, digits = 0, whitespace = 0;

      for (int i = 0; i < password.length() ; ++i)
      {
        if(Character.isDigit(password.charAt(i))) digits++;
        else if(Character.isUpperCase(password.charAt(i))) uppercase++;
        else if(Character.isLowerCase(password.charAt(i))) lowercase++;
        else if(password.charAt(i) == ' ') whitespace++;
      }

      System.out.printf("%d uppercase\n", uppercase);
      System.out.printf("%d lowercase\n", lowercase);
      System.out.printf("%d digits\n", digits);
      System.out.printf("%d whitespace\n", whitespace);

      if(digits > 0 && uppercase > 0 && lowercase > 0 && whitespace == 0)
          System.out.println("Password is OK");
      else System.out.println("Invalid Password");

    }
  }
}
