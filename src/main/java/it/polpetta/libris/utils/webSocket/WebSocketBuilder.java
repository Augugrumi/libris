package it.polpetta.libris.utils.webSocket;

import java.net.URI;
import java.util.ArrayList;

/**
 * Created by dpolonio on 03/05/17.
 */
public class WebSocketBuilder {

    private final ArrayList<URI> listOfFiles = new ArrayList<URI>();
    private int port = 443;
    private boolean isSSL = true;

    public WebSocketBuilder addFile (URI file) {

        if (!listOfFiles.contains(file)) {
            listOfFiles.add(file);
        }
        return this;
    }

    public WebSocketBuilder setPort (int port) {

        this.port = port;
        return this;
    }

    public WebSocketBuilder setSSL (boolean newSSLSetting) {

        this.isSSL = newSSLSetting;
        return this;
    }

    public IWebSocket getWebSocket() {

        return new ConcreteWebSocket(listOfFiles, port, isSSL);
    }
}