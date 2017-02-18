package com.fyber.challenege.data.source;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

/**
 * Created by mNagy on 2/11/17.
 */

public interface OffersDataSource {
    Observable<Response<ResponseBody>> getOffers(String appId, String ip, String locale, String offer_type,
                                                 String timestamp, String uId, String token);

    void setUserId(String userId);

    String getUserId();

    void setAppId(String appId);

    String getAppId();

    void setSecurityToken(String token);

    String getSecurityToken();
}
