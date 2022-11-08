import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser
{
    static String nums[] = {"1","2","3","4","5","6","7","8","9","0"};

    public static void parse(String[] data)
    {
        //System.out.println(Arrays.toString(data));
        List<String> Final = new ArrayList<String>();

        for (int i = 0; i < data.length; i++)
        {
            String current = data[i];
            int point = 0;
            String temp;

            if(current.equals("END"))
            {

                i++;
            }


        }
    }
}
