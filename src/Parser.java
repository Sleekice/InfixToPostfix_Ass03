import java.io.*;

public class Parser {
    static int lookahead;

    public Parser() throws IOException {
        lookahead = System.in.read();
    }

    void expr() throws IOException {
        Noname();

        while (true) {
            if (lookahead == '+') {
                match('+');
                Noname();
                System.out.write('+');
            } else if (lookahead == '-') {
                match('-');
                Noname();
                System.out.write('-');
            } else {
                return;
            }
        }
    }
    void Noname() throws IOException {
        term();

        while (true) {
            if (lookahead == '*') {
                match('*');
                term();
                System.out.write('*');}
            else if (lookahead == '/') {
                match('/');
                term();
                System.out.write('/');
            } else if (lookahead == '%') {
                match('%');
                term();
                System.out.write('%');
            } else {
                return;
            }
        }
    }
    void term() throws IOException {
        if (Character.isDigit((char) lookahead)) {
            System.out.write((char) lookahead);
            match(lookahead);
        }
        else if (Character.isLetter((char) lookahead)) {
            System.out.write((char) lookahead);
            match(lookahead);}
        else if (lookahead == '(') {
            match('(');
            expr();
            match(')');
        }
        else {
            throw new Error("syntax error");
        }
    }

    void match(int t) throws IOException {
        if (lookahead == t) {
            lookahead = System.in.read();
        } else {
            throw new Error("syntax error");

        }
    }
}
