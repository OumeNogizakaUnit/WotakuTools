package wotakutools;

import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class Tmpmain{
    public static void main(String[] args){
        System.out.println("tmp main");
        Connect con = new ConnectCharaani();
        try{
        con.login("hoge", "hoge");
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
}
