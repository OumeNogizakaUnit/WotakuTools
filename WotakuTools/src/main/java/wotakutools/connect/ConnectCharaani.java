package wotakutools.connect;
/**
 * 某兄さんへアクセスするためのクラス
 * @author shun kawai
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

    public static final String BASEURI = "https://akb48.chara-ani.com/";
    public static final String LOGINURI = BASEURI + "login.aspx";
    public static final String HISTORYURI = BASEURI + "akb_history.aspx";
    public static final String PURCHASEURI = BASEURI + "purchase_history.aspx";

    private Map <String, String> cookies;

    @Override
    public int login(String username, String password)
        throws java.io.IOException{
        // 必要な情報の取得
        Connection.Response preResponse = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .method(Method.GET).execute();

        this.cookies = preResponse.cookies();
        Map <String, String> hiddenData = this.findHiddenData(preResponse.parse());
        // ログイン処理
        Connection con = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("Accept-Language", "ja")
            .data(hiddenData)
            .data("ScriptManager1", "ScriptManager1%7CbtnLogin")
            .data("txID", username)
            .data("txPASSWORD", password)
            .data("btnLogin.x", "173")
            .data("btnLogin.y", "30")
            .method(Method.POST);
        Connection.Response response = con.execute();
        this.cookies = response.cookies();

        return response.statusCode();
		}
    @Override
    public Document connect(String URI) 
        throws java.io.IOException{
        return Jsoup.connect(URI)
            .cookies(this.cookies)
            .get();
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
