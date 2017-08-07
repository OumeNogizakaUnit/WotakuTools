package wotakutools.connect;

import org.jsoup.nodes.Document;

public abstract class Connect{
    abstract public int login(String username, String password);
    abstract public Document connect(String URI);
}

