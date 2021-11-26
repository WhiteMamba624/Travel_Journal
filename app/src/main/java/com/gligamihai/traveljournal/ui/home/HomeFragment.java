package com.gligamihai.traveljournal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gligamihai.traveljournal.R;
import com.gligamihai.traveljournal.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    //    private HomeViewModel homeViewModel;
//    private FragmentHomeBinding binding;

    private List<Trip> trips;
    private RecyclerView tripRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tripRecyclerView=view.findViewById(R.id.tripRecyclerView);
        setupTrips();
        setupLayoutManager();
        setupAdapter();

        return view;
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;

    }
    private void setupAdapter() {
        tripRecyclerView.setAdapter(new TripAdapter(trips));
    }

    // data source
    private void setupTrips() {
        trips = new ArrayList<>();
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));
        trips.add(new Trip("Vacanta","Barcelona","poza"));

    }

    // setup LayoutManager
    private void setupLayoutManager() {
        tripRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}