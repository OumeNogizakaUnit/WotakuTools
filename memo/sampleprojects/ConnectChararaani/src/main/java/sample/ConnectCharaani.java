package sample;


import java.io.IOException;

import java.util.*;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

public class ConnectCharaani{
    private static String ID = "***";
    private static String PW = "***";

    private static String BASEURI = "https://akb48.chara-ani.com/";
    private static String LOGINURI = BASEURI + "login.aspx";
    private static String HISTORYURI = BASEURI + "akb_history.aspx";

    public static void main(String[] args){
        ConnectCharaani charaani = new ConnectCharaani();
        try{
        // 必要な情報の取得
        Connection.Response preResponse = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .method(Method.GET).execute();

        Map <String, String> cookies = preResponse.cookies();
        Map <String, String> hiddenData = charaani.findHiddenData(preResponse.parse());

        // ログイン処理
        Connection con = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("User-Agent", "@IT java-tips URLConnection")
            .header("Accept-Language", "ja")
            .data(hiddenData)
            .data("ScriptManager1", "ScriptManager1%7CbtnLogin")
            .data("txID", ConnectCharaani.ID)
            .data("txPASSWORD", ConnectCharaani.PW)
            .data("btnLogin.x", "173")
            .data("btnLogin.y", "30")
            .method(Method.POST);
        Connection.Response response = con.execute();
        cookies = response.cookies();

        Document doc = Jsoup.connect(ConnectCharaani.HISTORYURI)
            .cookies(cookies)
            .get();

        System.out.println(doc.html());

        }catch(IOException e) {
        System.out.println(e);
        }
    }

    private Map<String, String> findHiddenData(Document doc) {
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
