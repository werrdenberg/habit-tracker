package com.enka.kolbaskavlavashe.activity.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.enka.kolbaskavlavashe.R;
import com.enka.kolbaskavlavashe.activity.constants.TextConstants;

import java.time.LocalDateTime;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StatisticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance(String param1, String param2) {
        StatisticsFragment fragment = new StatisticsFragment();
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
        return inflater.inflate(R.layout.fragment_statistics, container, false);
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        updateWeek(view);
        TextView citationTextView = view.findViewById(R.id.citationTextView),
                factTextView = view.findViewById(R.id.factTextView);
        citationTextView.setText(TextConstants.getRandomCitation());
        factTextView.setText(TextConstants.getRandomFact());
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void updateWeek(View view){
        LinearLayout mondayLinearLayout = view.findViewById(R.id.mondayStatisticsLinearLayout),
                tuesdayLinearLayout = view.findViewById(R.id.tuesdayStatisticsLinearLayout),
                wednesdayLinearLayout = view.findViewById(R.id.wednesdayStatisticsLinearLayout),
                thursdayLinearLayout = view.findViewById(R.id.thursdayStatisticsLinearLayout),
                fridayLinearLayout = view.findViewById(R.id.fridayStatisticsLinearLayout),
                saturdayLinearLayout = view.findViewById(R.id.saturdayStatisticsLinearLayout),
                sundayLinearLayout = view.findViewById(R.id.sundayStatisticsLinearLayout);

        TextView mondayDayTextView = view.findViewById(R.id.mondayStatisticsDayTextView),
                tuesdayDayTextView = view.findViewById(R.id.tuesdayStatisticsDayTextView),
                wednesdayDayTextView = view.findViewById(R.id.wednesdayStatisticsDayTextView),
                thursdayDayTextView = view.findViewById(R.id.thursdayStatisticsDayTextView),
                fridayDayTextView = view.findViewById(R.id.fridayStatisticsDayTextView),
                saturdayDayTextView = view.findViewById(R.id.saturdayStatisticsDayTextView),
                sundayDayTextView = view.findViewById(R.id.sundayStatisticsDayTextView);
        LocalDateTime today = LocalDateTime.now();
        switch (today.getDayOfWeek()){
            case MONDAY:
                mondayLinearLayout.setBackgroundResource(R.drawable.layout5);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.plusDays(2).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.plusDays(3).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.plusDays(4).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.plusDays(5).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(6).getDayOfMonth()));
                break;
            case TUESDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackgroundResource(R.drawable.layout5);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.plusDays(2).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.plusDays(3).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.plusDays(4).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(5).getDayOfMonth()));
                break;
            case WEDNESDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackgroundResource(R.drawable.layout5);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.minusDays(2).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.plusDays(2).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.plusDays(3).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(4).getDayOfMonth()));
                break;
            case THURSDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackgroundResource(R.drawable.layout5);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.minusDays(3).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.minusDays(2).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.plusDays(2).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(3).getDayOfMonth()));
                break;
            case FRIDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackgroundResource(R.drawable.layout5);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.minusDays(4).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.minusDays(3).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.minusDays(2).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(2).getDayOfMonth()));
                break;
            case SATURDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackgroundResource(R.drawable.layout5);
                sundayLinearLayout.setBackground(null);

                mondayDayTextView.setText(String.valueOf(today.minusDays(5).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.minusDays(4).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.minusDays(3).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.minusDays(2).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.plusDays(1).getDayOfMonth()));
                break;
            case SUNDAY:
                mondayLinearLayout.setBackground(null);
                tuesdayLinearLayout.setBackground(null);
                wednesdayLinearLayout.setBackground(null);
                thursdayLinearLayout.setBackground(null);
                fridayLinearLayout.setBackground(null);
                saturdayLinearLayout.setBackground(null);
                sundayLinearLayout.setBackgroundResource(R.drawable.layout5);

                mondayDayTextView.setText(String.valueOf(today.minusDays(6).getDayOfMonth()));
                tuesdayDayTextView.setText(String.valueOf(today.minusDays(5).getDayOfMonth()));
                wednesdayDayTextView.setText(String.valueOf(today.minusDays(4).getDayOfMonth()));
                thursdayDayTextView.setText(String.valueOf(today.minusDays(3).getDayOfMonth()));
                fridayDayTextView.setText(String.valueOf(today.minusDays(2).getDayOfMonth()));
                saturdayDayTextView.setText(String.valueOf(today.minusDays(1).getDayOfMonth()));
                sundayDayTextView.setText(String.valueOf(today.getDayOfMonth()));
                break;
        }
    }

}