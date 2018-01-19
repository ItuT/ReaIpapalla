package za.co.shushine.jaidenveeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView registerTextLink;
    Button loginButton;
    static final int REGISTER_REQUEST = 100;  // The request code
    static final int DASHBOARD_REQUEST = 101;  // The request code

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String userName = "nameKey";
    public static final String Email = "emailKey";

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.init();

    }

    private void init(){
        this.registerTextLink = (TextView) findViewById(R.id.Register);
        this.loginButton = (Button) findViewById(R.id.Login);
        this.username = (EditText) findViewById(R.id.emailLogin);
        sharedpreferences = getSharedPreferences(mypreference,
                getApplicationContext().MODE_PRIVATE);

        this.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get(v);
                String savedUsername = sharedpreferences.getString(userName, "");
                String savedEmail  = sharedpreferences.getString(Email, "");

                if(username.getText() != null && username.getText().length() > 0){
                    if(savedEmail.equals(username.getText().toString())){
                        Toast.makeText(getApplicationContext(), "YEP we have the email",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                        startActivityForResult(intent,DASHBOARD_REQUEST );
                    }else{
                        Toast.makeText(getApplicationContext(), "SORRY LOL",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        this.registerTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivityForResult(intent,REGISTER_REQUEST);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == REGISTER_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                // Do something with the contact here (bigger example below)
            }
        }
    }

    public void Get(View view) {

        if (sharedpreferences.contains(userName)) {
            Toast.makeText(getApplicationContext(), sharedpreferences.getString(userName, ""),
                    Toast.LENGTH_SHORT).show();
        }
        if (sharedpreferences.contains(Email)) {
            Toast.makeText(getApplicationContext(), sharedpreferences.getString(Email, ""),
                    Toast.LENGTH_SHORT).show();

        }
    }
}
