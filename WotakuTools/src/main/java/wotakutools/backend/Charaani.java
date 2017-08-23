package wotakutools.backend;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

import wotakutools.backend.Backend;
import wotakutools.backend.BackendDataObject;

import java.util.*;
import java.util.regex.*;

import java.time.*;
import java.time.format.*;

import java.io.IOException;

import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.nodes.*;
import org.jsoup.Connection.*;

/**
 * 某兄さんへアクセスするためのクラス
 * @author shun kawai
 */
public class Charaani
    extends wotakutools.backend.Backend {

    /** トップページのURL */
    public static final String BASEURI = "https://akb48.chara-ani.com/";
    /** ログインページのURL */
    public static final String LOGINURI = BASEURI + "login.aspx";
    /** ログアウトページのURL */
    public static final String LOGOUTURI = BASEURI + "logout.aspx";
    /** 申し込み履歴ページのURL */
    public static final String HISTORYURI = BASEURI + "akb_history.aspx";
    /** 購入履歴ページのURL */
    public static final String PURCHASEURI = BASEURI + "purchase_history.aspx";

    private Map <String, String> cookies;

    @Override
    public int login(String username, String password)
        throws java.io.IOException, wotakutools.backend.LoginFaild{
        System.out.println(username + ", " + password);
        // 必要な情報の取得
        Connection.Response preResponse = Jsoup.connect(Charaani.LOGINURI)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .method(Method.GET).execute();

        this.cookies = preResponse.cookies();
        Map <String, String> hiddenData = this.findHiddenData(preResponse.parse());
        // ログイン処理
        Connection con = Jsoup.connect(Charaani.LOGINURI)
            .header("Accept-Language", "ja")
            .data(hiddenData)
            .data("ScriptManager1", "ScriptManager1%7CbtnLogin")
            .data("txID", username)
            .data("txPASSWORD", password)
            .data("btnLogin.x", "173")
            .data("btnLogin.y", "30")
            .method(Method.POST);
        Connection.Response response = con.execute();
        this.cookies = response.cookies();

        if(this.loginCheck() == false)
            throw new LoginFaild("Bad username or password");

        return response.statusCode();
		}
    @Override
    public Document connect(String URI) 
        throws java.io.IOException{
        return Jsoup.connect(URI)
            .cookies(this.cookies)
            .get();
    }

    @Override
    public ArrayList<BackendDataObject> scrap()
        throws java.io.IOException, wotakutools.backend.LoginFaild{
        if(this.loginCheck() == false)
            throw new LoginFaild("Connect faild login page. Please call login");

        Document doc = this.connect(Charaani.PURCHASEURI);

        ArrayList<BackendDataObject> dataList = new ArrayList<BackendDataObject>();

        Elements footer = doc.getElementsByClass("purchase_table_footer_l_wait");
        Elements tables = doc.getElementsByClass("purchase_table");
        for(int i = 0; i < tables.size(); i++){
            Element table = tables.get(i);
            Element status = footer.get(i);
            System.out.println(status.text().equals("出荷待ち") || status.text().equals("出荷済"));
            /* 支払い忘れのキャンセルに対応 */
            if((status.text().equals("出荷待ち") || status.text().equals("出荷済")) == false)
                continue;
            Elements trs = table.getElementsByTag("tr");
            /*
             * 0. 申し込み日時 オーダーID
             * 1. 申込者名
             * 2. お届け先住所
             * 3. ヘッダー
             */

            /*申し込み日時から握手会開催日時(主に年)を求める*/
            String  strOrderDate = trs.get(0).getElementsByTag("td").get(1).text();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime orderDate = LocalDateTime.parse(strOrderDate, f);
            System.out.println(orderDate);
            
            Element user = trs.get(1).getElementsByTag("td").get(0);
            System.out.println(user.text());
            for(int j = 4; j < trs.size(); j++){
                Element tr = trs.get(j);
                BackendDataObject data = this.convertEntryToBackendObj(tr, orderDate);
                dataList.add(data);
            }
        }
        return dataList;
    }

    private BackendDataObject convertEntryToBackendObj(Element entry, LocalDateTime orderDate){
        BackendDataObject data = new BackendDataObject();
        data.orderDate = orderDate;
        /**
         * 想定するエントリーのデータ
         * <tr> 
         *   <td colspan="4" class="text">11/18(土)横浜 中井りか 第5部【ご来場認定カード】 AKB48 49thSg「タイトル未定」【劇場盤】</td> 
         *   <td class="num">2個</td> 
         * </tr>
         *   
         */
        Element num = entry.getElementsByClass("num").get(0);
        Element text = entry.getElementsByClass("text").get(0);
        data.num = Integer.valueOf(num.text().substring(0, num.text().length()-1));
        System.out.println(entry.text());
        System.out.println(data.num);

        String str = text.text();
        String[] items = str.split(" ", 0);

        Matcher m = this.patternMatchRegex(items[0], "(\\d+).(\\d+)(...)(.+)");
        if(m.find()){
            int month = Integer.parseInt(m.group(1));
            int day = Integer.parseInt(m.group(2));
            data.date = data.getLocalDateTime(month, day);
        }
        data.place = m.group(4);

        return data;
    }

    private Matcher patternMatchRegex(String str, String regex){
        Pattern p = Pattern.compile(regex);
        return p.matcher(str);
    }

    private Map<String, String> findHiddenData(Document doc){
        Map<String, String> foundItems = new HashMap<String, String>();

        Elements input = doc.getElementsByTag("input");
        for(Element element : input) {
            Elements hidden = element.getElementsByAttributeValue("type", "hidden");
            for(Element e : hidden){
                String name = e.attr("name");
                String val = e.attr("value");
                foundItems.put(name, val);
            }
        }
        return foundItems;
    }

    private boolean loginCheck() 
        throws java.io.IOException{
        Document doc = this.connect(Charaani.BASEURI);
        Elements navis = doc.getElementsByAttributeValue("id", "nav_l_inner_r");
        Element navi = navis.get(0);
        Elements as = navi.getElementsByAttributeValue("href", Charaani.LOGOUTURI);
        as = navi.getElementsByTag("a");
        for(Element a : as)
            if(a.text().equals("ログアウト"))
                return true;

        return false;
    }
}
