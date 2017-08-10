package wotakutools;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

import wotakutools.connect.ConnectFortune;
import wotakutools.connect.ConnectCharaani;
import wotakutools.connect.Connect;
import wotakutools.SecretValue;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class Tmpmain{
    public static void main(String[] args){
        System.out.println("tmp main");
        Connect con;
        Document doc;

        con = new ConnectCharaani();
        try{
        con.login(SecretValue.Charaani.USER,SecretValue.Charaani.PASS);
        doc = con.connect(ConnectCharaani.BASEURI);
        // System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }

        con = new ConnectFortune();
        try{
        con.login(SecretValue.Fortune.USER,SecretValue.Fortune.PASS);
        doc = con.connect(ConnectFortune.MYPAGEURI);
        //System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
}
