package in.karatube;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;



public class Shape{

  public Shape(){
  }

/**

 +---------+
/         / |
+---------+  |
|         |  |
|         |  +
|         | /
+---------+
+---+
|   |
+---+

+------+
|      |
|      |
+------+

*/

public boolean isEven(int i)
{
    if((i%2)==0) {
        return true;
    }else{
        return false;
    }
}

  public String getHSide(int size, String symb){
    String hside = "";
    int count;
    for (int i = 1 ; i <= size; i++)
    {
      count = true == this.isEven(i) ? 2 : 3;
      hside += StringUtils.repeat(symb, count);
    }
    return hside;
  }

  public void square(int size){
      System.out.println(size);
    String square = "";
    String hside = "+" + this.getHSide(size, "-") + "+" ;
    String vside = "|" + this.getHSide(size, " ") + "|" ;
    square += hside + "\n";
    for (int i = 0 ; i < size ; i++){

      square += vside + "\n";
    }
    square += hside + "\n";
    System.out.println(square);
  }

  public void wait(int t)
  {
      try{
          TimeUnit.MILLISECONDS.sleep(t);
      }catch(Exception e){}
  }

  public void bars(int size)
  {
      for (int j = 0 ; j < size ; j++){
      for (int i = 0 ; i < size ; i++){
          this.bar();
          this.wait(50);
      }
      this.wait(300);
        }



  }

  public void bar()
  {
      int Min = 5;
      int Max = 15;
          int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));

          String bar = "----------";
          for (int i=1 ; i <= nombreAleatoire; i++)
          {
              bar += "-";
          }
          ConsoleColors.display(StringUtils.rightPad(bar, 40, "+"), "PURPLE_BOLD");
      //System.out.println(bar);
  }
}
