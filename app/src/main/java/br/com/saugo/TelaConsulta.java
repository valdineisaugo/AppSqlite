package br.com.saugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TelaConsulta extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);
        //Gerar uma conexão ao Firebase
        database = FirebaseDatabase.getInstance();
        //Acesso ao local contendo dados
        reference = database.getReference();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

    }

    public void listar(View v){
        /*
        //Gerar uma conexão ao Firebase
        database = FirebaseDatabase.getInstance();
        //Acesso ao local contendo dados
        reference = database.getReference();
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

         */
    }
}









