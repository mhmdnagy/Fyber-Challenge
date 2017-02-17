package com.fyber.challenege.offerdata;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.fyber.challenege.R;
import com.fyber.challenege.data.source.OffersRepository;
import com.fyber.challenege.data.source.local.OffersLocalDataSource;
import com.fyber.challenege.data.source.remote.OffersRemoteDataSource;

import static com.fyber.challenege.offerdata.OfferDataContract.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfferDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferDataFragment extends Fragment implements OfferDataContract.View {

    private Presenter presenter;
    private OfferDataListener listener;

    //UI
    private EditText appIdEditText;
    private EditText userIdEditText;
    private EditText tokenEditText;
    private Button submitButton;

    public OfferDataFragment() {
        // Required empty public constructor
    }

    public static OfferDataFragment newInstance() {
        OfferDataFragment fragment = new OfferDataFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (presenter == null)
            new OfferDataPresenter(OffersRepository.getInstance(OffersLocalDataSource.getInstance(),
                    OffersRemoteDataSource.getInstance()), this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_offer_data, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appIdEditText = (EditText) view.findViewById(R.id.app_id_et);
        userIdEditText = (EditText) view.findViewById(R.id.user_id_et);
        tokenEditText = (EditText) view.findViewById(R.id.security_token_et);
        submitButton = (Button) view.findViewById(R.id.submit_btn);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateStrings();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OfferDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OfferDataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void validateStrings() {
        String appId;
        String userId;
        String securityToken;

        appId = appIdEditText.getText().toString();
        userId = userIdEditText.getText().toString();
        securityToken = tokenEditText.getText().toString();

        if (TextUtils.isEmpty(appId.trim())) {
            appIdEditText.setError(getString(R.string.error_enter_app_id));
            return;
        }

        if (TextUtils.isEmpty(userId.trim())) {
            userIdEditText.setError(getString(R.string.error_enter_user_id));
            return;
        }

        if (TextUtils.isEmpty(securityToken.trim())) {
            tokenEditText.setError(getString(R.string.error_enter_security_token));
            return;
        }


        presenter.submit(appId, userId, securityToken);

        if (listener != null)
            listener.onDataSubmitted();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public interface OfferDataListener {
        void onDataSubmitted();
    }
}
