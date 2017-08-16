<!-- coding: utf-8 -->
<!-- vi: set expandtab sw=2 ts=2 -->
# 詳細設計書

## データの取得について
### フロー
1. ログイン処理(user情報はキャッシュしない)
1. 目的のページにアクセス
1. スクレイピングによって取得
1. 内部データ用に整形

### クラス分け詳細
* データ取得とログイン処理を行うクラス
* スクレイピングを行うクラス
* データの整形を行うクラス

### 内部データ構造

|データ|データ名|型|詳細|
|:-:|:-:|:-:|:-:|
|日時|date|java.time.LocalDateTime|年月日曜日|
|開始時刻|startTime|java.time.LocalDateTime||
|終了時刻|endTime|java.time.LocalDateTime||
|メンバー名|member|String|姓名間の空白はなしで統一|
|部|bu|int|ステージイベントなどは0部として扱う|
|種類|detail|String|主にキャラアニ用、デフォルトは通常握手|
|枚数|num|int||
|単価|value|int||
|当落|result|int|0: 当選 1: 落選 2: 抽選中|
