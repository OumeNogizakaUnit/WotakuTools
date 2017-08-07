package wotakutools.connect;

import wotakutools.connect.Connect;

import org.jsoup.*;
import org.jsoup.nodes.*;

public class ConnectCharaani extends Connect {

    @Override
    public int login(String username, String password){
        return 0;
    }

    @Override
    public Document connect(String URI) {
        return new Document("");
    }
}
