package wotakutools;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

import wotakutools.backend.*;
import wotakutools.SecretValue;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class Tmpmain{
    public static void main(String[] args){
        System.out.println("tmp main");
        Backend con;
        Document doc;

        con = new Charaani();
        try{
        con.login(SecretValue.Charaani.USER,SecretValue.Charaani.PASS);
        doc = con.connect(Charaani.BASEURI);
        //System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }

        con = new Fortune();
        try{
        con.login(SecretValue.Fortune.USER,SecretValue.Fortune.PASS);
        doc = con.connect(Fortune.MYPAGEURI);
        //System.out.println(doc);
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
}
