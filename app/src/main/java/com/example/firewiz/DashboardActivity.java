package com.example.firewiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firewiz.model.Question;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    TextView play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        play=(TextView)findViewById(R.id.play);

        //bottom navigation
        bottomNavigationView=findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.loginButton);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_create:
                        startActivity(new Intent(getApplicationContext(), CreateQuiz.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_play:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.action_history:
                        startActivity(new Intent(getApplicationContext(),Loginn.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    public void btn_showDialog(View view) {
        final AlertDialog.Builder alert=new AlertDialog.Builder(DashboardActivity.this);
        View mView =getLayoutInflater().inflate(R.layout.custom_dialog,null);
        final EditText txt_gamepin=(EditText)mView.findViewById(R.id.txt_gamepin);
        Button btn_cancel=(Button)mView.findViewById(R.id.btn_cancel);
        Button btn_ok=(Button)mView.findViewById(R.id.btn_ok);
        alert.setView(mView);
        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);
        btn_cancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                alertDialog.dismiss();;
            }


        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play.setText(txt_gamepin.getText().toString());


            }
        });
        alertDialog.show();
    }
}
