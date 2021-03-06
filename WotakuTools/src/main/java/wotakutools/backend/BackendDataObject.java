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
    /** 申し込み日時 */
    public LocalDateTime orderDate;
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
        this.date = LocalDateTime.now();
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
    /**
     * 月日からLocalDateTimeを生成する。
     * 年はorderDateを比較して計算する。
     * @param month 月
     * @param day 日
     * @return 申し込み日時を考慮し、年を追加したLocalDateTime
     * @author shun kawai
     */
    public LocalDateTime getLocalDateTime(int month, int day){
        LocalDateTime date = LocalDateTime.of(orderDate.getYear(), month, day, 0, 0);
        if (date.isBefore(orderDate)){
            date = date.plusYears(1);
        }
        return date;
    }

    @Override
    public String toString(){
        String str = "";
        str += "日時 : " + date.getYear() + "/" +  date.getMonthValue() + "/" + date.getDayOfMonth() + ", ";
        str += "種類 : " + member + " " + bu + "部 " + num + "枚";
        return str;
    }
}
