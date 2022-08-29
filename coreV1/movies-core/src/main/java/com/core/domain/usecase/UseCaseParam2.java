package com.core.domain.usecase;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

@Deprecated
public abstract class UseCaseParam2<P, T> extends BaseUseCase<T> {

    private final Scheduler scheduler;

    public UseCaseParam2(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void execute(DisposableObserver<T> disposableObserver, P param) {
        Preconditions.checkNotNull(disposableObserver);
        final Observable<T> observable = buildUseCaseObservable(param).subscribeOn(Schedulers.io())
                .observeOn(scheduler);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }




    public abstract Observable<T> buildUseCaseObservable(P param);



}
