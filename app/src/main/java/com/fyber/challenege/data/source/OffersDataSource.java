package com.fyber.challenege.data.source;

import com.fyber.challenege.data.OffersResponse;

import rx.Observable;

/**
 * Created by mNagy on 2/11/17.
 */

public interface OffersDataSource {
    Observable<OffersResponse> getOffers(String appId, String ip, String locale, String offer_type,
                                         String timestamp, String uId, String token);
}
