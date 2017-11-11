package wotakutools.backend;

import org.junit.Test;
import static org.junit.Assert.*;

import org.jsoup.nodes.*;

import wotakutools.backend.Charaani;
import wotakutools.SecretValue;

public class CharaaniTest {
    private Charaani c;

    @Test public void testInstance(){
        this.c = new Charaani();
        assertTrue(true);
    }
}
