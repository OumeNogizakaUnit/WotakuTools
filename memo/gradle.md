# gradleメモ

## gradle init
    * gradle用の環境設定が一発でできちゃう便利コマンド
    * type属性を指定して様々な環境が作れる
    * type属性に指定できるのは以下の通り
        1. pom (Maven プロジェクトを変換)
        1. scala-library
        1. groovy-library
        1. java-library
        1. basic
    * javaプロジェクトを作るなら以下のコマンドでおｋ
    ```console
    $ gradle init --type java-library
    ```

