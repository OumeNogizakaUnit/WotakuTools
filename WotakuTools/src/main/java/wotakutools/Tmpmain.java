package wotakutools;

import wotakutools.connect.ConnectFortune;
import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class Tmpmain{
    public static void main(String[] args){
        System.out.println("tmp main");
        Connect con;
        Document doc;

        con = new ConnectCharaani();
        try{
        con.login("hoge", "hoge");
        doc = con.connect(ConnectCharaani.HISTORYURI);
        //System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }

        con = new ConnectFortune();
        try{
        con.login("hoge", "hoge");
        doc = con.connect(ConnectFortune.MYPAGEURI);
        //System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
}
