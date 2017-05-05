package it.polpetta.libris.utils.webSocket;

import java.util.Observer;

/**
 * Created by dpolonio on 03/05/17.
 */
public interface IWebSocket {

    void run ();
    void register (Observer o);
    void unRegister (Observer o);
}
