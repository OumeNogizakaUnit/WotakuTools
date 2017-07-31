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
        Connection con = Jsoup.connect(ConnectCharaani.LOGINURI)
            .data("ScriptManager1", "ScriptManager1|btnLogin")
            .data("txID", "userID")
            .data("txPASSWORD", "pass")
            .data("btnLogin.x", "-612")
            .data("btnLogin.y", "-548")
            .header("X-MicrosoftAjax", "Delta=true")
            .header("Host", "akb48.chara-ani.com")
            .header("Referer", "https://akb48.chara-ani.com/login.aspx")
            .header("Accept-Encoding", "gzip, deflate, br")
            .userAgent("Mozilla")
            .method(Method.POST);
        System.out.println("\n***Request headers***");
        System.out.println(con.request().headers());

        Connection.Response response = con.execute();
        System.out.println("\n***Response headers***");
        System.out.println(response.headers());
        String sessionId = response.cookies().get("ASP.NET_SessionId");
        System.out.println(sessionId);

        System.out.println(ConnectCharaani.HISTORYURI);
        Connection history = Jsoup.connect(ConnectCharaani.HISTORYURI)
            .header("Referer", "https://akb48.chara-ani.com/top.aspx")
            .header("Host", "akb48.chara-ani.com")
            .header("Accept-Encoding", "gzip, deflate, br")
            .header("Cookie", "ASP.NET_SessionId=" + sessionId)
            .cookie("ASP.NET_SessionId", sessionId)
            .method(Method.GET);

        System.out.println("\n***Request headers***");
        System.out.println(history.request().headers());
        System.out.println(history.request().cookies());

        Connection.Response resHistory = history.execute();
        System.out.println("\n***Response headers***");
        System.out.println(resHistory.headers());
        System.out.println(resHistory.cookies().get("ASP.NET_SessionId"));

        System.out.println("\n*********\n\n");
        System.out.println(resHistory.body());

        }catch(IOException e) {
        System.out.println(e);
        }
    }

}
