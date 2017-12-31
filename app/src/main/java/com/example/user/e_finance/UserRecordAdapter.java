package com.example.user.e_finance;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KD on 12/31/2017.
 */

public class UserRecordAdapter extends ArrayAdapter<UserRecord> {
    public UserRecordAdapter(Activity context, int resource, List<UserRecord> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserRecord userRecord = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_record, parent, false);
        }

        TextView textViewName, textViewEmail;

        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        textViewName.setText("Name:" + userRecord.getName());
        textViewEmail.setText("Email:" + userRecord.getEmail());

        return convertView;
    }
}
