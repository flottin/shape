package in.karatube;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import java.lang.StringBuilder;

import java.io.File;
  import java.io.FileReader;
  import java.io.InputStreamReader;
  import java.io.InputStream;
  import java.io.Reader;
  import java.net.URI;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;

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
    /**
    * generate a square
    */
    public void square(int size){
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
    /**
    * is int even
    */
    public boolean isEven(int i)
    {
        if((i%2)==0) {
            return true;
        }else{
            return false;
        }
    }

    /**
    *
    */
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

    /**
    * make a pause
    *  @param int t pause time
    */
    public void wait(int t)
    {
      try{
          TimeUnit.MILLISECONDS.sleep(t);
      }catch(Exception e){

      }
    }

    /**
    *
    */
    public void bars(int size)
    {
      for (int j = 0 ; j < size ; j++){
          for (int i = 0 ; i < size ; i++){
                this.bar();
                this.wait(50);
            }
            this.wait(300);
        }

        System.out.println(readFromFile("heart",50));
        System.out.println(readFromFile("diamond",50));
        System.out.println(readFromFile("spade",50));
    }

    /**
    *
    */
    public void bar()
    {
        int Min = 5;
        int Max = 15;
        int nombreAleatoire = Min + (int)(Math.random() * ((Max - Min) + 1));
        String bar = StringUtils.repeat("-", nombreAleatoire);
        bar = StringUtils.rightPad(bar, 50, "+");
        StringBuilder sb = new StringBuilder(bar);
        bar += sb.reverse().toString();
        ConsoleColors.display(bar, "PURPLE_BOLD");
    }

    /**
    *
    */
	public  String readFromFile(String  filename, int size) {

        try
        {
            InputStream in = getClass().getResourceAsStream("/shapes/"+ filename + ".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String sCurrentLine;
            String fileContent="";
			while ((sCurrentLine = br.readLine()) != null) {
				fileContent += StringUtils.center(StringUtils.trim(sCurrentLine), size, "") + "\n";
			}
            return fileContent;
		} catch (IOException e) {
			e.printStackTrace();
		}
        return "";
	}


}
