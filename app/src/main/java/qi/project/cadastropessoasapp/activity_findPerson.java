package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import qi.project.cadastropessoasapp.models.Person;

public class activity_findPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_person);
        EditText txtParentCpf = findViewById(R.id.txtParentCpf);
        txtParentCpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public Person findPerson(String cpf){
        return null;
    }
}