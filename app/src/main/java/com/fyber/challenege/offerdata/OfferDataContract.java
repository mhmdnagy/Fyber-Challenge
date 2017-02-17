package com.fyber.challenege.offerdata;

import com.fyber.challenege.BasePresenter;
import com.fyber.challenege.BaseView;

/**
 * Created by mNagy on 2/17/17.
 */

public interface OfferDataContract {

    interface Presenter extends BasePresenter {
        void submit(String appId, String userId, String securityToken);
    }

    interface View extends BaseView<OfferDataContract.Presenter> {

    }
}
