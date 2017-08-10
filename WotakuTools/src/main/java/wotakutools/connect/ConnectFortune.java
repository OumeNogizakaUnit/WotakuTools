package wotakutools.connect;
/**
 * 某tuneへアクセスするためのクラス
 * @author shun kawai
 */

import wotakutools.connect.Connect;
import wotakutools.connect.ConnectException.*;

import java.io.IOException;

import java.util.*;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

public class ConnectFortune
    extends wotakutools.connect.Connect {

    public static final String BASEURI = "https://fortunemusic.jp/";
    public static final String LOGINURI = BASEURI + "default/login/";
    public static final String MYPAGEURI = BASEURI + "mypage/";

    private Map <String, String> cookies;

    @Override
    public int login(String username, String password)
        throws java.io.IOException,
               wotakutools.connect.ConnectException{
        // ログイン処理
        Connection con = Jsoup.connect(ConnectFortune.LOGINURI)
            .data("login_id", username)
            .data("login_pw", password)
            .data("submit", "ログイン")
            .method(Method.POST);
        Connection.Response response = con.execute();
        this.cookies = response.cookies();
        if(this.loginCheck() == false)
            throw new LoginFaild("Bad username or password");
        return response.statusCode();
    }

    @Override
    public Document connect(String URI)
        throws java.io.IOException {
        return Jsoup.connect(URI)
            .cookies(this.cookies)
            .get();
    }

    private boolean loginCheck()
        throws java.io.IOException{
        Document doc = this.connect(ConnectFortune.BASEURI);
        Elements navis = doc.getElementsByAttributeValue("id", "globalNav");
        Element navi = navis.get(0);
        Elements forms = navi.getElementsByTag("form");

        if(forms.size() == 1)
            return true;
        return false;
    }
}
