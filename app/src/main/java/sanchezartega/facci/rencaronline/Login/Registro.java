package sanchezartega.facci.rencaronline.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import sanchezartega.facci.rencaronline.MapsActivity;
import sanchezartega.facci.rencaronline.R;
import sanchezartega.facci.rencaronline.listasimple.Servicios;

public class Registro extends AppCompatActivity {
Button registro;
EditText correo,clave,name,username,reclave,celular;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registro = (Button) findViewById(R.id.btnregistro);
        correo = (EditText) findViewById(R.id.Correo);
        clave= (EditText) findViewById(R.id.password);
        reclave = (EditText) findViewById(R.id.rpassword);
        name = (EditText) findViewById(R.id.nombres);
        username = (EditText) findViewById(R.id.apellidos);
        celular = (EditText) findViewById(R.id.telefono);

        mAuth = FirebaseAuth.getInstance();

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // registrar();

                // se genera la navegabilidad entre la actividad principal y la actividad de login
               Intent intent = new Intent(Registro.this, Servicios.class);
               startActivity(intent);
                finish();

            }
        });


    }
    /*
    private void registrar() {

        String email = correo.getText().toString().trim();
        String password = clave.getText().toString().trim();
        String repeatpassword = reclave.getText().toString().trim();
        String telefono = celular.getText().toString().trim();
        String nombres = name.getText().toString().trim();
        String apellidos = username.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(repeatpassword)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(nombres)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(apellidos)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(telefono)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("","ingresela porfavor");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("","createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }*/

    private void updateUI(Object o) {
        String email = correo.getText().toString().trim();
        String password = clave.getText().toString().trim();
        String repeatpassword = reclave.getText().toString().trim();
        String telefono = celular.getText().toString().trim();
        String nombres = name.getText().toString().trim();
        String apellidos = username.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(repeatpassword)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(nombres)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(apellidos)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(telefono)){
            Toast.makeText(this,"ingrese correo",Toast.LENGTH_LONG).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
}
