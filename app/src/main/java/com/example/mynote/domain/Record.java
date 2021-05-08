package com.example.mynote.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Record implements Parcelable {
    @StringRes
    public int Heading;
    @StringRes
    public int FullRecord;

    public Record(int heading, int fullRecord) {
        Heading = heading;
        FullRecord = fullRecord;
    }


    protected Record(Parcel in) {
        Heading = in.readInt();
        FullRecord = in.readInt();
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };

    public int getFullRecord() {
        return FullRecord;
    }

    public int getHeading() {
        return Heading;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Heading);
        dest.writeInt(FullRecord);
    }
}
