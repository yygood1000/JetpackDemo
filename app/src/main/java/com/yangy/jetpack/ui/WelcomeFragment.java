package com.yangy.jetpack.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;

import com.yangy.jetpack.R;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class WelcomeFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 传统传参
                Bundle bundle = new Bundle();
                bundle.putString("name", "YangY");
                // 仿Activity的系统页面跳转动画
                NavOptions navOptions = new NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_in_right_80) // 开启新页面时，新页面开启的动画
                        .setExitAnim(R.anim.alpha_out)// 开启新页面时，老页面的退出动画
                        .setPopEnterAnim(R.anim.alpha_in)// 返回老页面时，老页面的动画
                        .setPopExitAnim(R.anim.slide_out_right_and_alphe)// 返回老页面时，新页面的退出动画
                        .build();
                findNavController(WelcomeFragment.this).navigate(R.id.login_fragment, bundle, navOptions);
            }
        });
        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(WelcomeFragment.this).navigate(R.id.action_welcome_to_register);
            }
        });
    }
}