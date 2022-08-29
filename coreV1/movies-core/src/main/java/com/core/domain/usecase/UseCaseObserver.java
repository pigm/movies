package com.core.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {
    @Override public void onNext(T value) {}
    @Override public void onError(Throwable e) { e.printStackTrace(); }
    @Override public void onComplete() {}
}