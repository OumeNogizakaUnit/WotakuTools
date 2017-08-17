package wotakutools.backend;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

import wotakutools.backend.Backend;
import wotakutools.backend.BackendDataObject;

import java.util.*;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

/**
 * 某兄さんへアクセスするためのクラス
 * @author shun kawai
 */
public class Charaani
    extends wotakutools.backend.Backend {

    /** トップページのURL */
    public static final String BASEURI = "https://akb48.chara-ani.com/";
    /** ログインページのURL */
    public static final String LOGINURI = BASEURI + "login.aspx";
    /** ログアウトページのURL */
    public static final String LOGOUTURI = BASEURI + "logout.aspx";
    /** 申し込み履歴ページのURL */
    public static final String HISTORYURI = BASEURI + "akb_history.aspx";
    /** 購入履歴ページのURL */
    public static final String PURCHASEURI = BASEURI + "purchase_history.aspx";

    private Map <String, String> cookies;

    @Override
    public int login(String username, String password)
        throws java.io.IOException, wotakutools.backend.LoginFaild{
        System.out.println(username + ", " + password);
        // 必要な情報の取得
        Connection.Response preResponse = Jsoup.connect(Charaani.LOGINURI)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .method(Method.GET).execute();

        this.cookies = preResponse.cookies();
        Map <String, String> hiddenData = this.findHiddenData(preResponse.parse());
        // ログイン処理
        Connection con = Jsoup.connect(Charaani.LOGINURI)
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

        if(this.loginCheck() == false)
            throw new LoginFaild("Bad username or password");

        return response.statusCode();
		}
    @Override
    public Document connect(String URI) 
        throws java.io.IOException{
        return Jsoup.connect(URI)
            .cookies(this.cookies)
            .get();
    }

    @Override
    public ArrayList<BackendDataObject> scrap()
        throws java.io.IOException, wotakutools.backend.LoginFaild{
        if(this.loginCheck() == false)
            throw new LoginFaild("Connect faild login page. Please call login");

        Document doc = this.connect(Charaani.PURCHASEURI);
        Elements tables = doc.getElementsByClass("purchase_table");
        for(Element table : tables){
            System.out.println(table + "\n\n");
        }
        return new ArrayList<BackendDataObject>();
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

    private boolean loginCheck() 
        throws java.io.IOException{
        Document doc = this.connect(Charaani.BASEURI);
        Elements navis = doc.getElementsByAttributeValue("id", "nav_l_inner_r");
        Element navi = navis.get(0);
        Elements as = navi.getElementsByAttributeValue("href", Charaani.LOGOUTURI);
        as = navi.getElementsByTag("a");
        for(Element a : as)
            if(a.text().equals("ログアウト"))
                return true;

        return false;
    }
}
