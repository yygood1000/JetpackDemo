package com.yangy.jetpack.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yangy.jetpack.R;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class RegisterFragment extends Fragment {
    private EditText mEtAccount;
    private EditText mEtEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEtAccount = view.findViewById(R.id.et_account);
        mEtEmail = view.findViewById(R.id.et_email);

        view.findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 使用Safe Args传参
                RegisterFragmentDirections.NextToInputPassword action =
                        RegisterFragmentDirections.nextToInputPassword()
                                .setName(mEtAccount.getEditableText().toString())
                                .setEmail(mEtEmail.getEditableText().toString());
                findNavController(RegisterFragment.this).navigate(action);
                getActivity().finish();
            }
        });
        view.findViewById(R.id.txt_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(RegisterFragment.this).navigateUp();
            }
        });
    }
}