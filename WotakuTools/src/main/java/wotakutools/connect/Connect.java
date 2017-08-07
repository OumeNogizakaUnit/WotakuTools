package wotakutools.connect;

import org.jsoup.nodes.Document;

/**
 * 各サービスに接続するクラスの抽象クラス
 * @author shun kawai
 */
public abstract class Connect{
    /**
     * 各サービスにログイン処理を行う
     * @author shun kawai
     * @param username ユーザー名もしくはユーザーID
     * @param password パスワード
     * @return ログイン処理に成功したら0 失敗したら1
     */
    abstract public int login(String username, String password);
    /**
     * 各サービスへの接続を行い、ページ情報を取得する
     * @author shun kawai
     * @param URI 接続を試みるURI
     * @return ページ情報
     */
    abstract public org.jsoup.nodes.Document connect(String URI);
}

