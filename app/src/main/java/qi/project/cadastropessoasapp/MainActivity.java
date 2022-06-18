package qi.project.cadastropessoasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import qi.project.cadastropessoasapp.database.DataBaseHelper;
import qi.project.cadastropessoasapp.models.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
        List<Person> personList = dataBaseHelper.listAllPerson();
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, activity_addPerson.class);
                startActivity(intent);
            }
        });
    }

}