package it.polpetta.libris.utils.SSL;

import javax.net.ssl.SSLContext;

/**
 * Created by dpolonio on 03/05/17.
 */
public abstract class AbstractFactoryMethodSSL {

    protected String keyPassword = null;
    protected SSLContext sslContext = null;

    public AbstractFactoryMethodSSL (String keyPassword) {

        this.keyPassword = keyPassword;
    }

    public abstract ISSLContextObtainer makeSSLContextObtainer();
}
