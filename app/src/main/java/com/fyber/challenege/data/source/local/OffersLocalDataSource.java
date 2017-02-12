package com.fyber.challenege.data.source.local;

import com.fyber.challenege.data.OffersResponse;
import com.fyber.challenege.data.source.OffersDataSource;

import rx.Observable;

/**
 * Created by mNagy on 2/11/17.
 */

public class OffersLocalDataSource implements OffersDataSource {

    private static OffersLocalDataSource ourInstance = new OffersLocalDataSource();

    public static OffersLocalDataSource getInstance() {
        return ourInstance;
    }

    private OffersLocalDataSource() {
    }


    @Override
    public Observable<OffersResponse> getOffers(String appId, String ip, String locale, String offer_type, String timestamp, String uId, String token) {
        return null;
    }
}
