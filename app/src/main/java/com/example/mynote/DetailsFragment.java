package com.example.mynote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynote.domain.Record;

public class DetailsFragment  extends Fragment {

    private static final String ARG_RECORD = "ARG_RECORD";

    public static DetailsFragment newInstance(Record record){
        DetailsFragment fragment = new DetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_RECORD, record);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = view.findViewById(R.id.record);
        EditText editText = view.findViewById(R.id.description);

        Record record = getArguments().getParcelable(ARG_RECORD);
        textView.setText(record.getHeading());
        editText.setText(record.getFullRecord());
    }
}
