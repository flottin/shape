package in.karatube;
import org.apache.commons.cli.*;
import redis.clients.jedis.*;

/**
 * making shape
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //Fenetre f = new Fenetre();
        Options options = new Options();
        options.addOption("b", "bars", true, "display horizontal bars : the parameter is a number of bars requested");
        options.addOption("c", "color", true, "color");
        options.addOption("m", "msg", true, "colorized msg");
        options.addOption("d", "dry-run", true, "make a dry-run");
        options.addOption("s", "size", true, "shape size");
        options.addOption("f", "figure", true, "shape ");
        options.addOption("u", "utf8", true, "utf8");


        String header = "\nGenerate many shapes!\n\n";
        String footer = "\nPlease report issues at https://github.com/flottin/shape/issues";

        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar shape.jar", header, options, footer, true);

        CommandLineParser parser = new DefaultParser();
	    try {
            CommandLine cmd = parser.parse( options, args);

            if(cmd.hasOption("b")) {
                String number = cmd.getOptionValue("b");
                int size = Integer.parseInt(number);
                Shape shape = new Shape();
                shape.bars(size);
            }

            if(cmd.hasOption("d")) {
                System.out.println(cmd.getOptionValue("d"));
            }
            if(cmd.hasOption("f")) {
                String name = cmd.getOptionValue("f");

                Shape shape = new Shape();
                shape.shape(name);
            }
            if(cmd.hasOption("s")) {
                String number = cmd.getOptionValue("s");
                int size = Integer.parseInt(number);
                Shape shape = new Shape();
                shape.square(size);
            }

            if(cmd.hasOption("c") && cmd.hasOption("m")) {
                ConsoleColors.display(cmd.getOptionValue("m"), cmd.getOptionValue("c"));
            }
            if(cmd.hasOption("u")) {
                System.out.println("\u272A");
            }
        } catch (Exception e) {

        }


    }

    /**
    // System.out.println(implode(", ", new String[] { "ab", " ", "abs" }));
    */
    public static String implode(String separator, String... data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length - 1; i++) {
        //data.length - 1 => to not add separator at the end
            if (!data[i].matches(" *")) {//empty string are ""; " "; "  "; and so on
                sb.append(data[i]);
                sb.append(separator);
            }
        }
        sb.append(data[data.length - 1].trim());
        return sb.toString();
    }

    public static void shape(int size){

    }

    public static void cache(){
        Cache cache = new Cache();
    	System.out.println("notexists : " + cache.get("notexists"));
    	cache.set("ShapeControl", "a new one");
    	System.out.println(cache.get("ShapeControl"));
    }

}
