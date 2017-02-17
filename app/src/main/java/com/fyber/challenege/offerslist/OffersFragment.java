package com.fyber.challenege.offerslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fyber.challenege.R;
import com.fyber.challenege.data.Offer;

import java.util.List;

import static com.fyber.challenege.offerslist.OffersContract.Presenter;

/**
 * A fragment representing a list of Items.
 */
public class OffersFragment extends Fragment implements OffersContract.View {

    private RecyclerView recyclerView;
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

        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offers, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) view;
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.getOffers("2070", "109.235.143.113", "de", "112",
                System.currentTimeMillis() / 1000L + "", "spiderman",
                "1c915e3b5d42d05136185030892fbb846c278927");
    }

    @Override
    public void showProgress(boolean show) {

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
