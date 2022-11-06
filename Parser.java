import java.util.ArrayList;
import java.util.Arrays;


public class Parser
{
    //TOKENS
    public static String keywords[] =
            {
                    "println"
            };
    public static String symbols[] =
            {
                    "+",
                    "-",
                    "*",
                    "/",
                    "(",
                    ")",
                    ";",
                    "="
            };
    public static String integers[] =
            {
            String.valueOf('0'),
            String.valueOf('1'),
            String.valueOf('2'),
            String.valueOf('3'),
            String.valueOf('4'),
            String.valueOf('5'),
            String.valueOf('6'),
            String.valueOf('7'),
            String.valueOf('8'),
            String.valueOf('9')
            };
    public static String WS[] =
            {
                    " "
            };
    public static String[] alphabet =
    {
            String.valueOf('A'),
            String.valueOf('B'),
            String.valueOf('C'),
            String.valueOf('D'),
            String.valueOf('E'),
            String.valueOf('F'),
            String.valueOf('G'),
            String.valueOf('H'),
            String.valueOf('I'),
            String.valueOf('J'),
            String.valueOf('K'),
            String.valueOf('L'),
            String.valueOf('M'),
            String.valueOf('N'),
            String.valueOf('O'),
            String.valueOf('P'),
            String.valueOf('Q'),
            String.valueOf('R'),
            String.valueOf('S'),
            String.valueOf('T'),
            String.valueOf('U'),
            String.valueOf('V'),
            String.valueOf('W'),
            String.valueOf('X'),
            String.valueOf('Y'),
            String.valueOf('Z'),
            String.valueOf('a'),
            String.valueOf('b'),
            String.valueOf('c'),
            String.valueOf('d'),
            String.valueOf('e'),
            String.valueOf('f'),
            String.valueOf('g'),
            String.valueOf('h'),
            String.valueOf('i'),
            String.valueOf('j'),
            String.valueOf('k'),
            String.valueOf('l'),
            String.valueOf('m'),
            String.valueOf('n'),
            String.valueOf('o'),
            String.valueOf('p'),
            String.valueOf('q'),
            String.valueOf('r'),
            String.valueOf('s'),
            String.valueOf('t'),
            String.valueOf('u'),
            String.valueOf('v'),
            String.valueOf('w'),
            String.valueOf('x'),
            String.valueOf('y'),
            String.valueOf('z')
    };

    //Lexer and Tokenizer

    public static String Tokenizer(String data)
    {
        ArrayList<String> a = new ArrayList<String>();


        for (int i = 0; i < data.length(); i++)
        {
            char current = data.charAt(i);

            if(!String.valueOf(data.charAt(data.length() - 1)).equals(";"))
            {
                System.out.println("Syntax Error: No end of line defined.");
                break;
            }

            if(Arrays.asList(integers).contains(String.valueOf(current)))
            {
                a.add(String.valueOf(current));
            }
            else if(Arrays.asList(symbols).contains(String.valueOf(current)))
            {
                a.add(String.valueOf(current));
            }
            else if(Arrays.asList(WS).contains(String.valueOf(current)))
            {
                a.add(String.valueOf("WHITESPACE"));
            }
            else if(Arrays.asList(alphabet).contains(String.valueOf(current)))
            {
                a.add(String.valueOf(current));
            }

            
        }
        String[] myArray = new String[a.size()];
        a.toArray(myArray);

        return String.valueOf(Lexer(myArray));
    }

    public static ArrayList<String> Lexer(String[] data)
    {
        String tempint;
        String tempstr;
        ArrayList<String> lexed = new ArrayList<String>();

        //Numbers
        for (int i = 0; i < data.length; i++)
        {
            tempint = data[i];

            if(Arrays.asList(integers).contains(String.valueOf(data[i])))
            {
                for (int l = i+1; i < data.length; l++)
                {
                    if(Arrays.asList(integers).contains(String.valueOf(data[l])))
                    {
                        tempint = tempint+String.valueOf(data[l]);
                    }
                    else
                    {
                        System.out.println("LEXER: "+tempint);
                        lexed.add(tempint);
                         i += l;
                        break;
                    }
                }

            }
        }
        //Symbols
        for(int i = 0; i < data.length; i++)
        {
            String current = data[i];

            if(Arrays.asList(symbols).contains(String.valueOf(current)))
            {
                lexed.add(current);
            }
        }
        //Letters
        for(int i = 0; i < data.length; i++)
        {
            tempstr = data[i];
            if(Arrays.asList(alphabet).contains(String.valueOf(data[i])))
            {
                for (int l = i+1; i < data.length; l++)
                {
                    if(Arrays.asList(alphabet).contains(String.valueOf(data[l])))
                    {
                        tempstr = tempstr+String.valueOf(data[l]);
                    }
                    else
                    {
                        System.out.println("LEXER: "+tempstr);
                        lexed.add(tempstr);
                        i += l;
                        break;
                    }
                }
            }
        }


        lexed.toArray();
        return lexed;


    }



}
