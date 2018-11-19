package fr.formation.atlas_dept;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.EmptyStackException;

public class Departement {
   private String noDept,nom,nomStd,dateCreation,chefLieu,urlWiki;
    private int noRegion,surface;

    private SQLiteDatabase db;

    public Departement(Context c) {
        DbGeo dbGeo = (DbGeo.getInstance(c));
        db = dbGeo.getWritableDatabase();

    }

    public Departement(Context c, String no){
    this.noDept = no;
    }

    public void select(String no) throws Exception{
        Exception e= new SQLException();
        String critere= "no_dept='"+no+"'";
        String colonnes[]={"no_dept","no_region","nom","nom_std","surface","date_creation","chef_lieu","url_wiki"};
        Cursor cursor = db.query("departements", colonnes, critere, null, null, null, null);

       if (cursor.getCount()>0 ) {
           cursor.moveToFirst();
         setNoDept( cursor.getString(0));
        setNoRegion(Integer.parseInt(cursor.getString(1)));
        setNom(cursor.getString(2));
        setNomStd(cursor.getString(3));
        setSurface(Integer.parseInt(cursor.getString(4)));
        setChefLieu(cursor.getString(6));
        setUrlWiki(cursor.getString(7));
        setDateCreation(cursor.getString(5));}
        else {
           throw e;
       }



       }

    public void delete()throws Exception{

     if(!noDept.isEmpty()){
            String critere ="id="+noDept;
            db.delete("departements",critere,null);}


       else{

            throw new EmptyStackException();
        }


    }


    public void update()throws Exception{
        if(!noDept.isEmpty()){
        ContentValues values = new ContentValues();
        values.put("no_dept",noDept);
        values.put("no_region",noRegion);
        values.put("nom",nom);
        values.put("nom_std",nomStd);
        values.put("surface",surface);
        values.put("date_creation",dateCreation);
        values.put("chef_lieu",chefLieu);
        values.put("url_wiki",urlWiki);
        db.update("departements",values,null,null);}
        else{

            throw new EmptyStackException();
        }






    }
    public void insert()throws Exception{

        if(!noDept.isEmpty()){

            try{

            ContentValues values = new ContentValues();
            values.put("no_dept",noDept);
            values.put("no_region",noRegion);
            values.put("nom",nom);
            values.put("nom_std",nomStd);
            values.put("surface",surface);
            values.put("date_creation",dateCreation);
            values.put("chef_lieu",chefLieu);
            values.put("url_wiki",urlWiki);
            db.insert("departements","",values);}
            catch(Exception ex){
                throw ex;
            }

            }
        else{
            throw new EmptyStackException();
        }

    }






    public String getNoDept() {
        return noDept;
    }

    public void setNoDept(String noDept) {
        this.noDept = noDept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomStd() {
        return nomStd;
    }

    public void setNomStd(String nomStd) {
        this.nomStd = nomStd;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getChefLieu() {
        return chefLieu;
    }

    public void setChefLieu(String chefLieu) {
        this.chefLieu = chefLieu;
    }

    public String getUrlWiki() {
        return urlWiki;
    }

    public void setUrlWiki(String urlWiki) {
        this.urlWiki = urlWiki;
    }

    public int getNoRegion() {
        return noRegion;
    }

    public void setNoRegion(int noRegion) {
        this.noRegion = noRegion;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }
}
