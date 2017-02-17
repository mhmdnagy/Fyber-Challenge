package com.fyber.challenege;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.data.source.local.OffersLocalDataSource;
import com.fyber.challenege.data.source.remote.OffersRemoteDataSource;
import com.fyber.challenege.offerslist.OffersFragment;
import com.fyber.challenege.offerslist.OffersPresenter;
import com.fyber.challenege.utils.ActivityUtil;
import com.fyber.challenege.utils.schedulers.SchedulerProvider;

import static com.fyber.challenege.offerslist.OffersFragment.newInstance;

public class MainActivity extends AppCompatActivity{

    private OffersPresenter offersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OffersFragment offersFragment = (OffersFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        if (offersFragment == null) {
            offersFragment = newInstance();
            ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), offersFragment, R.id.fragment);
        }

        offersPresenter = new OffersPresenter(OffersRepository.getInstance(OffersLocalDataSource.getInstance(),
                OffersRemoteDataSource.getInstance()),
                SchedulerProvider.getInstance(),
                offersFragment);

    }
}
