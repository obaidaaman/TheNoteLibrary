package com.example.thenotelibrary.Activity.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thenotelibrary.Activity.MainActivity;
import com.example.thenotelibrary.Activity.UpdateNotesActivity;
import com.example.thenotelibrary.NotesEntity.Notes;
import com.example.thenotelibrary.R;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.notesViewHolder> {
    MainActivity mainActivity;
    List<Notes> notes;
    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity=mainActivity;
        this.notes=notes;
    }

    @NonNull
    @Override

    public NotesAdapter.notesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new notesViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.notesViewHolder holder, int position) {
        Notes noteDataOfPosition= notes.get(position);

        holder.title.setText(noteDataOfPosition.NotesTitle);
        holder.subtitle.setText(noteDataOfPosition.NotesSubtitle);
        holder.notes.setText(noteDataOfPosition.Notes);

        holder.itemView.setOnClickListener(v -> {
            Intent intent= new Intent(mainActivity, UpdateNotesActivity.class);

        intent.putExtra("id", noteDataOfPosition.id);
        intent.putExtra("title", noteDataOfPosition.NotesTitle);
        intent.putExtra("NotesData",noteDataOfPosition.Notes);
        intent.putExtra("Subtitle", noteDataOfPosition.NotesSubtitle);
        intent.putExtra("Date", noteDataOfPosition.NotesDate);
          mainActivity.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class notesViewHolder extends RecyclerView.ViewHolder {
      TextView title, subtitle, notes;

        public notesViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.notesTitle);
            subtitle=itemView.findViewById(R.id.subtitle);
            notes=itemView.findViewById(R.id.notes);
        }
    }
}
