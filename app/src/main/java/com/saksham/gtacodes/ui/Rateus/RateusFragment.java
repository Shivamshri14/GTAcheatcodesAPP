package com.saksham.gtacodes.ui.Rateus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.saksham.gtacodes.databinding.FragmentRateusBinding;
import com.saksham.gtacodes.databinding.FragmentRateusBinding;

public class RateusFragment extends Fragment {

    private RateusViewModel rateusViewModel;
    private FragmentRateusBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
          rateusViewModel =
                new ViewModelProvider(this).get(RateusViewModel.class);

          binding = FragmentRateusBinding.inflate(inflater, container, false);
          View root = binding.getRoot();

          //Opening url using Uri

        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.saksham.gtacodes&hl=en&gl=IN");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);

        // To close the activity on pressing back button

        requireActivity().onBackPressed();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}