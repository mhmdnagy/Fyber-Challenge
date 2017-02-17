package com.fyber.challenege;

import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.offerdata.OfferDataContract;
import com.fyber.challenege.offerdata.OfferDataPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by mNagy on 2/17/17.
 */

public class OfferDataPresenterTest {

    @Mock
    private OffersRepository offersRepository;
    @Mock
    private OfferDataContract.View view;

    private OfferDataPresenter presenter;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        presenter = new OfferDataPresenter(offersRepository, view);
    }

    @Test
    public void submitDataTest(){
        presenter.submit("123", "567", "890");

        Mockito.verify(offersRepository).setAppId("123");
        Mockito.verify(offersRepository).setUserId("567");
        Mockito.verify(offersRepository).setSecurityToken("890");
    }
}
