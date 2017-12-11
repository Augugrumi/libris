package com.tfederico.libris.util.webSocket;

import java.net.URI;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by dpolonio on 03/05/17.
 */
class ConcreteWebSocket extends Observable implements IWebSocket {

    private ArrayList<URI> fileToServe = null;
    private int port = 0;
    private boolean isSSL = true;

    ConcreteWebSocket (ArrayList<URI> fileToServe, int port, boolean isSSL) {

        this.fileToServe = fileToServe;
        this.port = port;
        this.isSSL = isSSL;
    }

    public void run () {}

    public void register (Observer o) {

        super.addObserver(o);
    }

    public void unRegister (Observer o) {

        super.deleteObserver(o);
    }
}
