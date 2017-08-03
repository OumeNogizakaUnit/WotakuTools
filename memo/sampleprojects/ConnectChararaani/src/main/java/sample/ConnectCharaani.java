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
        Map <String, String> cookies = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("Accept-Encoding", "gzip,deflate")
            .header("Connection", "keep-alive")
            .header("Host", "akb48.chara-ani.com")
            .header("Upgrade-Insecure-Requests", "1")
            .header("Refer", ConnectCharaani.BASEURI)
            .method(Method.GET)
            .execute()
            .cookies();

        System.out.println(cookies);
        System.out.println(ConnectCharaani.BASEURI);
        Connection con = Jsoup.connect(ConnectCharaani.LOGINURI)
            .header("Accept", "*/*")
            .header("X-MicrosoftAjax", "Delta=true")
            .header("Connection", "keep-alive")
            .header("Refer", ConnectCharaani.LOGINURI)
            .header("Accept-Encoding", "gzip, deflate, br")
            .header("Content-Type", "application/x-www-form-urlencode")
            .data("ScriptManager1", "ScriptManager1|btnLogin")
            .data("txID", )
            .data("txPASSWORD",)
            .data("btnLogin.x", "-612")
            .data("btnLogin.y", "-548")
            .cookies(cookies)
            .method(Method.POST);
        System.out.println("\n***Request headers***");
        System.out.println(con.request().headers());
        System.out.println(con.request().cookies());

        Connection.Response response = con.execute();
        System.out.println("\n***Response headers***");
        System.out.println(response.headers());
        String sessionId = response.cookies().get("ASP.NET_SessionId");
        // System.out.println("\n*********\n\n");
        System.out.println(response.body());
        System.out.println(sessionId);
        // cookies = response.cookies();

        // Connection history = Jsoup.connect(ConnectCharaani.BASEURI)
        //     .header("Accept-Encoding", "gzip,deflate")
        //     .header("Connection", "keep-alive")
        //     .header("Host", "akb48.chara-ani.com")
        //     .header("Upgrade-Insecure-Requests", "1")
        //     .header("Refer", ConnectCharaani.LOGINURI)
        //     .cookies(cookies)
        //     .method(Method.GET);

        // System.out.println("\n***Request headers***");
        // System.out.println(history.request().headers());
        // System.out.println(history.request().cookies());

        // Connection.Response resHistory = history.execute();
        // System.out.println("\n***Response headers***");
        // System.out.println(resHistory.headers());
        // System.out.println(resHistory.cookies().get("ASP.NET_SessionId"));

        // System.out.println("\n*********\n\n");
        // System.out.println(resHistory.body());

        }catch(IOException e) {
        System.out.println(e);
        }
    }

}
