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
        System.out.println( "Shape Application !" );
        Options options = new Options();
        options.addOption("c", "color", true, "color");
        options.addOption("m", "msg", true, "colorized msg");
        options.addOption("d", "dry-run", true, "make a dry-run");
        options.addOption("s", "size", true, "shape size");
        options.addOption("u", "utf8", true, "utf8");


        CommandLineParser parser = new DefaultParser();
	    try {
            CommandLine cmd = parser.parse( options, args);
            if(cmd.hasOption("d")) {
                System.out.println(cmd.getOptionValue("d"));
            }
            if(cmd.hasOption("s")) {
                String number = cmd.getOptionValue("s");
                int size = Integer.parseInt(number);
                shape(size);
            }
            if(cmd.hasOption("c") && cmd.hasOption("m")) {
                ConsoleColors.display(cmd.getOptionValue("m"), cmd.getOptionValue("c"));
            }
            if(cmd.hasOption("u")) {
                System.out.println("\u272A");
            }
        } catch (Exception e) {

        }

// System.out.println(implode(", ", new String[] { "ab", " ", "abs" }));
    }

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
        Shape shape = new Shape();
        shape.square(size);
    }

    public static void cache(){
        Cache cache = new Cache();
    	System.out.println("notexists : " + cache.get("notexists"));
    	cache.set("ShapeControl", "a new one");
    	System.out.println(cache.get("ShapeControl"));
    }

}
