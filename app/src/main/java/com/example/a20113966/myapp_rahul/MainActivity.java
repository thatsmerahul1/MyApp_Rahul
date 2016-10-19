package com.example.a20113966.myapp_rahul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName,etPassword;
    private Button btnSubmit;
    private String userName="", password="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

//        etUserName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if(charSequence.toString().matches("([a-zA-Z0-9]+[_])* "))
//                    userName = userName+charSequence;
//                else {
//                    etUserName.setText(userName);
//                    Toast.makeText(MainActivity.this, "Please enter vaild value!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.btnSubmit  :

                if(vaildateCredentials(etUserName.getText().toString(), etPassword.getText().toString()))
                {
                    Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    i.putExtra("userName", etUserName.getText().toString());
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong username/password.", Toast.LENGTH_SHORT).show();
                }
                break;

            default :
                break;
        }
    }

    private boolean isAlphaNumberic(String s)
    {
        if(s!=null && !s.isEmpty())
            return s.matches("^.*[^a-zA-Z0-9 ].*$");
        else
            return false;
    }

    private boolean vaildateCredentials(String userName, String password)
    {
        boolean status = false;

        if(password!= null && isAlphaNumberic(password))
        {

            if (userName != null && userName.toCharArray().length >= 6) {
                if (password.toCharArray().length >= 6) {
                    if (userName.equalsIgnoreCase("rahuladmin") && password.equals("password@123")) {
                        status = true;
                        Toast.makeText(MainActivity.this, "Succesfully logged-In.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        btnSubmit.setClickable(false);
                    }

                } else {
                    Toast.makeText(MainActivity.this, "Password should be atleast 6 charecters.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Username should be atleast 6 charecters.", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(MainActivity.this, "Password should be alphanumeric.", Toast.LENGTH_SHORT).show();
        }
        return status;
    }

}
