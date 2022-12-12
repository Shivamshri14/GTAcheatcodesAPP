package com.saksham.gtacodes.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.saksham.gtacodes.GtaSanActivity;
import com.saksham.gtacodes.GtaViceCityActivity;
import com.saksham.gtacodes.R;
import com.saksham.gtacodes.databinding.FragmentHomeBinding;
import com.saksham.gtacodes.gta3Activity;
import com.saksham.gtacodes.gta4Activity;
import com.saksham.gtacodes.gta5Activity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s){

            }
        });
        // handling button clicks in fragment

        ImageButton imageButton_gta5 = root.findViewById(R.id.gta5_button);
        imageButton_gta5.setOnClickListener(this);
        ImageButton imageButton_gtasan = root.findViewById(R.id.gtas_button);
        imageButton_gtasan.setOnClickListener(this);
        ImageButton imageButton_gtavc = root.findViewById(R.id.gtavc_button);
        imageButton_gtavc.setOnClickListener(this);
        ImageButton imageButton_gta3 = root.findViewById(R.id.gta3_button);
        imageButton_gta3.setOnClickListener(this);
        ImageButton imageButton_gta4 = root.findViewById(R.id.gta4_button);
        imageButton_gta4.setOnClickListener(this);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.gta5_button:
                Intent intent = new Intent(requireActivity().getApplication(),gta5Activity.class);
                startActivity(intent);
                break;
            case R.id.gtas_button:
             Intent intent1 = new Intent(requireActivity().getApplication(),GtaSanActivity.class);
             startActivity(intent1);
             break;
            case R.id.gta3_button:
                Intent intent4 = new Intent(requireActivity().getApplication(), gta3Activity.class);
                startActivity(intent4);
                break;
            case R.id.gta4_button:
                Intent intent5 = new Intent(requireActivity().getApplication(), gta4Activity.class);
                startActivity(intent5);
                break;
            case R.id.gtavc_button:
                Intent intent2 = new Intent(requireActivity().getApplication(),GtaViceCityActivity.class);
                startActivity(intent2);
                break;

        }
    }
}