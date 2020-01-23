package com.example.sqliteapp;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editTextID;
    Button btnADdData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);

        editName= (EditText)findViewById(R.id.editText_name);
        editSurname= (EditText)findViewById(R.id.editText_surname);
        editMarks= (EditText)findViewById(R.id.editText_Marks);
        editTextID = (EditText)findViewById(R.id.editText_id);
        btnADdData= (Button)findViewById(R.id.button_add);
        btnviewAll= (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdataData();
        DeleteData();

    }
    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextID.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdataData(){
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updatedata(editTextID.getText().toString(),
                                editName.getText().toString(),
                                editSurname.getText().toString(), editMarks.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void AddData(){
        btnADdData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted = myDb.insertData(editTextID.getText().toString(), editName.getText().toString(),
                                editSurname.getText().toString(),
                                editMarks.getText().toString());
                       if (isInserted == true)
                           Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res= myDb.getAllData();
                        if (res.getCount() == 0){
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Day: " + res.getString(0)+ "\n");
                            buffer.append("Food: " + res.getString(1)+ "\n");
                            buffer.append("Transportation: " + res.getString(2)+ "\n");
                            buffer.append("Other: " + res.getString(3)+ "\n\n");
                        }

                        //Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
