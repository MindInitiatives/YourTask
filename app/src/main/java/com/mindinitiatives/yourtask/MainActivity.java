package com.mindinitiatives.yourtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private TextView signup;
    private EditText email;
    private EditText pass;
    private Button btnLogIn;

    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Tw-Cen-Medium.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());


        setContentView(R.layout.activity_main);

        mAuth= FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() !=null)
        {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }

        mDialog=new ProgressDialog(this);

        signup=findViewById(R.id.signup_txt);
        email=findViewById(R.id.email_login);
        pass=findViewById(R.id.password_login);
        btnLogIn=findViewById(R.id.login_btn);
        TextView logintxt = findViewById(R.id.login_txt);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/BrushScriptCondensedItalic.TTF");
        logintxt.setTypeface(face);

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail=email.getText().toString().trim();
                String mPass=pass.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail))
                {
                    email.setError("Required Field...");
                    return;
                }
                if (TextUtils.isEmpty(mPass))
                {
                    pass.setError("Required Field...");
                    return;
                }

                mDialog.setMessage("Processing...");
                mDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail,mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Problem !!! Could not Sign you in", Toast.LENGTH_SHORT).show();
                            mDialog.dismiss();
                        }

                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
            }
        });
    }
}
