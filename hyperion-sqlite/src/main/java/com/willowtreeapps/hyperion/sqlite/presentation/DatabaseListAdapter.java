package com.willowtreeapps.hyperion.sqlite.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.willowtreeapps.hyperion.sqlite.R;
import com.willowtreeapps.hyperion.sqlite.presentation.tables.TablesListActivity;

import java.util.List;

class DatabaseListAdapter extends RecyclerView.Adapter<DatabaseListAdapter.DatabaseItemViewHolder> {

    private final List<String> databaseNames;

    public DatabaseListAdapter(List<String> databaseNames) {
        this.databaseNames = databaseNames;
    }

    @NonNull
    @Override
    public DatabaseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hsql_database_file_viewholder, parent, false);
        return new DatabaseItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseItemViewHolder holder, int position) {
        holder.bind(databaseNames.get(position));
    }

    @Override
    public int getItemCount() {
        return databaseNames.size();
    }

    static class DatabaseItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private final TextView name;

        private String databaseName;

        DatabaseItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.hsql_db_name);
        }

        void bind(String dbName) {
            this.databaseName = dbName;
            name.setText(dbName);
        }

        @Override
        public void onClick(View v) {
            TablesListActivity.startActivity(v.getContext(), databaseName);
        }
    }
}
