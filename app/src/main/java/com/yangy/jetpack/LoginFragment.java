package com.yangy.jetpack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class LoginFragment extends Fragment {
    private String mName;
    private EditText mEtAccount;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString("name");
        }
        mEtAccount = view.findViewById(R.id.et_account);
        mEtAccount.setText(mName);

        view.findViewById(R.id.txt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(LoginFragment.this).navigateUp();
            }
        });
    }
}