package it.polpetta.libris.utils.webSocket.SSL;

import javax.net.ssl.SSLContext;

/**
 * Created by dpolonio on 03/05/17.
 */
public abstract class AbstractFactoryMethodSSL {

    protected String keyPassword = null;
    protected SSLContext sslContext = null;

    public AbstractFactoryMethodSSL () {

    }
}
