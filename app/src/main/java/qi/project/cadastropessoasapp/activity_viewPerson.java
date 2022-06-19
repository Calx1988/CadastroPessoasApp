package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import qi.project.cadastropessoasapp.database.DataBaseHelper;
import qi.project.cadastropessoasapp.models.Person;

public class activity_viewPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);
        Bundle newBundle = getIntent().getBundleExtra("bundle");
        EditText txtPersonCpf = findViewById(R.id.txtPersonCpf);
        EditText txtPersonName = findViewById(R.id.txtPersonName);
        EditText txtPersonIncome = findViewById(R.id.txtPersonIncome);
        EditText txtPersonSocialName = findViewById(R.id.txtPersonSocialName);

        RadioGroup rdGender = findViewById(R.id.rdGender);
        RadioButton rdbMale = findViewById(R.id.rdbMale);
        RadioButton rdbFemale = findViewById(R.id.rdbFemale);
        RadioButton rdbOther = findViewById(R.id.rdbOther);

        txtPersonCpf.setText(newBundle.getSerializable("cpf").toString());
        txtPersonName.setText(newBundle.getSerializable("name").toString());
        txtPersonIncome.setText(newBundle.getSerializable("income").toString());

        String selectedRadioGroupItem = newBundle.getSerializable("gender").toString();
        if(rdbMale.getText().toString().toUpperCase().equals(selectedRadioGroupItem)){
            rdbMale.setChecked(true);
        }else if(rdbFemale.getText().toString().toUpperCase().equals(selectedRadioGroupItem)){
            rdbFemale.setChecked(true);
        }else {
            rdbOther.setChecked(true);
        }

        if(!rdbOther.isChecked()) {
            txtPersonSocialName.setVisibility(View.GONE);
        }else {
            txtPersonSocialName.setVisibility(View.VISIBLE);
            txtPersonSocialName.setText(newBundle.getSerializable("socialName").toString());
        }

        Button btnReturnList = findViewById(R.id.btnReturnList);
        btnReturnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(activity_viewPerson.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnDeletePerson = findViewById(R.id.btnDeletePerson);
        btnDeletePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(activity_viewPerson.this);
                boolean success = dataBaseHelper.deletePerson(newBundle.getSerializable("cpf").toString());
                if(success){
                    Toast.makeText(activity_viewPerson.this, "Pessoa excluída com sucesso.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activity_viewPerson.this, "Falha na exclusão.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}