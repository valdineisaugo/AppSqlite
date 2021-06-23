package br.com.saugo;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;
import database.DataBaseHelper;

public class MainActivity extends AppCompatActivity {
    String nome, cpf;
    Date dataCadastro;
    Double saldo;
    DataBaseHelper helper;
    Button btnSalvar;
    EditText editNome, editCpf, editSaldo;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definição dos views
        editCpf = findViewById(R.id.editCpf);
        editNome = findViewById(R.id.editNome);
        editSaldo = findViewById(R.id.editSaldo);
        btnSalvar = findViewById(R.id.btnSalvar);
        helper = new DataBaseHelper(this);
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
         //Ação de btnSalvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = editNome.getText().toString();
                dataCadastro = new Date();
                saldo = Double.parseDouble(editSaldo.getText().toString());
                cpf = editCpf.getText().toString();
                values.put("nome", nome);
                values.put("data_cadastro", dataCadastro.toString());
                values.put("cpf", cpf);
                values.put("saldo", saldo);
                long resultado = db.insert("cliente", null, values);
                if(resultado != -1)
                    Toast.makeText(MainActivity.this, "Registro Salvo", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Falha ao salvar", Toast.LENGTH_LONG).show();
            }
        });


        //Listar Registros após insert

        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, nome, cpf FROM cliente", null);
        if(cursor != null) {
            cursor.moveToFirst();
            for(int i = 0; i < cursor.getCount(); i++){
                System.out.println("ID: " + cursor.getInt(0));
                System.out.println("Nome: " + cursor.getString(1));
                System.out.println("Cpf: " + cursor.getString(2));
                cursor.moveToNext();
            }
        }

    }


}