package io.atty.ext.codec;

import io.atty.buffer.ByteBuffer;
import io.atty.core.api.IEncoder;
import io.atty.core.api.Session;

@SuppressWarnings("all")
public abstract class SimpleMessageEncoder<D> implements IEncoder {
    public abstract void encode0(Session session, D input, ByteBuffer output);

    @Override
    public void encode(Session session, Object input, ByteBuffer output) {
        this.encode0(session, (D) input, output);
    }
}
