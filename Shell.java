import java.util.Scanner;

public class Shell
{
    public static void main(String[] args)
    {
        String code = "notex";

        while(!code.equals("exit"))
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inbascript>>: ");
            code = sc.nextLine();
            System.out.println(Parser.Tokenizer(code));

        }
        System.out.println("Exiting...");
    }
}
