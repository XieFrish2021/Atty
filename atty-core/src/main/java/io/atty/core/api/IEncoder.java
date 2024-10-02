package io.atty.core.api;

import io.atty.buffer.ByteBuffer;

@SuppressWarnings("all")
public interface IEncoder {
    void encode(Session session, Object input, ByteBuffer output);
}
