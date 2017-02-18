package com.fyber.challenege.data.source;

import android.support.annotation.NonNull;

import com.fyber.challenege.data.source.local.OffersLocalDataSource;
import com.fyber.challenege.data.source.remote.OffersRemoteDataSource;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by mNagy on 2/12/17.
 */
public class OffersRepository implements OffersDataSource {
    private static OffersRepository INSTANCE;

    private OffersRemoteDataSource remoteDataSource;
    private OffersLocalDataSource localDataSource;

    public static OffersRepository getInstance(@NonNull OffersLocalDataSource localDataSource,
                                               @NonNull OffersRemoteDataSource remoteDataSource) {
        if (INSTANCE == null)
            INSTANCE = new OffersRepository(localDataSource, remoteDataSource);

        return INSTANCE;
    }

    private OffersRepository(@NonNull OffersLocalDataSource localDataSource,
                             @NonNull OffersRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<Response<ResponseBody>> getOffers(String appId, String ip, String locale, String offer_type,
                                                        String timestamp, String uId, String token) {
        return remoteDataSource.getOffers(appId, ip, locale, offer_type, timestamp, uId, token);
    }

    @Override
    public void setUserId(String userId) {
        localDataSource.setUserId(userId);
    }

    @Override
    public String getUserId() {
        return localDataSource.getUserId();
    }

    @Override
    public void setAppId(String appId) {
        localDataSource.setAppId(appId);
    }

    @Override
    public String getAppId() {
        return localDataSource.getAppId();
    }

    @Override
    public void setSecurityToken(String token) {
        localDataSource.setSecurityToken(token);
    }

    @Override
    public String getSecurityToken() {
        return localDataSource.getSecurityToken();
    }
}
