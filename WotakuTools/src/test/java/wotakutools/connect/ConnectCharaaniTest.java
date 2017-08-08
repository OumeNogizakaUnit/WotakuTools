package wotakutools.connect;

import org.junit.Test;
import static org.junit.Assert.*;

import org.jsoup.nodes.*;

import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;
import wotakutools.connect.SecretValue;

public class ConnectCharaaniTest {
    @Test public void testInstance(){
        Connect con = new ConnectCharaani();
        try{
        int sCode = con.login(SecretValue.Charaani.USER,SecretValue.Charaani.PASS);
        assertEquals(sCode, 200);

        }catch(java.io.IOException e){
        System.out.println(e.getMessage());
        }
    }
}
