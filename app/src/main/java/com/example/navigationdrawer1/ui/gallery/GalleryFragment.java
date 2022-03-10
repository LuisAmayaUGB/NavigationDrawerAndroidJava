package com.example.navigationdrawer1.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer1.GreenFragment;
import com.example.navigationdrawer1.R;
import com.example.navigationdrawer1.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        View layout = inflater.inflate(R.layout.fragment_gallery, container, false);

        Button elclick=layout.findViewById(R.id.button1);
        elclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GalleryFragment fragment = new GalleryFragment();

                Bundle args = new Bundle();
                args.putString("ARG_PARAM1", "param1");
                args.putString("ARG_PARAM2", "param2");
                fragment.setArguments(args);






            }
        });




        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}