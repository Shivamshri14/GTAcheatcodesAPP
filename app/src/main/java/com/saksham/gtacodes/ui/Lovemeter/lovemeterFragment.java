package com.saksham.gtacodes.ui.Lovemeter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.saksham.gtacodes.R;
import com.saksham.gtacodes.databinding.FragmentLovecalBinding;
import com.saksham.gtacodes.databinding.FragmentShareBinding;
import com.saksham.gtacodes.ui.share.shareViewModel;

public class lovemeterFragment extends Fragment {

    private lovemeterViewModel lovemeterViewModel;
    private @NonNull
    FragmentLovecalBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        lovemeterViewModel =
                new ViewModelProvider(this).get(lovemeterViewModel.class);

        binding = FragmentLovecalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Uri uriiii = Uri.parse("https://play.google.com/store/apps/details?id=com.shivam.lovemeter");
        Intent intentttt = new Intent(Intent.ACTION_VIEW,uriiii);
        startActivity(intentttt);

        requireActivity().onBackPressed();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}