package com.fyber.challenege;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fyber.challenege.offerdata.OfferDataFragment;
import com.fyber.challenege.offerslist.OffersFragment;
import com.fyber.challenege.utils.ActivityUtil;

public class MainActivity extends AppCompatActivity implements OfferDataFragment.OfferDataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            OfferDataFragment offerDataFragment = OfferDataFragment.newInstance();
            ActivityUtil.addFirstFragmentToActivity(getSupportFragmentManager(), offerDataFragment, R.id.fragment);
        }
    }

    @Override
    public void onDataSubmitted() {
        OffersFragment offersFragment = OffersFragment.newInstance();
        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), offersFragment, R.id.fragment);
    }
}
