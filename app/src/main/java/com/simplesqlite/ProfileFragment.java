package com.simplesqlite;

/**
 * Created by fff on 08.12.2015.
 */
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
;
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
       // final Button btnBudget = (Button) rootView.findViewById(R.id.btnBudget);
        final Button btnExchange = (Button) rootView.findViewById(R.id.exchangeRateButton);
        //btnBudget.setOnClickListener(this);
        btnExchange.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
           /* case R.id.btnBudget:

                final EditText editTextBudget = (EditText) getActivity().findViewById(R.id.editTextBudget);
                final TextView textViewCurBudget = (TextView) getActivity().findViewById(R.id.textViewCurrentBudget);

                if (editTextBudget.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Type Your Budget!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Double.parseDouble(editTextBudget.getText().toString());
                    textViewCurBudget.setText(Double.toString(num1));

                    Fragment fragment = new Fragment();
                    Bundle bundle = new Bundle();
                    bundle.putDouble("budget",num1);
                    fragment.setArguments(bundle);
                    Toast.makeText(getActivity(), "Type Your Budget!" + bundle, Toast.LENGTH_SHORT).show();
                }
                break;*/
           case R.id.exchangeRateButton:
                Intent in = new Intent(getActivity(), ExchangeScreen.class);
                startActivity(in);
                break;
        }
    }
}
