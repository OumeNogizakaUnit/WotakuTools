package wotakutools.backend;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

/**
 * 各バックエンドクラスの抽象クラス
 * @author shun kawai
 */
public abstract class Backend{
    /**
     * 各サービスにログイン処理を行う
     * @author shun kawai
     * @param username ユーザー名もしくはユーザーID
     * @param password パスワード
     * @return ステータスコード
     * @throws java.io.IOException 接続失敗
     * @throws wotakutools.backend.LoginFaild ログイン失敗
     */
    abstract public int login(String username, String password)
        throws java.io.IOException, wotakutools.backend.LoginFaild;
    /**
     * 各サービスへの接続を行い、ページ情報を取得する
     * @author shun kawai
     * @param URI 接続を試みるURI
     * @return ページ情報
     * @throws java.io.IOException 接続失敗
     */
    abstract public org.jsoup.nodes.Document connect(String URI)
        throws java.io.IOException;
    /**
     * 必要なページをスクレイピングし、情報を取得する
     * ログインが必要なページからスクレイピングするので、
     * 事前にログイン処理を行っておく必要がある。
     * ログイン処理が行われていなかった場合、例外を投げる。
     * @author shun kawai
     * @return BackendDataObjectのリスト
     * @throws java.io.IOException 接続失敗
     * @throws wotakutools.backend.LoginFaild ログイン失敗
     */
    abstract public java.util.ArrayList<wotakutools.backend.BackendDataObject>
        scrap()
        throws java.io.IOException, wotakutools.backend.LoginFaild;
}
