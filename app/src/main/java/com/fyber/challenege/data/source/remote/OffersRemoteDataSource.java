package com.fyber.challenege.data.source.remote;

import com.fyber.challenege.data.source.OffersDataSource;
import com.fyber.challenege.network.RestClient;
import com.fyber.challenege.utils.HashKeyGenerator;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by mNagy on 2/12/17.
 */
public class OffersRemoteDataSource implements OffersDataSource {
    private static OffersRemoteDataSource ourInstance = new OffersRemoteDataSource();

    public static OffersRemoteDataSource getInstance() {
        return ourInstance;
    }

    private OffersRemoteDataSource() {
    }

    @Override
    public Observable<Response<ResponseBody>> getOffers(String appId, String ip, String locale, String offer_type, String timestamp, String uId, String token) {
        //generating the hash key
        String hashKey = HashKeyGenerator.generate(appId, ip, locale, offer_type, timestamp, uId, token);

        return RestClient.get().offers(appId, uId, ip, locale, offer_type, timestamp, hashKey);
    }

    @Override
    public void setUserId(String userId) {

    }

    @Override
    public String getUserId() {
        return null;
    }

    @Override
    public void setAppId(String appId) {

    }

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public void setSecurityToken(String token) {

    }

    @Override
    public String getSecurityToken() {
        return null;
    }
}

