package io.atty.ext.codec;

import io.atty.buffer.ByteBuffer;
import io.atty.core.api.IDecoder;
import io.atty.core.api.Session;

@SuppressWarnings("all")
public abstract class SimpleMessageCodec<I, O> extends SimpleMessageEncoder<I> implements IDecoder<O> {
    public abstract O decodeCodec(Session session, ByteBuffer input);

    public abstract void encodeCodec(Session session, I input, ByteBuffer output);

    @Override
    public void encode0(Session session, I input, ByteBuffer output) {
        this.encodeCodec(session, input, output);
    }

    @Override
    public O decode(Session session, ByteBuffer input) {
        return decodeCodec(session, input);
    }
}
