package com.yangy.jetpack.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<User> users;

    public MutableLiveData<User> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            //TODO可以从网络获取
        }
        return users;
    }

    //setValue():须在主线程中才能使用  postValue():既可在主线程也可在子线程中调用 即在工作线程中调用
    public void setUsers(String name) {
        users.setValue(new User(name));
    }
}
