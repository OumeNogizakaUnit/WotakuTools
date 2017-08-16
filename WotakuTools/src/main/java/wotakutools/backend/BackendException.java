package wotakutools.backend;
// coding: utf-8
// vi: set expandtab sw=4 ts=4 :

class BackendException extends java.io.IOException{
    public BackendException(String str){
        super(str);
    }
}

class LoginFaild extends BackendException {
    public LoginFaild(String str){
        super(str);
    }
}
