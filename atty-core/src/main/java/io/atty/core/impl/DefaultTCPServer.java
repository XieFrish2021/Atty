package io.atty.core.impl;

import io.atty.buffer.ByteBuffer;
import io.atty.core.api.*;
import io.atty.core.event.SessionEventType;
import io.atty.core.options.AttyOptions;
import org.apache.mina.core.buffer.AbstractIoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("all")
public class DefaultTCPServer implements TCPServer {
    private final SocketAcceptor acceptor = new NioSocketAcceptor();
    private final DefaultTCPServer server;
    private IHandler handler;
    private IDecoder<?> decoder;
    public IEncoder encoder;
    private boolean isRunning;

    public DefaultTCPServer() {
        this.isRunning = true;
        this.server = this;
        this.setupOptions();
        acceptor.setHandler(new IoHandlerAdapter() {
            private Session session;

            @Override
            public void sessionCreated(IoSession session) throws Exception {
                this.session = new DefaultSession(session, server);
                handler.sessionEvent(this.session, SessionEventType.CREATED);
                super.sessionCreated(session);
            }

            @Override
            public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
                handler.sessionEvent(this.session, SessionEventType.IDLE);
                super.sessionIdle(session, status);
            }

            @Override
            public void sessionClosed(IoSession session) throws Exception {
                handler.sessionEvent(this.session, SessionEventType.CLOSED);
                super.sessionClosed(session);
            }

            @Override
            public void sessionOpened(IoSession session) throws Exception {
                handler.sessionEvent(this.session, SessionEventType.OPENED);
                super.sessionOpened(session);
            }

            @Override
            public void messageReceived(IoSession session, Object message) {
                if (decoder == null){
                    AbstractIoBuffer messages = ((AbstractIoBuffer) message);
                    byte[] data = new byte[messages.limit()];
                    messages.get(data);

                    System.out.println(Arrays.toString(data));
                    handler.handle(
                            this.session,
                            ByteBuffer.allocate(
                                    options(AttyOptions.READER_BUFFER_SIZE)
                                    )
                                    .writeBytes(data)
                    );
                } else {
                    AbstractIoBuffer messages = ((AbstractIoBuffer) message);
                    byte[] data = new byte[messages.limit()];
                    messages.get(data);

                    Object decode = decoder.decode(
                            this.session,
                            ByteBuffer.allocate(
                                    options(AttyOptions.READER_BUFFER_SIZE)
                                    )
                                    .writeBytes(data)
                    );
                    handler.handle(this.session, decode);
                }
            }

            @Override
            public void exceptionCaught(IoSession session, Throwable cause) {
                handler.exceptionCaught(this.session, cause);
            }
        });
    }

    private void setupOptions() {
        SocketSessionConfig sessionConfig = this.acceptor.getSessionConfig();

        sessionConfig.setTcpNoDelay(options(AttyOptions.TCP_NO_DELAY));
        sessionConfig.setKeepAlive(options(AttyOptions.KEEP_ALIVE));
    }

    @Override
    public void listen(InetSocketAddress address) {
        try {
            acceptor.bind(address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void listen(String host, int port) {
        this.listen(new InetSocketAddress(host, port));
    }

    @Override
    public void listen(int port, String host) {
        this.listen(host, port);
    }

    @Override
    public void listen(int port) {
        this.listen("localhost", port);
    }

    @Override
    public void listen(String host) {
        this.listen(host, 80);
    }

    @Override
    public void shutdown() {
        if (isRunning) {
            isRunning = false;
            Collection<IoSession> sessions = acceptor.getManagedSessions().values();
            for (IoSession session : sessions) {
                session.closeNow();
            }

            acceptor.unbind();
            acceptor.dispose();
        }
    }

    @Override
    public void handler(IHandler handler) {
        this.handler = handler;
    }

    @Override
    public <O> void options(AttyOptions<O> options, O value) {
        options.setValue(value);
        this.setupOptions();
    }

    @Override
    public <O> O options(AttyOptions<O> options) {
        return options.getValue();
    }

    @Override
    public void decoder(IDecoder<?> decoder) {
        this.decoder = decoder;
    }

    @Override
    public void encoder(IEncoder encoder) {
        this.encoder = encoder;
    }
}
