package calypsox.buggy.trade.dup;

import java.io.InputStream;

import calypsox.buggy.uti.ResourceReader;

public class kk {

    public static void main(final String[] args) {
	final InputStream result = new ResourceReader().getResourceAsStream(new InsertFixture(), "help.png");
	System.out.println(result);
    }

}
