package in.karatube;
import org.apache.commons.cli.*;
import java.io.Console;
import java.util.Random;
import java.lang.Math;
import java.lang.StringBuilder;

/**
 * making shape
 *
 */
public class App
{
    public static void main( String[] args )
    {
        Options options = new Options();
        options.addOption("b", "bars", true, "display horizontal bars : the parameter is a number of bars requested");
        options.addOption("c", "color", true, "color");
        options.addOption("m", "msg", true, "colorized msg");
        options.addOption("d", "dry-run", true, "make a dry-run");
        options.addOption("h", "help", false, "display help");
        options.addOption("f", "figure", true, "shape mv ");
        options.addOption("r", "random", true, "randomise");
        options.addOption("s", "size", true, "shape size");
        options.addOption("t", "table", true, "table ");
        options.addOption("u", "utf8", true, "utf8");
        options.addOption("w", "windows", true, "windows");

        String header = "\nGenerate many shapes!\n\n";
        String footer = "\nPlease report issues at https://github.com/flottin/shape/issues";

      try {
        CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse( options, args);

            if (null == args || cmd.hasOption("h") == true ){
              HelpFormatter formatter = new HelpFormatter();
              formatter.printHelp("java -jar shape.jar", header, options, footer, true);
            }

            if(cmd.hasOption("b")) {
                String number = cmd.getOptionValue("b");
                int size = Integer.parseInt(number);
                Shape shape = new Shape();
                shape.bars(size);
            }

            if(cmd.hasOption("c") && cmd.hasOption("m")) {
                ConsoleColors.display(cmd.getOptionValue("m"), cmd.getOptionValue("c"));
            }

            if(cmd.hasOption("d")) {
                System.out.println(cmd.getOptionValue("d"));
            }
            if(cmd.hasOption("f")) {
                String name = cmd.getOptionValue("f");

                Shape shape = new Shape();
                shape.shape(name);
            }

            if(cmd.hasOption("r")) {
              Random r = new Random();
              String number = cmd.getOptionValue("r");
              int size = Integer.parseInt(number);

              System.out.println((int)Math.floor(r.nextFloat() * size));

            }

            if(cmd.hasOption("s")) {
                String number = cmd.getOptionValue("s");
                int size = Integer.parseInt(number);
                Shape shape = new Shape();
                shape.square(size);
            }

            if(cmd.hasOption("u")) {
                System.out.println("\u272A");
            }

            if(cmd.hasOption("w")) {
              if ("true" == cmd.getOptionValue("w")){
                Fenetre w = new Fenetre();
              }
            }else{
              Console console = System.console();
              if (console != null) {

              } else {
                  Fenetre f = new Fenetre();
              }
            }
        } catch (Exception e) {

        }

        System.out.println(implode("~", new String[] { "ab", " ", "abs" }));

      }

    /**
    *  System.out.println(implode(", ", new String[] { "ab", " ", "abs" }));
    */
    public static String implode(String separator, String... data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
          sb.append(data[i]);
          if (i < data.length - 1){
            sb.append(separator);
          }

        }
        return sb.toString();
    }
}
