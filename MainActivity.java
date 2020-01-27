package com.example.a4buttons;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Databasehelper2 myDb;
    EditText editName, editSurname, editMarks, editTextID;
    Button btnADdData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new Databasehelper2(this);
        btnviewAll= (Button)findViewById(R.id.buttonw1);

        myDb.updateData();
        viewAll();


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
                            buffer.append("Week: " + res.getString(0)+ "\n");
                            buffer.append("Food: " + res.getString(1)+ "\n");
                            buffer.append("Clothing: " + res.getString(2)+ "\n");
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
