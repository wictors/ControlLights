package program;
import parser.ExpressionParser;
import program.model.Program;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        ExpressionParser ep = new ExpressionParser();
        try {
            Program program = ep.parse(new FileReader("test.txt"));
            program.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
