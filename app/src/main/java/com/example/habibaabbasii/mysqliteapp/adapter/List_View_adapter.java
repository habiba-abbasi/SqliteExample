package com.example.habibaabbasii.mysqliteapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.habibaabbasii.mysqliteapp.R;
import com.example.habibaabbasii.mysqliteapp.model.User;

import java.util.ArrayList;

public class List_View_adapter extends ArrayAdapter<User> {

    private LayoutInflater inflater;
    private ArrayList<User> users;
    private int mResourceId;


    public List_View_adapter(@NonNull Context context, int resource,ArrayList<User> users) {
        super(context, resource,users);
        this.users=users;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mResourceId = resource;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(mResourceId, null);

        User user = users.get(position);

        if (user != null) {

            TextView Name = (TextView) convertView.findViewById(R.id.tvName);
            TextView Email = (TextView) convertView.findViewById(R.id.tvEmail);
            TextView password= (TextView) convertView.findViewById(R.id.tvPassword);

            if (Name != null) {
                Name.setText(user.getName());
            }
            if (Email != null) {
                Email.setText(user.getEmail());
            }
            if (password != null) {
                password.setText(user.getPassword());
            }
        }

        return convertView;
    }
}
