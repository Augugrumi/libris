package com.tfederico.libris.util.webSocket;

import java.util.Observer;

/**
 * Created by dpolonio on 03/05/17.
 */
public interface IWebSocket {

    void run ();
    void register (Observer o);
    void unRegister (Observer o);
}
