package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import qi.project.cadastropessoasapp.models.Person;

public class activity_findPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_person);
        EditText txtParentCpf = findViewById(R.id.txtParentCpf);
        Button btnFindPerson = findViewById(R.id.btnFindPerson);
        Button btnCancelFind = findViewById(R.id.btnCancelFind);

        btnFindPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancelFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_findPerson.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}