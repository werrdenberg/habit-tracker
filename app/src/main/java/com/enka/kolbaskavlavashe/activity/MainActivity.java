package com.enka.kolbaskavlavashe.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.enka.kolbaskavlavashe.activity.constants.TextConstants;
import com.enka.kolbaskavlavashe.activity.fragment.HabitsFragment;
import com.enka.kolbaskavlavashe.activity.fragment.NewTraitFragment;
import com.enka.kolbaskavlavashe.activity.fragment.PrizesFragment;
import com.enka.kolbaskavlavashe.R;
import com.enka.kolbaskavlavashe.activity.fragment.SettingsFragment;
import com.enka.kolbaskavlavashe.activity.fragment.StatisticsFragment;
import com.enka.kolbaskavlavashe.enums.FragmentState;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Fragment selectedFragment;

    private FragmentState fragmentState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        try{
            TextConstants.loadConstants(MainActivity.this);
        } catch (IOException exception){
            System.out.println("Не удалооооось!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.nav_statistics);
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavigationActionHandler);

        FrameLayout plusButton = findViewById(R.id.plus_button);
        TextView titleTextView = findViewById(R.id.titleTextView);

        plusButton.setOnClickListener((view) -> {
            if (FragmentState.NAVIGATION_PRIZES.equals(fragmentState)){

            }
            else if (FragmentState.NEW_TRAIT.equals(fragmentState)){

            }
            else{
                selectedFragment = new NewTraitFragment();
                fragmentState = FragmentState.NEW_TRAIT;
                titleTextView.setText("Новая\nпривычка");
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView2, selectedFragment)
                        .commit();
                bottomNavigationView.setSelectedItemId(R.id.nav_nothing);
            }
        });
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationActionHandler =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int selectedFragmentId = item.getItemId();
                    TextView titleTextView = findViewById(R.id.titleTextView);
                    if (selectedFragmentId == R.id.nav_prizes){
                        selectedFragment = new PrizesFragment();
                        fragmentState = FragmentState.NAVIGATION_PRIZES;
                        titleTextView.setText("Достижения\nи награды");
                    }
                    else if (selectedFragmentId == R.id.nav_statistics){
                        selectedFragment = new StatisticsFragment();
                        fragmentState = FragmentState.NAVIGATION_STATISTICS;
                        titleTextView.setText("Статистика");
                    }
                    else if (selectedFragmentId == R.id.nav_habits){
                        selectedFragment = new HabitsFragment();
                        fragmentState = FragmentState.NAVIGATION_HABITS;
                        titleTextView.setText("Привычки");
                    }
                    else if (selectedFragmentId == R.id.nav_settings){
                        selectedFragment = new SettingsFragment();
                        fragmentState = FragmentState.NAVIGATION_SETTINGS;
                        titleTextView.setText("Настройки");
                    }

                    if (selectedFragment != null) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainerView2, selectedFragment)
                                .commit();
                    }
                    return true;
                }
            };

}
