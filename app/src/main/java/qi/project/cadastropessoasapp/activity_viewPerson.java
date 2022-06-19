package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import qi.project.cadastropessoasapp.models.Person;

public class activity_viewPerson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);
        Bundle newBundle = getIntent().getBundleExtra("bundle");
        Person person = new Person();
        person.setCpf(newBundle.getSerializable("cpf").toString());
        person.setName(newBundle.getSerializable("name").toString());
        person.setGender(newBundle.getSerializable("gender").toString());
        person.setSocialName(newBundle.getSerializable("socialName").toString());
        person.setFatherCpf(newBundle.getSerializable("fatherCpf").toString());
        person.setMotherCpf(newBundle.getSerializable("motherCpf").toString());
        person.setIncome(Double.parseDouble(newBundle.getSerializable("income").toString()));

        EditText txtPersonCpf = findViewById(R.id.txtPersonCpf);
        EditText txtPersonName = findViewById(R.id.txtPersonName);
        RadioGroup rdGender = findViewById(R.id.rdGender);
        int selectedRadioGroupItem = rdGender.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedRadioGroupItem);
        rdGender.setSelected(radioButton.isSelected());
        txtPersonCpf.setText(person.getCpf());
        txtPersonName.setText(person.getCpf());
        Toast.makeText(activity_viewPerson.this, person.toString(), Toast.LENGTH_SHORT).show();

    }
}