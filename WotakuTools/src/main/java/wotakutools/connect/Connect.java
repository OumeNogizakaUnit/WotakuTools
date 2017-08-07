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
     * @return ステータスコード
     * @throws java.io.IOException 接続失敗
     * @throws wotakutools.connect.LoginFaild
     */
    abstract public int login(String username, String password)
        throws java.io.IOException;
    /**
     * 各サービスへの接続を行い、ページ情報を取得する
     * @author shun kawai
     * @param URI 接続を試みるURI
     * @return ページ情報
     * @throws java.io.IOException 接続失敗
     */
    abstract public org.jsoup.nodes.Document connect(String URI)
        throws java.io.IOException;
}

