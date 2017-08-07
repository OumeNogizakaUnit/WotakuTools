package wotakutools.connect;

import org.junit.Test;
import static org.junit.Assert.*;

import org.jsoup.nodes.*;

import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;

public class ConnectCharaaniTest {
    @Test public void testInstance(){
        Connect con = new ConnectCharaani();
        try{
        con.login("hoge", "hoge");
        }catch(java.io.IOException e){
        System.out.println(e.getMessage());
        }
    }
}
