package com.example.habibaabbasii.mysqliteapp.ui;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.habibaabbasii.mysqliteapp.R;
import com.example.habibaabbasii.mysqliteapp.adapter.List_View_adapter;
import com.example.habibaabbasii.mysqliteapp.databinding.ActivityListContentViewBinding;
import com.example.habibaabbasii.mysqliteapp.db.DataBaseHelper;
import com.example.habibaabbasii.mysqliteapp.model.User;

import java.util.ArrayList;

public class ContentViewListActivity extends AppCompatActivity {


    DataBaseHelper db;
    ArrayList<User> userArrayList;
    User user;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_list_content_view);

        db=new DataBaseHelper(this);

        userArrayList=new ArrayList<User>();
        Cursor data=db.getAllData();



        if(data.getCount()==0)
            Toast.makeText(ContentViewListActivity.this,"The Database is empty.",Toast.LENGTH_SHORT).show();
        else {


            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3));
                userArrayList.add(user);
                //System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
                //System.out.println(userArrayList.get(i).getName());

            }

            List_View_adapter adapter= new List_View_adapter(ContentViewListActivity.this,R.layout.adapter_view,userArrayList);
            lv=(ListView)findViewById(R.id.lvUser);
          lv.setAdapter(adapter);


        }

      //  user= new User();
    }
}
