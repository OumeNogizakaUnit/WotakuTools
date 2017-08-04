package sample;


import java.io.IOException;

import java.util.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

class ConnectFortune{
    private static String ID = "****";
    private static String PW = "****";

    private static String BASEURI = "https://fortunemusic.jp/";
    private static String LOGINURI = BASEURI + "default/login/";
    private static String MYPAGEURI = BASEURI + "mypage/";

    public static void main(String[] args){
        try{
        // ログイン処理
        // Cookieの取得
        Map <String, String> cookies = Jsoup.connect(ConnectFortune.LOGINURI)
            .method(Method.GET)
            .execute()
            .cookies();

        // 情報のPOST
        Connection con = Jsoup.connect(ConnectFortune.LOGINURI)
            .data("login_id", ConnectFortune.ID)
            .data("login_pw", ConnectFortune.PW)
            .data("submit", "ログイン")
            .cookies(cookies)
            .method(Method.POST);
        Connection.Response response = con.execute();
        cookies = response.cookies();

        // mypageのGET
        Document doc = Jsoup.connect(ConnectFortune.MYPAGEURI)
            .cookies(cookies)
            .get();
        System.out.println(doc.html());

        }catch(IOException e) {
        System.out.println(e);
        }
    }

}
