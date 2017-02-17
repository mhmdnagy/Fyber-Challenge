package com.fyber.challenege.offerslist;

import com.fyber.challenege.BasePresenter;
import com.fyber.challenege.BaseView;
import com.fyber.challenege.data.Offer;

import java.util.List;

/**
 * Created by mNagy on 2/12/17.
 */

public interface OffersContract {

    interface Presenter extends BasePresenter {
        void getOffers(String ip, String locale, String offer_type, String timestamp);

        boolean isEmpty();
    }

    interface View extends BaseView<Presenter> {

        void showProgress(boolean show);

        void showError(String message);

        void showOffers(List<Offer> offers);

    }
}
