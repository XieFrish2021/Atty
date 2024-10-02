package io.atty.ext.string;

import io.atty.buffer.ByteBuffer;
import io.atty.core.api.Session;
import io.atty.ext.codec.SimpleMessageCodec;

import java.nio.charset.StandardCharsets;

@SuppressWarnings("all")
public class StringMessageCodec extends SimpleMessageCodec<String, String> {
    @Override
    public String decodeCodec(Session session, ByteBuffer input) {
        byte[] data = new byte[input.writerIndex()];
        input.readBytes(data);

        return new String(data, StandardCharsets.UTF_8);
    }

    @Override
    public void encodeCodec(Session session, String input, ByteBuffer output) {
        output.writeBytes(input.getBytes(StandardCharsets.UTF_8));
    }
}
