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

import com.example.biz_41.R;

/**
 * Created by ПОДАРУНКОВИЙ on 19.10.2017.
 */

public class OrderFragment extends DialogFragment implements View.OnClickListener {

    EditText edName,edMail,edTelephon,edDescription;
    public static OrderFragment newInstance() {
        OrderFragment frag = new OrderFragment();

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,
                container, false);
        getDialog().setTitle("ВАШ ЗАПИТ");
        Button send = (Button) view.findViewById(R.id.buttonSendOrder);
        send.setOnClickListener(this);
         edName = (EditText)view.findViewById(R.id.edName);
        edMail = (EditText)view.findViewById(R.id.edMail);
         edTelephon = (EditText)view.findViewById(R.id.edTelephon);
        edDescription = (EditText)view.findViewById(R.id.edDescription);


        return view;
    }
    @Override
    public void onClick(View view) {
        sendOrder(edName.getText().toString(),edMail.getText().toString(),edTelephon.getText().toString(),edDescription.getText().toString());
        dismiss();
    }

    private void sendOrder(String text, String edMailText, String edTelephonText, String edDescriptionText) {
    }
}
