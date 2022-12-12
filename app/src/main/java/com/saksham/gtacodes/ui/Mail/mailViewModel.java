package com.saksham.gtacodes.ui.Mail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class mailViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public mailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Contact US / MAil Us fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}

