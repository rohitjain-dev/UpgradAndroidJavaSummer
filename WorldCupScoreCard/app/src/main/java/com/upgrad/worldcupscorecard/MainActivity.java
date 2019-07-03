package com.upgrad.worldcupscorecard;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDB;
    EditText editTextName,editTextSurname,editTextRuns,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DataBaseHelper(getApplicationContext());
        editTextName = (EditText)findViewById(R.id.editText_name);
        editTextSurname = (EditText)findViewById(R.id.editText_surname);
        editTextRuns = (EditText)findViewById(R.id.editText_Runs);
        editTextId = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData()
    {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Integer deleteRows  = myDB.deleteData(editTextId.getText().toString());
              if(deleteRows > 0)
              {
                  Toast.makeText(getApplicationContext(),"Data Delete",Toast.LENGTH_LONG).show();
              } else {
                  Toast.makeText(getApplicationContext(),"Data Not Found",Toast.LENGTH_LONG).show();
              }
            }
        });
    }

    public void  UpdateData()
    {
        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String runs = editTextRuns.getText().toString();
                boolean isUpdated = myDB.updateData(id,name,surname,runs);
                if (isUpdated == true)
                {
                    Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_LONG).show();
                } else  {
                    Toast.makeText(getApplicationContext(),"Data Not Updated",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData()
    {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String runs = editTextRuns.getText().toString();
                boolean isAdded = myDB.insertData(name,surname,runs);
                if (isAdded == true)
                {
                    Toast.makeText(getApplicationContext(),"Data Added",Toast.LENGTH_LONG).show();
                } else  {
                    Toast.makeText(getApplicationContext(),"Data Not Added",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll()
    {
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Cursor res = myDB.getAllValues();
               if(res.getCount() == 0)
               {
                   showMessage("Scorecard","No Data Found");
                   return;
               }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Id :"+ res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                    buffer.append("Surname :"+ res.getString(2)+"\n");
                    buffer.append("Runs :"+ res.getString(3)+"\n\n");
                }

                //show all data
                showMessage("Scorecard",buffer.toString());
            }
        });
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
