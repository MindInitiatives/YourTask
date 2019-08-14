package com.mindinitiatives.yourtask.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mindinitiatives.yourtask.R;

public class NoteViewHolder {

    public static class myViewHolder extends RecyclerView.ViewHolder {

        View myView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            myView = itemView;
        }

        public void setTitle(String title) {
            TextView mTitle = myView.findViewById(R.id.title);
            mTitle.setText(title);
        }

        public void setNote(String note) {
            TextView mNote = myView.findViewById(R.id.note);
            mNote.setText(note);
        }

        public void setDate(String date) {
            TextView mDate = myView.findViewById(R.id.note);
            mDate.setText(date);
        }
    }
}
