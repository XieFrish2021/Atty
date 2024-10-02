package io.atty.ext.handler;

import io.atty.core.api.IHandler;
import io.atty.core.api.Session;

@SuppressWarnings("all")
public abstract class SimpleMessageHandler<D> implements IHandler {
    public abstract void handler0(Session session, D data);

    @Override
    @SuppressWarnings("unchecked")
    public void handle(Session session, Object data) {
        this.handler0(session, (D) data);
    }
}
