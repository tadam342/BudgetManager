package com.simplesqlite.List;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.simplesqlite.MainActivity;
import com.simplesqlite.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by fff on 08.12.2015.
 */
public class ListViewFragment extends ListFragment {


    private List<Task> list = new ArrayList<Task>();
    private ListView listView;
    private CustomListAdapter adapter;
    private double sum=0;
    private double num1;
    private double cost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        final Button btnBudget = (Button) rootView.findViewById(R.id.btnBudget);
        btnBudget.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                addBudget();
            }
        });

        final Button btn = (Button) rootView.findViewById(R.id.btnAdd);
        adapter = new CustomListAdapter(getActivity(),list);

        /** Defining a click event listener for the button "Add" */
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        };
        /** Setting the event listener for the add button */
        btn.setOnClickListener(listener);

        /** Setting the adapter to the ListView */
        setListAdapter(adapter);
        return rootView;
    }


    protected void addBudget(){
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View promptView = layoutInflater.inflate(R.layout.budget_input_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);
        //final TextView textViewCurBudget = (TextView) promptView.findViewById(R.id.textViewCurrentBudget);
        final EditText editTextBudget = (EditText) promptView.findViewById(R.id.editTextBudget);

        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //if (budget != 0) {
                        if (editTextBudget.getText().toString().matches("")){
                            //&& budget > sum) {
                            Toast.makeText(getActivity(), "Type anything!", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            num1 = Double.parseDouble(editTextBudget.getText().toString());
                            Toast.makeText(getActivity(), "Your Budget: "+ num1, Toast.LENGTH_SHORT).show();
                            //textViewCurBudget.setText(String.format("%1$,.2f", num1));
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    protected void showInputDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View promptView = layoutInflater.inflate(R.layout.input_dialog, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(promptView);

        final EditText editTextDesc = (EditText) promptView.findViewById(R.id.txtItem);
        final EditText editTextCost = (EditText) promptView.findViewById(R.id.txtCost);
        //final double cost = Double.parseDouble(editTextCost.getText().toString());
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        sum = Double.parseDouble(editTextCost.getText().toString());
                            if (editTextDesc.getText().toString().matches("") && editTextCost.getText().toString().matches("")) {
                                Toast.makeText(getActivity(), "Type anything!", Toast.LENGTH_SHORT).show();
                            } else {
                                int retval = Double.compare(num1,sum);
                                if (retval >= 0) {
                                    int retval2 = Double.compare(num1,cost);
                                    if (retval2 > 0) {
                                        Toast.makeText(getActivity(), "Budget!" + num1, Toast.LENGTH_SHORT).show();
                                        list.add(new Task(editTextDesc.getText().toString(), Double.parseDouble(editTextCost.getText().toString())));
                                        editTextDesc.setText("");
                                        adapter.notifyDataSetChanged();
                                        cost = cost + Double.parseDouble(editTextCost.getText().toString());
                                        Toast.makeText(getActivity(), "Cost: " + cost, Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else {
                                    Toast.makeText(getActivity(), "Too Expensive!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            //} else {
                            //     Toast.makeText(getActivity(), "Enter your budget", Toast.LENGTH_SHORT).show();
                            //}
                        }
                })
                //editText.getText().toString()
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}