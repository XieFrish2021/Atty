package io.atty.core.api;

import io.atty.core.event.SessionEventType;

@FunctionalInterface
@SuppressWarnings("all")
public interface IHandler {
    void handle(Session session, Object data);

    default void exceptionCaught(Session session, Throwable throwable) {
        throwable.printStackTrace();
    };

    default void sessionEvent(Session session, SessionEventType type) {}
}
