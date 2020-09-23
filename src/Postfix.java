import java.io.IOException;

public class Postfix {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter Characters: ");
        Parser parse = new Parser();
        parse.expr();
        System.out.println("");

    }
}
