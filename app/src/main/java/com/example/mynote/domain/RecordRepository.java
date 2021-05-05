package com.example.mynote.domain;

import com.example.mynote.R;

import java.util.ArrayList;
import java.util.List;

public class RecordRepository {

    public List<Record> getRecord() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(R.string.Heading, R.string.FullRecord1));
        records.add(new Record(R.string.Heading2, R.string.FullRecord2));
        records.add(new Record(R.string.Heading3, R.string.FullRecord3));
        return records;
    }
}
