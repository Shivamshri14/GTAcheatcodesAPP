package com.saksham.gtacodes.ui.tic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TicViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Tic Tac Toe fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
