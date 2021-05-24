package com.example.mynote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynote.domain.Record;
import com.example.mynote.domain.RecordRepository;

import java.util.ArrayList;
import java.util.List;

public class ImportantAdapter extends RecyclerView.Adapter<ImportantAdapter.ImportantVH> {

    List<Record> records = new RecordRepository().getRecord();

    @NonNull
    @Override
    public ImportantVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record, parent, false);
        return new ImportantVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImportantVH holder, int position) {
        holder.title.setText((CharSequence) records.get(position));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    class ImportantVH extends RecyclerView.ViewHolder{

        TextView title ;

        public ImportantVH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.recordOne);
        }
    }


}
