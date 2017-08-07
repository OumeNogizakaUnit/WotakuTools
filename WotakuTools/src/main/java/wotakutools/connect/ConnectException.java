package wotakutools.connect;

public class ConnectException extends java.io.IOException{
    public ConnectException(String str){
        super(str);
    }
}

class LoginFaild extends ConnectException {
    public LoginFaild(String str){
        super(str);
    }
}
