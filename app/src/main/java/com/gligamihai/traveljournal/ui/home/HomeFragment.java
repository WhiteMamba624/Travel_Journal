package com.gligamihai.traveljournal.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gligamihai.traveljournal.R;
import com.gligamihai.traveljournal.db.TripViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements LifecycleObserver {


    private TripViewModel tripViewModel;
    private List<Trip> trips;
    private RecyclerView tripRecyclerView;
    private TripAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tripRecyclerView = view.findViewById(R.id.tripRecyclerView);
        adapter = new TripAdapter(getActivity());
        tripRecyclerView.setAdapter(adapter);
        tripRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return view;

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tripViewModel = new ViewModelProvider(getActivity()).get(TripViewModel.class);
        //tripViewModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(TripViewModel.class);
        //tripViewModel=new ViewModelProvider(requireActivity()).get(TripViewModel.class);
        tripViewModel.getAllTrips().observe(getActivity(), new Observer<List<Trip>>() {
            @Override
            public void onChanged(final List<Trip> trips) {
                adapter.setTrips(trips);
            }
        });
    }

    //    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}