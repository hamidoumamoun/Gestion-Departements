package fr.formation.atlas_dept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSearch,etNoDept,etNom,etNomStd,etSurface,etDateCreation,etChefLieu,etUrlWiki,etNoRegion;
    Departement dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etChefLieu=findViewById(R.id.etChefLieu);
        etDateCreation=findViewById(R.id.etDateCreation);
        etNoDept=findViewById(R.id.etNoDept);
        etNom=findViewById(R.id.etNom);
        etNomStd=findViewById(R.id.etNomStd);
        etSurface=findViewById(R.id.etSurface);
        etUrlWiki=findViewById(R.id.etUrlWiki);
        etNoRegion=findViewById(R.id.etNoRegion);
        etSearch=findViewById(R.id.etSearch);

        dept=new Departement(this);


    }

    public void btSearch(View view)  {
        String numDept = etSearch.getText().toString();

        try {
            dept.select(numDept);
            etNoDept.setText(dept.getNoDept());
            etChefLieu.setText(dept.getChefLieu());
            etDateCreation.setText(dept.getDateCreation());
            etUrlWiki.setText(dept.getUrlWiki());
            etNom.setText(dept.getNom());
            etSurface.setText(String.valueOf(dept.getSurface()));
            etNoRegion.setText(String.valueOf(dept.getNoRegion()));
            etNomStd.setText(dept.getNomStd());
            etSearch.setEnabled(false);


        } catch (Exception e) {
            Toast.makeText(this,"Departement inconnus",Toast.LENGTH_LONG).show();
        }


    }

    public void btClear(View view) {
        etSearch.setEnabled(true);
        etSearch.setText("");
        etNoDept.setText("");
        etChefLieu.setText("");
        etDateCreation.setText("");
        etUrlWiki.setText("");
        etNom.setText("");
        etSurface.setText(String.valueOf(""));
        etNoRegion.setText(String.valueOf(""));
        etNomStd.setText("");
        dept=new Departement(this);


    }

    public void btDelete(View view) {
        try {
            dept.delete();
        } catch (Exception e) {
            Toast.makeText(this,"suppression impossible",Toast.LENGTH_LONG).show();        }
    }

    public void btInsert(View view) {
        dept.setDateCreation(etDateCreation.getText().toString());
        dept.setChefLieu(etChefLieu.getText().toString());
        dept.setNom(etNom.getText().toString());
        dept.setNoDept(etNoDept.getText().toString());
        dept.setNomStd(etNomStd.getText().toString());
        dept.setUrlWiki(etUrlWiki.getText().toString());
        dept.setNoRegion(Integer.parseInt(etNoRegion.getText().toString()));
        dept.setSurface(Integer.parseInt(etSurface.getText().toString()));
        try {
            dept.insert();
        } catch (Exception e) {
           Toast.makeText(this,"Departement deja dans la,liste",Toast.LENGTH_LONG).show();
        }

    }

    public void btUpdate(View view) {
        dept.setDateCreation(etDateCreation.getText().toString());
        dept.setChefLieu(etChefLieu.getText().toString());
        dept.setNom(etNom.getText().toString());
        dept.setNoDept(etNoDept.getText().toString());
        dept.setNomStd(etNomStd.getText().toString());
        dept.setUrlWiki(etUrlWiki.getText().toString());
        dept.setNoRegion(Integer.parseInt(etNoRegion.getText().toString()));
        dept.setSurface(Integer.parseInt(etSurface.getText().toString()));
        try {
            dept.update();
        } catch (Exception e) {
            Toast.makeText(this,"Update impossible",Toast.LENGTH_LONG).show();
        }

    }

    public void deleteDB(View view) {

    }
}
