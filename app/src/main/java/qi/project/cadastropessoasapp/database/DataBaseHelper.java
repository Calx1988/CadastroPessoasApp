package qi.project.cadastropessoasapp.database;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import qi.project.cadastropessoasapp.MainActivity;
import qi.project.cadastropessoasapp.models.Person;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String PERSON_TABLE = "PERSON_TABLE";
    public static final String COLUMN_PERSON_CPF = "PERSON_CPF";
    public static final String COLUMN_PERSON_NAME = "PERSON_NAME";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_SOCIAL_NAME = "SOCIAL_NAME";
    public static final String COLUMN_FATHER_CPF = "FATHER_CPF";
    public static final String COLUMN_MOTHER_CPF = "MOTHER_CPF";
    public static final String COLUMN_PERSON_INCOME = "PERSON_INCOME";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "person.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement= "CREATE TABLE " + PERSON_TABLE +
                " (" + COLUMN_PERSON_CPF + " TEXT PRIMARY KEY, " + COLUMN_PERSON_NAME + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_SOCIAL_NAME + " TEXT, " + COLUMN_FATHER_CPF + " TEXT,"
                + COLUMN_MOTHER_CPF + " TEXT, " + COLUMN_PERSON_INCOME + " REAL)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addPerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PERSON_CPF, person.getCpf());
        cv.put(COLUMN_PERSON_NAME, person.getName());
        cv.put(COLUMN_GENDER, person.getGender());
        cv.put(COLUMN_SOCIAL_NAME, person.getSocialName());
        cv.put(COLUMN_FATHER_CPF, person.getFatherCpf());
        cv.put(COLUMN_MOTHER_CPF, person.getMotherCpf());
        cv.put(COLUMN_PERSON_INCOME, person.getIncome());

        db.insert(PERSON_TABLE, null, cv);

        return true;
    }

    public List<Person> listAllPerson(){
        List<Person> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + PERSON_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            do{
                String personCpf = cursor.getString(0);
                String personName = cursor.getString(1);
                String personGender = cursor.getString(2);
                String personSocialName = cursor.getString(3);
                String personFatherCpf = cursor.getString(4);
                String personMotherCpf = cursor.getString(5);
                Double personIncome = cursor.getDouble(6);
                Person person = new Person();
                person.setCpf(personCpf);
                person.setName(personName);
                person.setGender(personGender);
                person.setSocialName(personSocialName);
                person.setFatherCpf(personFatherCpf);
                person.setMotherCpf(personMotherCpf);
                person.setIncome(personIncome);
                returnList.add(person);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public Person findPerson(String cpf){
        String queryString = "SELECT * FROM " + PERSON_TABLE + " WHERE " + COLUMN_PERSON_CPF + " LIKE(" + cpf + ")";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        Person person = new Person();
        if (cursor.moveToFirst()){
            do{
                String personCpf = cursor.getString(0);
                String personName = cursor.getString(1);
                String personGender = cursor.getString(2);
                String personSocialName = cursor.getString(3);
                String personFatherCpf = cursor.getString(4);
                String personMotherCpf = cursor.getString(5);
                Double personIncome = cursor.getDouble(6);
                person.setCpf(personCpf);
                person.setName(personName);
                person.setGender(personGender);
                person.setSocialName(personSocialName);
                person.setFatherCpf(personFatherCpf);
                person.setMotherCpf(personMotherCpf);
                person.setIncome(personIncome);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return person;
    }
}
