package sample;


import java.io.IOException;

import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

class ConnectCharaani{
    private static String BASEURI = "https://akb48.chara-ani.com/";
    private static String LOGINURI = BASEURI + "login.aspx";
    private static String HISTORYURI = BASEURI + "akb_history.aspx";

    public static void main(String[] args){
        try{
        // ログイン処理
        Map <String, String> cookies = Jsoup.connect(ConnectCharaani.BASEURI)
            .method(Method.GET)
            .execute()
            .cookies();

        System.out.println(cookies);
        System.out.println(ConnectCharaani.BASEURI);
        Connection.Response response = Jsoup.connect(ConnectCharaani.LOGINURI)
            .data("txID", "20390084")
            .data("txPASSWORD", "kawaishun")
            .method(Method.POST)
            .execute();
        System.out.println(response.headers());
        System.out.println(response.cookies());

        System.out.println(ConnectCharaani.HISTORYURI);
        Document doc = Jsoup.connect(ConnectCharaani.HISTORYURI)
            .cookies(response.cookies())
            .get();

        System.out.println(doc.html());

        }catch(IOException e) {
        System.out.println(e);
        }
    }

}
