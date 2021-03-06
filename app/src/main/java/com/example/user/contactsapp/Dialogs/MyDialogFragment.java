package com.example.user.contactsapp.Dialogs;

import android.annotation.SuppressLint;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.contactsapp.R;

/**
 * Created by User on 7/21/2017.
 */

public class MyDialogFragment extends DialogFragment {

    View.OnClickListener clickPositiveButton;
    View.OnClickListener clickNegativeButton;
    String title;
    Button positiveButton;
    Button negativeButton;
    EditText addDescriptionEdt;


    public EditText getAddDescriptionEdt() {
        return addDescriptionEdt;
    }

    @SuppressLint("ValidFragment")
    public MyDialogFragment(AlertFragmentSetImageDescriptionBuilder builder) {

        super();
        this.clickPositiveButton = builder.clickPositiveButton;
        this.clickNegativeButton = builder.clickNegativeButton;
        this.title = builder.title;

    }

    public MyDialogFragment() {

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        positiveButton = view.findViewById(R.id.fragment_image_description_btn_ok);
        negativeButton = view.findViewById(R.id.fragment_image_description_btn_cancel);
        addDescriptionEdt = view.findViewById(R.id.fragment_image_description_edt_description);

        positiveButton.setOnClickListener(clickPositiveButton);
        negativeButton.setOnClickListener(clickNegativeButton);

//        if(getArguments().isEmpty())
//           addDescriptionEdt.setHint("Type image url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image_description, container,
                false);

        getDialog().setTitle(title);
        return rootView;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    public static class AlertFragmentSetImageDescriptionBuilder {

        View.OnClickListener clickPositiveButton;
        View.OnClickListener clickNegativeButton;
        String title;

        public AlertFragmentSetImageDescriptionBuilder() {
        }

        public AlertFragmentSetImageDescriptionBuilder clickListenerPositiveButton(View.OnClickListener clickPositiveButton) {
            this.clickPositiveButton = clickPositiveButton;
            return this;
        }

        public AlertFragmentSetImageDescriptionBuilder clickListenerNegativeButton(View.OnClickListener clickNegativeButton) {
            this.clickNegativeButton = clickNegativeButton;
            return this;
        }
        public AlertFragmentSetImageDescriptionBuilder title(String title) {
            this.title = title;
            return this;
        }


        public MyDialogFragment build() {
            return new MyDialogFragment(this);
        }


    }


}


