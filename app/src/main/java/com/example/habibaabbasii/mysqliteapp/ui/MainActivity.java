package com.example.habibaabbasii.mysqliteapp.ui;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.habibaabbasii.mysqliteapp.R;
import com.example.habibaabbasii.mysqliteapp.databinding.ActivityMainBinding;
import com.example.habibaabbasii.mysqliteapp.db.DataBaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    DataBaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        db=new DataBaseHelper(this);
      setOnClickButtons();

    }

    public void setOnClickButtons(){

        binding.btAdd.setOnClickListener(this);
        binding.btView.setOnClickListener(this);
        binding.btUpdate.setOnClickListener(this);
        binding.btDelete.setOnClickListener(this);



    }
//    public void AddData() {
//        binding.btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String Name = binding.etName.getText().toString();
//                String Email = binding.etEmail.getText().toString();
//                String Password = binding.etPassword.getText().toString();
//                if(Name.length() != 0 && Email.length() != 0 && Password.length() != 0){
//                    onAddData(Name,Email, Password);
//                    binding.etName.setText("");
//                    binding.etEmail.setText("");
//                    binding.etPassword.setText("");
//                }else{
//                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
    public void onClick(View arg0){
        switch (arg0.getId()){

            case R.id.btAdd:
              String Name = binding.etName.getText().toString();
                String Email = binding.etEmail.getText().toString();
                String Password = binding.etPassword.getText().toString();
                if(Name.length() != 0 && Email.length() != 0 && Password.length() != 0){
                    onAddData(Name,Email, Password);
                    binding.etName.setText("");
                    binding.etEmail.setText("");
                    binding.etPassword.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btView:

            {
                Intent intent = new Intent(MainActivity.this, ContentViewListActivity.class);

                startActivity(intent);

                break;
            }
            case R.id.btUpdate:

                int temp= binding.etID.getText().toString().length();
                if(temp>0){


                    int value=db.onUpdateData(binding.etID.getText().toString(),
                                                    binding.etName.getText().toString(),
                                                    binding.etEmail.getText().toString(),
                                                    binding.etPassword.getText().toString());
                    if(value>0){
                        Toast.makeText(this,"Data is Succesfully Updated !",Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();


                }
                else
                    Toast.makeText(this,"You Must Enter An ID to Update",Toast.LENGTH_LONG).show();


                break;

            case R.id.btDelete:

                int temp1 = binding.etID.getText().toString().length();
                if(temp1>0){

                    Integer value=db.onDelete(binding.etID.getText().toString());
                      if(value>0){
                          Toast.makeText(this,"Succesfully DELETED !",Toast.LENGTH_LONG).show();
                      }
                      else
                          Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_LONG).show();


                }
                else
                    Toast.makeText(this,"You Must Enter An ID to Update",Toast.LENGTH_LONG).show();

                break;



        }

    }
    public void onAddData(String firstName,String email, String password ){
        boolean insertData = db.addData(firstName,email,password);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

    }



