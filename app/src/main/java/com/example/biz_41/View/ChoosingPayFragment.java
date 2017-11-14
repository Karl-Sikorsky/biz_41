package com.example.biz_41.View;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.biz_41.R;

/**
 * Created by ПОДАРУНКОВИЙ on 14.11.2017.
 */

public class ChoosingPayFragment extends DialogFragment implements View.OnClickListener {
    int sum;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choosing_pay,
                container, false);
    sum = 0;
        Button nextButton = (Button) view.findViewById(R.id.buttonChoosePay);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        RadioButton week = (RadioButton)view.findViewById(R.id.radioButton);
        RadioButton month = (RadioButton)view.findViewById(R.id.radioButton2);
        RadioButton year = (RadioButton)view.findViewById(R.id.radioButton3);
        RadioButton ever = (RadioButton)view.findViewById(R.id.radioButton4);
        week.setOnClickListener(this);
        month.setOnClickListener(this);
        year.setOnClickListener(this);
        ever.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {



            RadioButton rb = (RadioButton)view;
            switch (rb.getId()) {
                case R.id.radioButton:sum = 5;
                    break;
                case R.id.radioButton2: sum=15;
                    break;
                case R.id.radioButton3: sum=100;
                    break;
                case R.id.radioButton4: sum=150;
                    break;

                default:
                    break;
            }
    }


}
