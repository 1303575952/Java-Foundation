package nia.chapter10;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * @author FELIX
 * <p>
 * Listing 10.10 CombinedChannelDuplexHandler<I,O>
 */

public class CombinedByteCharCodec extends
        CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {
    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }
}
