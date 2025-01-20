package com.enka.kolbaskavlavashe.activity.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import com.enka.kolbaskavlavashe.R;
import com.enka.kolbaskavlavashe.enums.Category;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewTraitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewTraitFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View selectedView;

    private boolean isMondayFrameLayoutSelected, isTuesdayFrameLayoutSelected,
            isWednesdayFrameLayoutSelected, isThursdayFrameLayoutSelected, isFridayFrameLayoutSelected,
            isSaturdayFrameLayoutSelected, isSundayFrameLayoutSelected;

    private Category selectedCategory;

    public NewTraitFragment() {

    }

    public static NewTraitFragment newInstance(String param1, String param2) {
        NewTraitFragment fragment = new NewTraitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_trait, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        NumberPicker daysNumberPicker = view.findViewById(R.id.daysNumberPicker);
//        daysNumberPicker.setWrapSelectorWheel(true);
//        daysNumberPicker.setMinValue(1);
//        daysNumberPicker.setMaxValue(31);
        SeekBar seekBar = view.findViewById(R.id.starsSeekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView starsRewardTextView = view.findViewById(R.id.starsRewardTextView);
                FrameLayout starsRewardFrameLayout = view.findViewById(R.id.starsRewardFrameLayout),
                        seekBarFiller = view.findViewById(R.id.seekBarFiller);
                starsRewardTextView.setText(String.valueOf(progress));
                double dp = view.getResources().getDisplayMetrics().density;
                int thumbX = seekBar.getThumb().getBounds().centerX(),
                        seekBarFillerWidth = (int)(((progress - 4) * 7 + 40) * dp);
                starsRewardFrameLayout.setX(seekBar.getX() + thumbX - (starsRewardFrameLayout.getWidth() / 2));
                seekBarFiller.setLayoutParams(new FrameLayout.LayoutParams(seekBarFillerWidth, seekBarFiller.getHeight()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        FrameLayout healthCategoryFrameLayout = view.findViewById(R.id.healthCategoryFrameLayout),
                hygieneCategoryFrameLayout = view.findViewById(R.id.hygieneCategoryFrameLayout),
                financeCategoryFrameLayout = view.findViewById(R.id.financeCategoryFrameLayout),
                educationCategoryFrameLayout = view.findViewById(R.id.educationCategoryFrameLayout),
                houseCategoryFrameLayout = view.findViewById(R.id.houseCategoryFrameLayout),
                hobbyCategoryFrameLayout = view.findViewById(R.id.hobbyCategoryFrameLayout);

        healthCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.HEALTH;
            }
        });
        hygieneCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.HYGIENE;
            }
        });
        financeCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.FINANCE;
            }
        });
        educationCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.EDUCATION;
            }
        });
        houseCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.HOUSE;
            }
        });
        hobbyCategoryFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCategoryViewInactive(selectedView);
                setCategoryViewActive(view);
                selectedView = view;
                selectedCategory = Category.HOBBY;
            }
        });

        FrameLayout mondayFrameLayout = view.findViewById(R.id.mondayNewTraitFrameLayout),
                tuesdayFrameLayout = view.findViewById(R.id.tuesdayNewTraitFrameLayout),
                wednesdayFrameLayout = view.findViewById(R.id.wednesdayNewTraitFrameLayout),
                thursdayFrameLayout = view.findViewById(R.id.thursdayNewTraitFrameLayout),
                fridayFrameLayout = view.findViewById(R.id.fridayNewTraitFrameLayout),
                saturdayFrameLayout = view.findViewById(R.id.saturdayNewTraitFrameLayout),
                sundayFrameLayout = view.findViewById(R.id.sundayNewTraitFrameLayout);

        mondayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMondayFrameLayoutSelected = !isMondayFrameLayoutSelected;
                if (isMondayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        tuesdayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTuesdayFrameLayoutSelected = !isTuesdayFrameLayoutSelected;
                if (isTuesdayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        wednesdayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isWednesdayFrameLayoutSelected = !isWednesdayFrameLayoutSelected;
                if (isWednesdayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        thursdayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isThursdayFrameLayoutSelected = !isThursdayFrameLayoutSelected;
                if (isThursdayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        fridayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFridayFrameLayoutSelected = !isFridayFrameLayoutSelected;
                if (isFridayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        saturdayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSaturdayFrameLayoutSelected = !isSaturdayFrameLayoutSelected;
                if (isSaturdayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });

        sundayFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSundayFrameLayoutSelected = !isSundayFrameLayoutSelected;
                if (isSundayFrameLayoutSelected){
                    view.setBackgroundResource(R.drawable.layout5);
                }
                else{
                    view.setBackground(null);
                }
            }
        });
    }

    private void setCategoryViewActive(View view){
        if (view == null) return;
        view.setBackgroundResource(R.drawable.layout4);
    }

    private void setCategoryViewInactive(View view){
        if (view == null) return;
        view.setBackground(null);
    }
}