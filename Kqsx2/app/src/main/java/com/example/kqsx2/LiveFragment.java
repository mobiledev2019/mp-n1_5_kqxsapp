package com.example.kqsx2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveFragment extends Fragment {

   private TabLayout tabLayout;
   private AppBarLayout appBarLayout;
   private ViewPager viewPager;

    public LiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_live, container, false);

        tabLayout=(TabLayout)view.findViewById(R.id.tablive);
        appBarLayout=(AppBarLayout)view.findViewById(R.id.appbarlive);
        viewPager=(ViewPager)view.findViewById(R.id.viewpagerlive);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getFragmentManager());
        adapter.AddFragment(new LiveBFragment(),"Miền Bắc");
        adapter.AddFragment(new LiveTFragment(),"Miền Trung");
        adapter.AddFragment(new LiveNFragment(),"Miền Nam");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

    }
}
