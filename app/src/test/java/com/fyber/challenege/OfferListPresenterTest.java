package com.fyber.challenege;

import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.offerslist.OffersContract;
import com.fyber.challenege.offerslist.OffersPresenter;
import com.fyber.challenege.utils.schedulers.BaseSchedulerProvider;
import com.fyber.challenege.utils.schedulers.ImmediateSchedulerProvider;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mNagy on 2/17/17.
 */

public class OfferListPresenterTest {

    private static String responseJson = "{\n" +
            " \"code\": \" OK\" ,\n" +
            " \"message\": \"OK\",\n" +
            " \"count\": 1,\n" +
            " \"pages\": 1,\n" +
            " \"information\" : {\n" +
            "  \"app_name\": \"SP Test App\" ,\n" +
            "  \"appid\": 157,\n" +
            "  \"virtual_currency\": \"Coins\",\n" +
            "  \"country\": \" US\" ,\n" +
            "  \"language\": \" EN\" ,\n" +
            "  \"support_url\": \"http://iframe.fyber.com/mobile/DE/157/my_offers\"\n" +
            " },\n" +
            " \"offers\": [\n" +
            "  {\n" +
            "    \"title\": \"Tap  Fish\",\n" +
            "    \"offer_id\": 13554,\n" +
            "    \"teaser\": \"Download and START\" ,\n" +
            "    \"required_actions\": \"Download and START\",\n" +
            "    \"link\": \"http://iframe.fyber.com/mbrowser?appid=157&lpid=11387&uid=player1\",\n" +
            "    \"offer_types\" : [\n" +
            "     {\n" +
            "      \"offer_type_id\": 101,\n" +
            "      \"readable\": \"Download\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"offer_type_id\": 112,\n" +
            "      \"readable\": \"Free\"\n" +
            "     }\n" +
            "    ] ,\n" +
            "    \"thumbnail\" : {\n" +
            "     \"lowres\": \"http://cdn.fyber.com/assets/1808/icon175x175-2_square_60.png\",\n" +
            "     \"hires\": \"http://cdn.fyber.com/assets/1808/icon175x175-2_square_175.png\"\n" +
            "    },\n" +
            "    \"payout\": 90,\n" +
            "    \"time_to_payout\" : {\n" +
            "     \"amount\": 1800 ,\n" +
            "     \"readable\": \"30 minutes\"\n" +
            "    }\n" +
            "  }\n" +
            " ]\n" +
            "}";

    @Mock
    private OffersRepository offersRepository;
    @Mock
    private OffersContract.View view;

    private Response<ResponseBody> response;
    private ResponseBody responseBody;

    private String appId;
    private String ip;
    private String locale;
    private String offers_type;
    private String timestamp;
    private String uId;
    private String token;

    private BaseSchedulerProvider schedulerProvider;
    private OffersPresenter offersPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        schedulerProvider = new ImmediateSchedulerProvider();

        responseBody = ResponseBody.create(MediaType.parse(responseJson), "");
        response = Response.success(responseBody);

        offersPresenter = new OffersPresenter(offersRepository, schedulerProvider, view);

        appId = "2070";
        ip = "192.168.0.1";
        locale = "de";
        offers_type = "112";
        uId = "spiderman";
        timestamp = System.currentTimeMillis() / 1000L + "";
        token = "1fd2as345sd5df667";
    }

    @Test
    public void schedulerProviderTest() {
        Assert.assertNotNull(schedulerProvider);
    }

    @Test
    public void loadOffersTest() {
        when(offersRepository.getAppId()).thenReturn(appId);
        when(offersRepository.getUserId()).thenReturn(uId);
        when(offersRepository.getSecurityToken()).thenReturn(token);
        when(offersRepository.getOffers(appId, ip, locale, offers_type, timestamp, uId, token))
                .thenReturn(Observable.just(response));

        offersPresenter.getOffers(ip, locale, offers_type, timestamp);

        verify(view).showProgress(false);
    }

    @Test
    public void loadOffersErrorTest() {
        when(offersRepository.getAppId()).thenReturn(appId);
        when(offersRepository.getUserId()).thenReturn(uId);
        when(offersRepository.getSecurityToken()).thenReturn(token);

        when(offersRepository.getOffers(appId, ip, locale, offers_type, timestamp, uId, token))
                .thenReturn(Observable.<Response<ResponseBody>>error(new Exception()));

        offersPresenter.getOffers(ip, locale, offers_type, timestamp);

        verify(view).showError("Oops! Something went wrong.");
        verify(view).showProgress(false);
    }
}
