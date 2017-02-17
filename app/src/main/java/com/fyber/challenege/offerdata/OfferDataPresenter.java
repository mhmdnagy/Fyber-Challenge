package com.fyber.challenege.offerdata;

import android.support.annotation.NonNull;

import com.fyber.challenege.data.source.OffersRepository;

/**
 * Created by mNagy on 2/17/17.
 */

public class OfferDataPresenter implements OfferDataContract.Presenter {

    private final String TAG = this.getClass().getName();
    @NonNull
    private OffersRepository offersRepository;
    @NonNull
    private OfferDataContract.View view;

    public OfferDataPresenter(@NonNull OffersRepository offersRepository, @NonNull OfferDataContract.View view) {
        this.offersRepository = offersRepository;
        this.view = view;

        this.view.setPresenter(this);
    }

    @Override
    public void submit(String appId, String userId, String securityToken) {
        offersRepository.setAppId(appId);
        offersRepository.setUserId(userId);
        offersRepository.setSecurityToken(securityToken);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
