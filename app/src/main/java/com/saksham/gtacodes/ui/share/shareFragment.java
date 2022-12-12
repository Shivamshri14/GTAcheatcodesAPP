package com.saksham.gtacodes.ui.share;

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
import com.saksham.gtacodes.databinding.FragmentShareBinding;
import com.saksham.gtacodes.ui.share.shareViewModel;

public class shareFragment extends Fragment {

    private shareViewModel shareViewModel;
    private @NonNull
    FragmentShareBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        shareViewModel =
                new ViewModelProvider(this).get(shareViewModel.class);

        binding = FragmentShareBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT," See, I found An Amazing App! \uD83E\uDD29\uD83E\uDD29\n" + "https://play.google.com/store/apps/details?id=com.saksham.gtacodes&hl=en&gl=IN");
        sendIntent.setType("text/plain");
        Intent shareIntent = Intent.createChooser(sendIntent,null);
        startActivity(shareIntent);
        requireActivity().onBackPressed();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}