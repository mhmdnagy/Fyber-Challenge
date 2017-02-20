package com.fyber.challenege.offerslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fyber.challenege.R;
import com.fyber.challenege.data.Offer;
import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.data.source.local.OffersLocalDataSource;
import com.fyber.challenege.data.source.remote.OffersRemoteDataSource;
import com.fyber.challenege.utils.schedulers.SchedulerProvider;

import java.util.List;

import static com.fyber.challenege.offerslist.OffersContract.Presenter;

/**
 * A fragment representing a list of Items.
 */
public class OffersFragment extends Fragment implements OffersContract.View {

    //UI
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private Presenter presenter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OffersFragment() {
    }

    @SuppressWarnings("unused")
    public static OffersFragment newInstance() {
        OffersFragment fragment = new OffersFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (presenter == null)
            new OffersPresenter(OffersRepository.getInstance(OffersLocalDataSource.getInstance(),
                    OffersRemoteDataSource.getInstance()),
                    SchedulerProvider.getInstance(),
                    this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offers, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.getOffers("109.235.143.113", "de", "112", System.currentTimeMillis() / 1000L + "");
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showError(String message) {
        Snackbar snackbar = Snackbar.make(getView(), message, Snackbar.LENGTH_LONG)
                .setAction(R.string.action_try_again, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getActivity().onBackPressed();
                    }
                });

        snackbar.show();
    }

    @Override
    public void showOffers(List<Offer> offers) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OffersRecyclerViewAdapter(offers, getContext()));
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
