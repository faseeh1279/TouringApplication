package com.example.touringapplication.MainUI;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.touringapplication.MainActivity;
import com.example.touringapplication.MainUI.HomePageRecyclerView.Adapter;
import com.example.touringapplication.MainUI.HomePageRecyclerView.Model;
import com.example.touringapplication.R;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends Fragment {


    public HomePage() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    List<Model> modelList = new ArrayList<>();
    Adapter adapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home_page, container, false);
        // Inflate the layout for this fragment

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] email = {"faseehraza1279@gmail.com", "shoaibshoaib@gmail.com", "khokharkhokhar@gmail.com", "wolfcreekmanor@gmail.com"};
        String[] password = {"ipconfig", "kevinalmasafar", "netshwlanshow", "profiledebuging"};
        int[] images = {R.drawable.sample1, R.drawable.sample2, R.drawable.sample3, R.drawable.sample4};
        for (int i=0; i<4; i++){
            modelList.add(new Model(email[i], password[i], images[i]));
        }
        adapter = new Adapter(requireContext(), modelList);
        recyclerView.setAdapter(adapter);



        return view;
    }
}