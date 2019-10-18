package so.wwb.lotterybox.web.session;

import org.soul.web.session.ICipherKeyResolver;

/**
 * Created by longer on 2/19/16.
 */
public class CipherKeyResolver implements ICipherKeyResolver {

    private byte[] cipherKey;

    @Override
    public byte[] getEncryptionCipherKey() {
        return cipherKey;
    }

    @Override
    public byte[] getDecryptionCipherKey() {
        return cipherKey;
    }

    public void setCipherKey(byte[] cipherKey) {
        this.cipherKey = cipherKey;
    }
}
