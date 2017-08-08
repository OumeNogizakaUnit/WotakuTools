# gradleメモ

## gradleインストール方法
### Windows
1. zipファイルをインストールし、解凍
  * https://services.gradle.org/distributions/gradle-4.0.2-all.zip
1. binフォルダにパスを通す 

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

## gradle run
* コンパイルしたjavaクラスの実行ができる便利コマンド
* 以下の2行をbuild.gradleに追記することで利用可能に

```Gradle
    apply plugin: 'application'
    mainClassName = 'sample.HelloGradle'
```
