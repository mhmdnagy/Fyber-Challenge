package com.fyber.challenege.data.source.local;

import com.fyber.challenege.data.source.OffersDataSource;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by mNagy on 2/11/17.
 */

public class OffersLocalDataSource implements OffersDataSource {

    private static OffersLocalDataSource ourInstance = new OffersLocalDataSource();

    private String appId;
    private String userId;
    private String securityToken;

    public static OffersLocalDataSource getInstance() {
        return ourInstance;
    }

    private OffersLocalDataSource() {
    }

    @Override
    public Observable<Response<ResponseBody>> getOffers(String appId, String ip, String locale, String offer_type, String timestamp, String uId, String token) {
        return null;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public void setSecurityToken(String token) {
        this.securityToken = token;
    }

    @Override
    public String getSecurityToken() {
        return securityToken;
    }
}
