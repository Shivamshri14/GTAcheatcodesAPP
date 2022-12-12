package com.saksham.gtacodes.ui.Lovemeter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class lovemeterViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public lovemeterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Love meter - Love calculator fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
