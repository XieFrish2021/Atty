package io.atty.core.api;

import java.net.SocketAddress;

@SuppressWarnings("all")
public interface Session {
    void disconnect();

    void write(Object o);

    SocketAddress remoteAddress();

    SocketAddress localAddress();

    boolean isClosing();

    boolean isActive();
}
