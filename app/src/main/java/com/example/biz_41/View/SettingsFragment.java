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
 * Created by ПОДАРУНКОВИЙ on 20.05.2017.
 */

public class SettingsFragment extends DialogFragment implements View.OnClickListener {
    Boolean isCashEnabled;
    int aserts;

    public interface SettingDialogListener {
        void onFinishDialog(Boolean isCashEnabled, int asserts);
    }

    public SettingsFragment() {
    }

    public static SettingsFragment newInstance(Boolean isEnabled, int aserts) {
        SettingsFragment frag = new SettingsFragment();
        Bundle args = new Bundle();
        args.putBoolean("isEnabled", isEnabled);
        args.putInt("aserts", aserts);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,
                container, false);
        getDialog().setTitle("Настройки");
        Button nextButton = (Button) view.findViewById(R.id.sendToOrder);
        nextButton.setOnClickListener(this);
        EditText editText = (EditText)view.findViewById(R.id.edit_aserts);
        aserts = getArguments().getInt("aserts");
        editText.setText(String.valueOf(aserts));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    aserts = Integer.parseInt(editable.toString());
                }catch (Exception ignored){}
            }
        });
        isCashEnabled = getArguments().getBoolean("isCashEnabled");
        CheckBox checkBox = (CheckBox)view.findViewById(R.id.checkBox);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isCashEnabled = checkBox.isEnabled();
            }
        });


        return view;
    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(getActivity().getApplicationContext(),"SEND",Toast.LENGTH_SHORT).show();
        SettingDialogListener listener = (SettingDialogListener) getActivity();
        listener.onFinishDialog(isCashEnabled, aserts);

        dismiss();

    }

    // ...
}