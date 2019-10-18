package so.wwb.lotterybox.web.session;

import org.soul.web.session.ICipherKeyResolver;

public class CipherKeyResolver implements ICipherKeyResolver {

    private byte[] cipherKey;
    public void setCipherKey(byte[] cipherKey) {
        this.cipherKey = cipherKey;
    }

    @Override
    public byte[] getEncryptionCipherKey() {
        return cipherKey;
    }

    @Override
    public byte[] getDecryptionCipherKey() {
        return cipherKey;
    }
}
