package io.atty.core.api;

import io.atty.core.options.AttyOptions;

import java.net.InetSocketAddress;

@SuppressWarnings("all")
public interface TCPServer {
    void listen(InetSocketAddress address);

    void listen(String host, int port);

    void listen(int port, String host);

    void listen(int port);

    void listen(String host);

    void shutdown();

    void handler(IHandler handler);

    <O> void options(AttyOptions<O> options, O value);

    <O> O options(AttyOptions<O> options);

    void decoder(IDecoder<?> decoder);

    void encoder(IEncoder encoder);
}
