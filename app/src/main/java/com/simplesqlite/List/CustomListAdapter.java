package com.simplesqlite.List;

import android.app.Activity;
import android.widget.BaseAdapter;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.simplesqlite.R;

/**
 * Created by fff on 08.12.2015.
 */
public class CustomListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Task> taskItems;

    public CustomListAdapter(Activity activity, List<Task> taskItems) {
        this.activity = activity;
        this.taskItems = taskItems;
    }

    @Override
    public int getCount() {
        return taskItems.size();
    }

    @Override
    public Object getItem(int location) {
        return taskItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView cost = (TextView) convertView.findViewById(R.id.cost);

        // getting movie data for the row
        Task m = taskItems.get(position);
        // title
        description.setText(m.getDescription());

        // rating
        cost.setText("Cost: " + String.valueOf(m.getCost()));

        return convertView;
    }
}
