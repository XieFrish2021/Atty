package io.atty.core.impl;

import io.atty.buffer.ByteBuffer;
import io.atty.core.api.Session;
import io.atty.core.options.AttyOptions;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import java.net.SocketAddress;

@SuppressWarnings("all")
public class DefaultSession implements Session {
    private final IoSession session;
    private final DefaultTCPServer server;

    public DefaultSession(IoSession session, DefaultTCPServer server) {
        this.session = session;
        this.server = server;
    }

    @Override
    public void disconnect() {
        this.session.closeNow();
    }

    @Override
    public void write(Object o) {
        if (this.server.encoder == null) {
            this.session.write(o);
        } else {
            Integer size = this.server.options(AttyOptions.WRITER_BUFFER_SIZE);
            ByteBuffer buffer = ByteBuffer.allocate(size);
            this.server.encoder.encode(this, o, buffer);

            IoBuffer allocate = IoBuffer.allocate(size);
            allocate.put(buffer.array());
            allocate.flip();
            this.session.write(allocate);
        }
    }

    @Override
    public SocketAddress remoteAddress() {
        return this.session.getRemoteAddress();
    }

    @Override
    public SocketAddress localAddress() {
        return this.session.getLocalAddress();
    }

    @Override
    public boolean isClosing() {
        return this.session.isClosing();
    }

    @Override
    public boolean isActive() {
        return this.session.isActive();
    }

    @Override
    public String toString() {
        return "session-" + this.session.getId();
    }
}
