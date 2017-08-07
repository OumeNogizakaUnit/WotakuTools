package wotakutools.connect;
/**
 * 某兄さんへアクセスするためのクラス
 * @author
 */

import wotakutools.connect.Connect;
import wotakutools.connect.ConnectException.*;

import java.util.*;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

public class ConnectCharaani
    extends wotakutools.connect.Connect {

    static final String BASEURI = "https://akb48.chara-ani.cmo/";
    static final String LOGINURI = BASEURI + "login.aspx";

    @Override
    public void login(String username, String password)
        throws java.io.IOException{
        throw new LoginFaild("Login fail");
       
    }

    @Override
    public Document connect(String URI) 
        throws java.io.IOException{
        return new Document("");
    }
    private Map<String, String> findHiddenData(Document doc){
        Map<String, String> foundItems = new HashMap<String, String>();

        Elements input = doc.getElementsByTag("input");
        for(Element element : input) {
            Elements hidden = element.getElementsByAttributeValue("type", "hidden");
            for(Element e : hidden){
                String name = e.attr("name");
                String val = e.attr("value");
                foundItems.put(name, val);
            }
        }
        return foundItems;
    }
}
