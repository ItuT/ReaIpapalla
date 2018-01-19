package za.co.shushine.jaidenveeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    public static final String mypreference = "mypref";
    public static final String userName = "nameKey";
    public static final String Email = "emailKey";

    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.init();
    }

    private void init(){

        name = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        registerButton = (Button) findViewById(R.id.registerButton);

         registerButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               
               Save(v);
               Toast.makeText(getApplicationContext(), "You have successfully registered. Yeah!!!",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                finish();
            }
          });

        sharedpreferences = getSharedPreferences(mypreference,
                getApplicationContext().MODE_PRIVATE);
        if (sharedpreferences.contains(userName)) {
            name.setText(sharedpreferences.getString(userName, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }


    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(userName, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        name.setText("");
        email.setText("");

    }

    public void Get(View view) {
        name = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        sharedpreferences = getSharedPreferences(mypreference,
                getApplicationContext().MODE_PRIVATE);

        if (sharedpreferences.contains(userName)) {
            name.setText(sharedpreferences.getString(userName, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));

        }
    }

}
