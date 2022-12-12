package com.saksham.gtacodes.ui.Rateus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RateusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RateusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Rateus fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}