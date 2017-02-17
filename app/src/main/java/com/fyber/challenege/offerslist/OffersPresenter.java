package com.fyber.challenege.offerslist;

import android.support.annotation.NonNull;
import android.util.Log;

import com.fyber.challenege.data.OffersResponse;
import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.utils.schedulers.BaseSchedulerProvider;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by mNagy on 2/12/17.
 */

public class OffersPresenter implements OffersContract.Presenter {

    private final String TAG = this.getClass().getName();
    @NonNull
    private OffersRepository offersRepository;
    @NonNull
    private BaseSchedulerProvider schedulerProvider;
    private CompositeSubscription subscription;
    @NonNull
    private OffersContract.View view;

    public OffersPresenter(@NonNull OffersRepository offersRepository, @NonNull BaseSchedulerProvider schedulerProvider,
                           @NonNull OffersContract.View view) {
        this.offersRepository = offersRepository;
        this.schedulerProvider = schedulerProvider;
        this.view = view;

        this.view.setPresenter(this);
        subscription = new CompositeSubscription();

    }

    @Override
    public void getOffers(String appId, String ip, String locale, String offer_type, String timestamp,
                          String uId, String token) {
        this.subscription.clear();
        Subscription subscription = offersRepository
                .getOffers(appId, ip, locale, offer_type, timestamp, uId, token)
                .observeOn(schedulerProvider.ui())
                .subscribeOn(schedulerProvider.computation())
                .subscribe(new Subscriber<OffersResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onNext(OffersResponse offersResponse) {
                        view.showOffers(offersResponse.getOffers());
                    }
                });

        this.subscription.add(subscription);

    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        subscription.clear();
    }
}