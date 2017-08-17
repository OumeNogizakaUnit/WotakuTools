<!-- coding: utf-8 -->
<!-- vi: set expandtab sw=2 ts=2 softtabstop=2 :-->
# 握手券管理ってめんどくさいよね

# 開発準備
**docフォルダにメモがいっぱいあるお**

## 事前準備
* javaのインストール

```console
$java -version
openjdk version "1.8.0_131"
OpenJDK Runtime Environment (build 1.8.0_131-8u131-b11-2ubuntu1.16.04.3-b11)
OpenJDK 64-Bit Server VM (build 25.131-b11, mixed mode)
$javac -version
javac 1.8.0_131
```

* gradle のインストール
  
```console
$gradle -v
------------------------------------------------------------
Gradle 4.1
------------------------------------------------------------

Build time:   2017-08-07 14:38:48 UTC
Revision:     941559e020f6c357ebb08d5c67acdb858a3defc2

Groovy:       2.4.11
Ant:          Apache Ant(TM) version 1.9.6 compiled on June 29 2015
JVM:          1.8.0_131 (Oracle Corporation 25.131-b11)
OS:           Linux 4.4.0-92-generic amd64

```

* gitのインストール

```console
$git --version
git version 2.7.4


```

## 環境の準備
### リポジトリのクローン

```console
$git colne https://github.com/OumeNogizakaUnit/WotakuTools
```

### ビルド

```console
$cd WotakuTools/WotakuTools
$gradle build

```

必要なjavaライブラリなどもこれでインストールされる


### 実行

```console
$gradle run
```
`WotakuTools/src/main/java/Tmpmain.java`の`Tmpmain`クラスが実行される。  
このコマンドで実行するクラスは`WotakuTools/build.gradle`の`mainClassName`というパラメータで設定されているので適宜変更してください

### テストコード実行

```console
$gradle test
```
`WotakuTools/src/test/java/`内のテストコードを実行する。  
最初はあんまり使わないと思う。

### javadoc生成

```console
$gradle javadoc
```
javadocを生成する。  
生成されたjavadocは`WotakuTools/build/docs/javadoc/index.html`をブラウザで開くと閲覧できる。  
javadocのコメントの書き方はぐぐってくれ

## [要件定義書](./doc/youken.md)

## [詳細設計書](./doc/shousai.md)
