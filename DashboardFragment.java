package com.example.capital_solutions.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.capital_solutions.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    //data vars
    String sExpense;
    String sMoneyLeft;
    String sIncome = "10.00";
    double dIncome = 10.00;
    double dMoneyLeft = 10.00;
    double dExpense;


    //Updating UI Elements
    Button expenseButton;
    Button incomeButton;
    EditText expenseText;
    EditText incomeText;
    TextView moneyLeftText;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        /*final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        expenseButton = (Button) root.findViewById(R.id.expenseButton);
        incomeButton = (Button) root.findViewById(R.id.incomeButton);
        incomeText = (EditText) root.findViewById(R.id.incomeText);
        expenseText = (EditText) root.findViewById(R.id.expenseText);
        moneyLeftText = (TextView) root.findViewById(R.id.moneyLeft);
        moneyLeftText.setText(sIncome);
        incomeText.setHint(sIncome);


        incomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nIncome = Double.valueOf(incomeText.getText().toString());
                if (String.valueOf(nIncome).contains(".0")){incomeText.setHint(String.valueOf(nIncome) + '0'); }
                else{incomeText.setHint(String.valueOf(nIncome));}

                double change = nIncome - dIncome;
                dMoneyLeft += change;
                sMoneyLeft = String.valueOf(dMoneyLeft);
                if (sMoneyLeft.contains(".0")){ sMoneyLeft += '0'; }
                moneyLeftText.setText(sMoneyLeft);

                dIncome = nIncome;
            }
        });

        expenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sExpense = expenseText.getText().toString();
                dExpense = Float.valueOf(sExpense);
                dMoneyLeft -= dExpense;
                sMoneyLeft = String.valueOf(dMoneyLeft);
                if (sMoneyLeft.contains(".0")){ sMoneyLeft += '0'; }
                moneyLeftText.setText(sMoneyLeft);
            }
        });

        return root;
    }
}