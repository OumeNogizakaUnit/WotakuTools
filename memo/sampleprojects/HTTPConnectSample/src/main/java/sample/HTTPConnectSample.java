package sample;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.*;

class HTTPConnectSample{
    public static void main(String[] args){
        try{
        Document document = Jsoup.connect("http://www.google.co.jp").get();
        System.out.println(document.html());
        }catch(IOException e) {
        System.out.println(e);
        }
    }
}
