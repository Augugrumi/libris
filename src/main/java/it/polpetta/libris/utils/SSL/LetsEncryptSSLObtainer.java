package it.polpetta.libris.utils.SSL;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Created by davide on 03/05/17.
 */
// TODO: we need to make a cert and a privkey first! See https://github.com/txedo/bouncycastle-rsa-pem-write
class LetsEncryptSSLObtainer implements ISSLContextObtainer {

    private String pathToCerts = null;
    private String keyPassword = null;

    public LetsEncryptSSLObtainer (String pathToCerts, String keyPassword) {

        this.pathToCerts = pathToCerts;
        this.keyPassword = keyPassword;

    }

    /**
     * Method which returns a SSLContext from a Let's encrypt or null if an exception occurred
     * Taken from: https://github.com/TooTallNate/Java-WebSocket/wiki/Getting-a-SSLContext-from-different-sources
     *
     * @return a valid SSLContext or null if an error occurred
     */
    public SSLContext getSSLContext() {

        SSLContext context;
        try {
            context = SSLContext.getInstance("TLS");

            byte[] certBytes = parseDERFromPEM(
                    Files.readAllBytes(
                            new File(pathToCerts + File.separator + "cert.pem").toPath()),
                    "-----BEGIN CERTIFICATE-----",
                    "-----END CERTIFICATE-----"
            );

            byte[] keyBytes = parseDERFromPEM(
                    Files.readAllBytes(
                            new File(pathToCerts + File.separator + "privkey.pem").toPath()),
                    "-----BEGIN PRIVATE KEY-----",
                    "-----END PRIVATE KEY-----"
            );

            X509Certificate cert = generateCertificateFromDER(certBytes);
            RSAPrivateKey key = generatePrivateKeyFromDER(keyBytes);

            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(null);
            keystore.setCertificateEntry("cert-alias", cert);
            keystore.setKeyEntry("key-alias", key, keyPassword.toCharArray(), new Certificate[]{cert});

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keystore, keyPassword.toCharArray());

            KeyManager[] km = kmf.getKeyManagers();

            context.init(km, null, null);

        } catch (IOException |
                KeyManagementException |
                KeyStoreException |
                InvalidKeySpecException |
                UnrecoverableKeyException |
                NoSuchAlgorithmException |
                CertificateException e) {

            e.printStackTrace();
            return null;
        }

        return context;
    }

    private static byte[] parseDERFromPEM(byte[] pem, String beginDelimiter, String endDelimiter) {

        String data = new String(pem);
        String[] tokens = data.split(beginDelimiter);
        tokens = tokens[1].split(endDelimiter);
        return DatatypeConverter.parseBase64Binary(tokens[0]);
    }

    private static RSAPrivateKey generatePrivateKeyFromDER(byte[] keyBytes)
            throws InvalidKeySpecException, NoSuchAlgorithmException {

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return (RSAPrivateKey) factory.generatePrivate(spec);
    }

    private static X509Certificate generateCertificateFromDER(byte[] certBytes) throws CertificateException {

        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(certBytes));
    }
}
