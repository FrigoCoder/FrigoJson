package frigo.json;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class JsonWalker extends JsonBaseListener {

    @Override
    public void enterJson(JsonParser.JsonContext ctx) {
        System.out.println("enterJson");
    }

    @Override
    public void exitJson(JsonParser.JsonContext ctx) {
        System.out.println("exitJson");
    }

    @Override
    public void enterArray(JsonParser.ArrayContext ctx) {
        System.out.println("enterArray");
    }

    @Override
    public void exitArray(JsonParser.ArrayContext ctx) {
        System.out.println("exitArray");
    }

    @Override
    public void enterObject(JsonParser.ObjectContext ctx) {
        System.out.println("enterObject");
    }

    @Override
    public void exitObject(JsonParser.ObjectContext ctx) {
        System.out.println("exitObject");
    }

    @Override
    public void enterValue(JsonParser.ValueContext ctx) {
        System.out.println("enterValue");
    }

    @Override
    public void exitValue(JsonParser.ValueContext ctx) {
        System.out.println("exitValue");
    }

    @Override
    public void enterPair(JsonParser.PairContext ctx) {
        System.out.println("enterPair");
    }

    @Override
    public void exitPair(JsonParser.PairContext ctx) {
        System.out.println("exitPair");
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        System.out.println("enterEveryRule");
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println("exitEveryRule");
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        System.out.println("visitTerminal");
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        System.out.println("visitErrorNode");
    }

}
