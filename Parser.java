import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parser
{
    static String[] nums = {"1","2","3","4","5","6","7","8","9","0"};
    static String[] symbols = {"+", "-", "*", "/", "="};

    public static void parse(String[] data)
    {
        String mdta = String.join("", data);
        //System.out.println(mdta);
        List<String> temp = new ArrayList<String>();
        int last = 0;

        for(int i = 0; i < mdta.length(); i++)
        {

            String curr = Character.toString(mdta.charAt(i));

            if(curr.equals("|"))
            {
                try
                {
                    String ling = mdta.substring(last, i);
                    ling = ling.replaceAll("\\|", "");
                    ling = ling.replaceAll("\\+", "");
                    ling = ling.replaceAll("-", "");
                    ling = ling.replaceAll("\\*", "");
                    ling = ling.replaceAll("/", "");
                    ling = ling.replaceAll("=", "");

                    temp.add(ling);
                    last = i;
                    temp.removeIf(item -> item == null || "".equals(item));
                    System.out.println(temp);
                }
                catch(Exception e)
                {
                    //System.out.println(e);
                    break;
                }
            }
            else if(Arrays.asList(symbols).contains(curr))
            {
                temp.add(curr);
                //System.out.println(temp);
            }
            else
            {
                //System.out.println(temp);
            }
        }


    }

}
