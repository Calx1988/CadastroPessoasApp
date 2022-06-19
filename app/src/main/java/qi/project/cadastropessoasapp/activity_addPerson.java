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

public class activity_addPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        Button btnSavePerson = findViewById(R.id.btnSavePerson);
        btnSavePerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePerson(v);
            }
        });
    }

    public void savePerson(View view){
        EditText txtName = findViewById(R.id.txtName);
        EditText txtCpf = findViewById(R.id.txtCpf);
        RadioGroup rdGender = findViewById(R.id.rdGender);
        EditText txtSocialName = findViewById(R.id.txtSocialName);
        EditText txtIncome = findViewById(R.id.txtIncome);
        RadioButton rbtnOther = findViewById(R.id.rbtnOther);

        int selectedRadioGroupItem = rdGender.getCheckedRadioButtonId();

        RadioButton radioButton = findViewById(selectedRadioGroupItem);

        Person person;
        //optional values test

        try{
            person = new Person(txtCpf.getText().toString(),
                    txtName.getText().toString().toUpperCase(),
                    radioButton.getText().toString().toUpperCase());
            person.setIncome(Double.parseDouble(txtIncome.getText().toString()));
            if(rbtnOther.isChecked()){
                person.setSocialName(txtSocialName.getText().toString().toUpperCase());
            }
            DataBaseHelper dataBaseHelper = new DataBaseHelper(activity_addPerson.this);
            boolean success = dataBaseHelper.addPerson(person);
            Intent intent = new Intent(activity_addPerson.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(activity_addPerson.this, person.toString() + "\nSucesso: " + success, Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(activity_addPerson.this,
                    "Erro ao cadastrar a pessoa.\nVerifique os campos obrigatórios.",
                    Toast.LENGTH_SHORT).show();
        }


    }
}