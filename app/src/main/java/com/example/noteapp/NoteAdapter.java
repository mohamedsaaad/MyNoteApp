package com.example.noteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.database.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<Note> myNotes;

    public NoteAdapter(List<Note> myNotes) {
        this.myNotes = myNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=myNotes.get(position);
        holder.titleOfRec.setText(note.getTitle());
        holder.timeOfRec.setText(note.getTime());
    }

    @Override
    public int getItemCount() {
        if(myNotes==null) return 0;
        return myNotes.size();
    }

    public void modifyData(List<Note> myNotes){
        this.myNotes=myNotes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleOfRec;
        TextView timeOfRec;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleOfRec=itemView.findViewById(R.id.homeActivityTitle);
            timeOfRec=itemView.findViewById(R.id.homeActivityTime);
        }
    }
}
