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
    /** 部 */
    public int bu;
    public String member;
    public String detail;
    public int num;
    public int value;
    public int result;

}
