package com.simplesqlite;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.simplesqlite.ExchangeRates.ExchangeScreen;
import com.simplesqlite.List.ListViewFragment;

public class ProfileFragment extends Fragment implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        final Button btnBudget = (Button) rootView.findViewById(R.id.btnBudget);
        final Button btnExchange = (Button) rootView.findViewById(R.id.exchangeRateButton);
        btnBudget.setOnClickListener(this);
        btnExchange.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnBudget:

                final EditText editTextBudget = (EditText) getActivity().findViewById(R.id.editTextBudget);
                final TextView textViewCurBudget = (TextView) getActivity().findViewById(R.id.textViewCurrentBudget);

                if (editTextBudget.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Type Your Budget!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Double.parseDouble(editTextBudget.getText().toString());
                    textViewCurBudget.setText(Double.toString(num1));

                    Intent intent = new Intent(getActivity(), ListViewFragment.class);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("budget", num1);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.exchangeRateButton:
                /*ProgressDialog dialog = ProgressDialog.show(getActivity(), "",
                        "Loading. Please wait...", true);*/
                Intent in = new Intent(getActivity(), ExchangeScreen.class);
                startActivity(in);
                break;
        }
    }
}
