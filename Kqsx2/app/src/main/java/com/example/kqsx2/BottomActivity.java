package com.example.kqsx2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BottomActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private FrameLayout frameLayout;
    private LiveFragment liveFragment;
    private HistoryFragment historyFragment;
    private ChatLoginFragment chatLoginFragment;
    private PlayFragment playFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        navigation= (BottomNavigationView) findViewById(R.id.navigation);

        liveFragment = new LiveFragment();
        historyFragment=new HistoryFragment();
        chatLoginFragment=new ChatLoginFragment();
        playFragment=new PlayFragment();
        loadfrag(liveFragment);

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_live:
                        loadfrag(liveFragment);
                        return true;
                    case R.id.navigation_history:
                        loadfrag(historyFragment);
                        return true;
                    case R.id.navigation_chat:
                        loadfrag(chatLoginFragment);
                        return true;
                    case R.id.navigation_play:
                        loadfrag(playFragment);
                        return true;

                        default:
                            return false;

                }

            }
        });

    }
    private void loadfrag(Fragment fragment){
        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frag,fragment);
        fragmentTransaction.commit();
    }

}
