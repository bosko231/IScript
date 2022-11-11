import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer
{
    //tokens
    static String nums[] = {"1","2","3","4","5","6","7","8","9","0"};
    static String symbols[] = {"+", "-", "*", "/", "="};
    static String chars[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","w","y","z"};

    static List<String> Final = new ArrayList<String>();

    //main
    public static void lexer(String data)
    {
        check_for_int(data, 0);
    }

    public static void check_for_int(String data, int current_char)
    {
        try
        {
            if(Arrays.asList(nums).contains(String.valueOf(data.charAt(current_char))))
            {
                //System.out.println("INT: "+data.charAt(current_char));
                Final.add(String.valueOf(data.charAt(current_char)));
                current_char += 1;
                check_for_int(data, current_char);
            }
            else if(String.valueOf(data.charAt(current_char)).equals(" "))
            {
                //System.out.println("END");
                current_char += 1;
                check_for_int(data, current_char);
            }
            else
            {
                //System.out.println("END");
                Final.add("|");

                if(current_char == data.length())
                {
                    //System.out.println("END OF LINE");
                    Final.add("ENDOFLINE");
                    System.out.println(Final);
                }
                else
                {
                    check_for_sym(data, current_char);
                }
            }
        }
        catch(Exception e)
        {
            //System.out.println("END");
            Final.add("|");
        }
        String[] array = new String[Final.size()];
        Final.toArray(array);
        Parser.parse(array);
    }
    public static void check_for_sym(String data, int current_char)
    {
        if(Arrays.asList(symbols).contains(String.valueOf(data.charAt(current_char))))
        {
            //System.out.println("SYM: "+data.charAt(current_char));
            Final.add(String.valueOf(data.charAt(current_char)));
            //Final.add("END");
            //System.out.println("END");
            current_char += 1;
            check_for_int(data, current_char);
        }
        else
        {
            if(current_char == data.length())
            {
                //System.out.println("END OF LINE");
                Final.add("ENDOFLINE");
                System.out.println(Final);
            }
            else
            {
            check_for_str(data, current_char);
            }
        }
        String[] array = new String[Final.size()];
        Final.toArray(array);
        Parser.parse(array);
    }
    public static void check_for_str(String data, int current_char)
    {
        if(Arrays.asList(chars).contains(String.valueOf(data.charAt(current_char))))
        {
            //System.out.println("STR: "+data.charAt(current_char));
            Final.add(String.valueOf(data.charAt(current_char)));
            current_char += 1;
            check_for_str(data, current_char);
        }
        else if(String.valueOf(data.charAt(current_char)).equals(" "))
        {
            //System.out.println("END");
            Final.add("|");
            current_char += 1;
            check_for_str(data, current_char);
        }
        else
        {
            //System.out.println("END");
            //check_for_sym(data, current_char);
            if(current_char == data.length())
            {
                //System.out.println("END OF LINE");
                Final.add("ENDOFLINE");
                System.out.println(Final);
            }
            else
            {
                //System.out.println("REROLLING");
                check_for_int(data, current_char);
            }
        }

        String[] array = new String[Final.size()];
        Final.toArray(array);
        Parser.parse(array);
    }
}