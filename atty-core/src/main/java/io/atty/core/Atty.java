package io.atty.core;

import io.atty.core.api.TCPServer;
import io.atty.core.impl.DefaultTCPServer;

@SuppressWarnings("all")
public interface Atty {
    public static TCPServer createServer() {
        return new DefaultTCPServer();
    }
}
