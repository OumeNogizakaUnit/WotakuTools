package wotakutools.backend;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

import java.time.LocalDateTime;

/**
 * データをキャッシュする際の共通のデータ型クラス
 * @author shun kawai
 */
public class BackendDataObject {
    /** 日付 */
    public LocalDateTime date;
    /** 開始時刻 */
    public LocalDateTime statrTime;
    /** 終了時刻 */
    public LocalDateTime endTime;
    /** 部 <br>
     *  ステージイベントは0とする
     * */
    public int bu;
    /** メンバー */
    public String member;
    /**
     *  詳細<br>
     *  デフォルトは通常握手
     */
    public String detail;
    /** 枚数 */
    public int num;
    /** 単価 */
    public int value;
    /** 
     * 当落 
     */
    public int result;

    /** 当選 */
    public static final int WIN = 0;
    /** 落選 */
    public static final int LOSE = 1;
    /** 抽選中 */
    public static final int DRAW = 2;

    /** 購入者名 */
    public String user;
    /** 会場名 */
    public String place;
    /** アーティスト名 */
    public String artist;
    /** CDタイトル */
    public String title;
    /** リリース番号 */
    public int release;

    public BackendDataObject(){
        this.detail = "通常握手";
        this.result = BackendDataObject.DRAW;
    }
    /**
     * 当落の状態を当選にする
     * @author shun kawai
     */
    public void win(){
        this.result = BackendDataObject.WIN;
    }
    /**
     * 当落の状態を落選にする
     * @author shun kawai
     */
    public void lose(){
        this.result = BackendDataObject.LOSE;
    }
}
