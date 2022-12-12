package com.saksham.gtacodes.ui.Mail;

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
import com.saksham.gtacodes.databinding.FragmentMailBinding;

public class mailFragment extends Fragment {

    private mailViewModel mailViewModel;
    private @NonNull
    FragmentMailBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        mailViewModel =
                new ViewModelProvider(this).get(mailViewModel.class);

        binding = FragmentMailBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","developer.shivam07@gmail.com",null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Body");
        startActivity(Intent.createChooser(emailIntent,"Send Email....."));

        requireActivity().onBackPressed();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}