package in.karatube;



public class Shape{

  public Shape(){
    System.out.println("init shape");
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

public boolean isOdd(int i)
{
  return true;
}

  public String getHSide(int size, String symb){
    String hside = "";
    for (int i = 1 ; i <= size; i++)
    {
      if((i%2)==0){
        // even
        for (int j = 0; i<2 ; i++)
        hside += symb;
      }else{// odd
        for (int j = 0; i<3 ; i++)
        hside += symb;
      }
    }
    return hside;
  }

  public void square(int size){
    String square = "";
    String hside = "+" + this.getHSide(size, "-") + "+" ;
    String vside = "|" + this.getHSide(size, " ") + "|" ;
    square += hside;
    for (int i = 0 ; i < size ; i++){

      square += vside ;
    }
    square += hside;
    System.out.println(square);
  }

  public void square2(int size){
    System.out.println(size);
    String square = "";
    String hside = "";
    String hspace = "";
    for(int i = 0; i < size * 3 ; i++){
      hside += "-";
      hspace += " ";
    }


    square += "+" + hside + "+" + "\n";
    for(int i = 0; i < size ; i++){
      square += "|" + hspace + "|" + "\n";

    }
    square += "+" + hside + "+" + "\n";
    System.out.println(square);
  }
}
