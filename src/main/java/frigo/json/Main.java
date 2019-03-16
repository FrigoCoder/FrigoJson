
package frigo.json;

import lombok.SneakyThrows;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.InputStream;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("example.json")) {
            CharStream chars = CharStreams.fromStream(stream);
            JsonLexer lexer = new JsonLexer(chars);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JsonParser parser = new JsonParser(tokens);
            ParseTree tree = parser.json();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new JsonWalker(), tree);
        }
    }

}
