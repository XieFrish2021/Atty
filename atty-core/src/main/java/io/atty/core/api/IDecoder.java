package io.atty.core.api;

import io.atty.buffer.ByteBuffer;

@SuppressWarnings("all")
public interface IDecoder<D> {
    D decode(Session session, ByteBuffer input);
}
