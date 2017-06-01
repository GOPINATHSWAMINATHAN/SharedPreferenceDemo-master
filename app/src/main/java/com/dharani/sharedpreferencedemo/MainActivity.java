package com.dharani.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tName, tContact, tEmail, tLocation;
    EditText etName, etContact, etEmail, etLocation;
    Button btSave, btDisplay;
    TextView tvResult;
    String stName, stContact, stEmail, stLocation;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tName = (TextInputLayout) findViewById(R.id.textInputLayout);
        tContact = (TextInputLayout) findViewById(R.id.textInputLayout2);
        tEmail = (TextInputLayout) findViewById(R.id.textInputLayout3);
        tLocation = (TextInputLayout) findViewById(R.id.textInputLayout4);

        etName = (EditText) findViewById(R.id.et_name);
        etContact = (EditText) findViewById(R.id.et_contact);
        etEmail = (EditText) findViewById(R.id.et_emailID);
        etLocation = (EditText) findViewById(R.id.et_location);

        tvResult = (TextView) findViewById(R.id.textView_display);

        btSave = (Button) findViewById(R.id.button_Save);
        btDisplay = (Button) findViewById(R.id.button_Display);



        sharedPreferences = getSharedPreferences("Mypreferences", Context.MODE_PRIVATE);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stName = etName.getText().toString();
                stContact = etContact.getText().toString();
                stEmail = etEmail.getText().toString();
                stLocation = etLocation.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name",stName);
                editor.putString("Contact",stContact);
                editor.putString("Email",stEmail);
                editor.putString("Location",stLocation);
                Toast.makeText(getApplicationContext(),"the values are"+stName+""+stContact,Toast.LENGTH_LONG).show();
                if(editor.commit())
                {
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
//                    editor.clear();
//                    editor.commit();
            }}
        });

        btDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared=getSharedPreferences("Mypreferences",MODE_PRIVATE);
                String n,c,e,l;
                n=shared.getString("Name","");
                c=shared.getString("Contact","");
                e=shared.getString("Email","");
                l=shared.getString("Location","");
                Log.d("getting All from",""+shared.getAll());
                Toast.makeText(MainActivity.this, "Name is "+n, Toast.LENGTH_SHORT).show();
                tvResult.setText(n +"\n"+ c + "\n"+ e + "\n"+l);

            }
        });
    }
}
