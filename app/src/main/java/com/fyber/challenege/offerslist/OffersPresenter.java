package com.fyber.challenege.offerslist;

import android.support.annotation.NonNull;

import com.fyber.challenege.data.OffersResponse;
import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.utils.schedulers.BaseSchedulerProvider;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

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
        this.offersRepository = checkNotNull(offersRepository, "OffersRepository cannot be null");
        this.schedulerProvider = checkNotNull(schedulerProvider, "BaseSchedulerProvider cannot be null");
        this.view = checkNotNull(view, "View cannot be null");

        this.view.setPresenter(this);
        subscription = new CompositeSubscription();

    }

    @Override
    public void getOffers(String ip, String locale, String offer_type, String timestamp) {
        this.subscription.clear();
        Subscription subscription = offersRepository
                .getOffers(offersRepository.getAppId(), ip, locale, offer_type, timestamp,
                        offersRepository.getUserId(), offersRepository.getSecurityToken())
                .subscribeOn(schedulerProvider.computation())
                .observeOn(schedulerProvider.ui())
                .subscribe(new Subscriber<OffersResponse>() {
                    @Override
                    public void onCompleted() {
                        view.showProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showProgress(false);
                        view.showError("Oops! Something went wrong.");
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
        view.showProgress(true);
    }

    @Override
    public void unsubscribe() {
        subscription.clear();
    }
}
