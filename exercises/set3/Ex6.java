import java.util.Scanner;

class Rectangle
{
  private double width;
  private double height;

  public Rectangle()
  {
    this(1.0, 1.0);
  }

  public Rectangle(double w, double h)
  {
    getWidth(w);
    getHeight(h);
    getArea(w, h);
    getPerimeter(w, h);
  }

  public double getWidth(double w)
  {
    return w;
  }

  public double getHeight(double h)
  {
    return h;
  }

  public double getArea(double w, double h)
  {
    return w * h;
  }

  public double getPerimeter(double w, double h)
  {
    return 2 * (w + h);
  }
}

public class Ex6
{
  public static void main(String[] args)
  {
  }
}
