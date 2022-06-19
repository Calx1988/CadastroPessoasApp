package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import qi.project.cadastropessoasapp.database.DataBaseHelper;
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
                DataBaseHelper dataBaseHelper = new DataBaseHelper(activity_findPerson.this);
                Person person = dataBaseHelper.findPerson(txtParentCpf.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("cpf", person.getCpf());
                bundle.putSerializable("name", person.getName());
                bundle.putSerializable("gender", person.getGender());
                bundle.putSerializable("socialName", person.getSocialName());
                bundle.putSerializable("fatherCpf", person.getFatherCpf());
                bundle.putSerializable("motherCpf", person.getMotherCpf());
                bundle.putSerializable("income", person.getIncome());
                Toast.makeText(activity_findPerson.this, person.toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity_findPerson.this, activity_viewPerson.class);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
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