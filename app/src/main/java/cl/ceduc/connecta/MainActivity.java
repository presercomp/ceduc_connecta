package cl.ceduc.connecta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAcceder = (Button) findViewById(R.id.btn_ingresar);
        EditText txtUsuario = (EditText) findViewById(R.id.txt_usuario);
        EditText txtClave   = (EditText) findViewById(R.id.txt_clave);

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final String usuario = "admin";
                //final String clave = "12345";
                DbManager db = new DbManager(MainActivity.this);
                db.open();
                Cursor cursor = db.getUsers();
                if(cursor.moveToFirst()){
                    String usuarioDB = cursor.getString(0);
                    String claveDB = cursor.getString(1);
                    String usuarioFrm = txtUsuario.getText().toString();
                    String claveFrm = txtClave.getText().toString();
                    System.out.println(usuarioDB);
                    System.out.println(claveDB);
                    System.out.println(usuarioFrm);
                    System.out.println(claveFrm);
                    if(usuarioDB.trim().equals(usuarioFrm.trim()) && claveDB.trim().equals(claveFrm)){
                        System.out.println("USUARIO VALIDO");
                    } else {
                        Toast.makeText(MainActivity.this, "Usuario no válido", Toast.LENGTH_SHORT).show();
                    }
                }

                //if(txtUsuario.getText().equals(usuario) && txtClave.getText().equals(clave)){
                    // El usuario es valido
                //} else {
                //    Toast.makeText(MainActivity.this, "Usuario no válido", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }

    public void acceder(View view) {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
    }
}