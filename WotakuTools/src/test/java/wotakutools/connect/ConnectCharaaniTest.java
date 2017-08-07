package wotakutools.connect;

import org.junit.Test;
import static org.junit.Assert.*;

import org.jsoup.nodes.*;

import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;

public class ConnectCharaaniTest {
    @Test public void testInstance(){
        Connect con = new ConnectCharaani();
        assertEquals(con.login("hoge","hoge"), 0);
    }
}
