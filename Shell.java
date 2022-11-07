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
            Lexer.lexer(code);


        }
        System.out.println("Exiting...");
    }
}
