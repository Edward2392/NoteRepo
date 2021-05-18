package com.example.mynote;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mynote.domain.Record;
import com.example.mynote.domain.RecordRepository;

import java.util.List;


public class FirstFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public interface OnRecordClicked{
         void onRecordClicked(Record record);
    }

    private OnRecordClicked onRecordClicked;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnRecordClicked){
            onRecordClicked = (OnRecordClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onRecordClicked = null;
        super.onDetach();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Record> records = new RecordRepository().getRecord();

        LinearLayout recordList = view.findViewById(R.id.recordList);

        for (Record record : records) {

            View recordView = LayoutInflater.from(requireContext()).inflate(R.layout.record, recordList, false);

            recordView.setOnClickListener(v -> openRecordDetail(record));

           TextView textView = recordView.findViewById(R.id.recordOne);
           textView.setText(record.getHeading());

            EditText editText = recordView.findViewById(R.id.description);
            editText.setText(record.getFullRecord());

            recordList.addView(recordView);
        }

    }

    private void openRecordDetail(Record record) {
        if (onRecordClicked != null){
            onRecordClicked.onRecordClicked(record);
        }

    }
}