package com.core.util;

import org.greenrobot.eventbus.EventBus;

public class Bus {

    private static Bus mInstance;
    private final EventBus mEventBus;

    private Bus(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public static Bus getInstance() {
        if (mInstance == null) {
            mInstance = new Bus(EventBus.getDefault());
        }
        return mInstance;
    }

    public void sendEvent(Object e) {
        mEventBus.post(e);
    }

    public void register(Object s) {
        if (!isRegistered(s)) mEventBus.register(s);
    }

    public boolean isRegistered(Object s) {
        return mEventBus.isRegistered(s);
    }

    public void unRegister(Object s) {
        if (isRegistered(s)) mEventBus.unregister(s);
    }

    public void cancelEventDelivery(Object s) {
        mEventBus.cancelEventDelivery(s);
    }
}

