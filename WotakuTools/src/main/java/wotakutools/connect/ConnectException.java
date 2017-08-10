package wotakutools.connect;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

class ConnectException extends java.io.IOException{
    public ConnectException(String str){
        super(str);
    }
}

class LoginFaild extends ConnectException {
    public LoginFaild(String str){
        super(str);
    }
}
