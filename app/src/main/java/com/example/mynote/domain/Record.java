package com.example.mynote.domain;

import androidx.annotation.StringRes;

public class Record {
    @StringRes
    public int Heading;
    @StringRes
    public int FullRecord;

    public Record(int heading, int fullRecord) {
        Heading = heading;
        FullRecord = fullRecord;
    }


    public int getFullRecord() {
        return FullRecord;
    }

    public int getHeading() {
        return Heading;
    }
}
