package in.karatube;

public class Shape{

  public Shape(){
    System.out.println("init shape");
  }
/**
  +---------+
 /         /|
+---------+ |
|         | |
|         | +
|         |/
+---------+

+---+
|   |
+---+

+------+
|      |
|      |
+------+

*/
  public void square(int size){
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
