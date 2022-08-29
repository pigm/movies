package com.core.data.entity.response;

import androidx.annotation.Keep;

@Keep
public class ResponseBaseEntity<T> {
    public String internalCode;
    public String message;
    public T payload;
}
