package com.example.examenandroid.model
import android.content.ContentValues
import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_ID
import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_TITRE
import com.example.examenandroid.model.QcmContract.Chapitre.TABLE_NAME_CHAPITRE
import com.example.examenandroid.model.QcmContract.User.COLUMN_EMAIL
import com.example.examenandroid.model.QcmContract.User.COLUMN_MOT_DE_PASSE
import com.example.examenandroid.model.QcmContract.User.COLUMN_NOM
import com.example.examenandroid.model.QcmContract.User.TABLE_NAME_USER

object DataManager {

    //FONCTIONS POUR CHAPITRES
    //recuperer les chapitres

    fun recupererChapitre(myUserDBHelper: QcmDBHelper) : ArrayList<Chapitre> {
        val db   = myUserDBHelper.readableDatabase
        val chapitres = java.util.ArrayList<Chapitre>()
        val cursor = db.query(
            TABLE_NAME_CHAPITRE,
            null,
            null,
            null,
            null,
            null,
            null,
        )
        with(cursor) {
            while (moveToNext()) {
                val chapitreId = getInt( getColumnIndexOrThrow( "_id" ) )
                val chapitreTitle = getString( getColumnIndexOrThrow( COLUMN_TITRE ) )
                val chapitre = Chapitre(chapitreId, chapitreTitle)
                chapitres.add(chapitre)
            }
            return chapitres
        }
    }
    //Ajouter chapitre

    fun ajouterChapitre(myUserDBHelper: QcmDBHelper, chapitre: Chapitre) {
        val db = myUserDBHelper.writableDatabase
        val values = ContentValues()
        with( values ) {
            put(COLUMN_ID,chapitre.id)
            put(COLUMN_TITRE, chapitre.titre)
        }
        val  newRowId = db?.insert(TABLE_NAME_CHAPITRE, null, values)
    }

    //FONCTIONS POUR USERS
    //fonction qui recupere les utilisateurs
    fun recupererUsers(myUserDBHelper: QcmDBHelper) : ArrayList<User> {
        val db   = myUserDBHelper.readableDatabase
        val users = java.util.ArrayList<User>()
        val cursor = db.query(
            TABLE_NAME_USER,
            null,
            null,
            null,
            null,
            null,
            null,
        )
        with(cursor) {
            while (moveToNext()) {
                val userId = getInt( getColumnIndexOrThrow( "_id" ) )
                val usernom = getString( getColumnIndexOrThrow( COLUMN_NOM ) )
                val usermdp = getString( getColumnIndexOrThrow( COLUMN_MOT_DE_PASSE ) )
                val useremail = getString( getColumnIndexOrThrow( COLUMN_EMAIL ) )
                val user = User(userId, usernom,usermdp,useremail)
                users.add(user)
            }
            return users
        }
    }
    //ajouter users

    fun ajouterUser(myUserDBHelper: QcmDBHelper, user: User) {
        val db = myUserDBHelper.writableDatabase
        val values = ContentValues()
        with( values ) {
            put(COLUMN_ID,user.id)
            put(COLUMN_NOM, user.nom )
            put(COLUMN_MOT_DE_PASSE, user.motDePasse)
            put(COLUMN_EMAIL, user.email)
        }
        val  newRowId = db?.insert(TABLE_NAME_USER, null, values)
    }
    //fonction pour authentication

    fun authentication( email :String ,motDePasse : String ,users : ArrayList<User>) : Boolean {
        for(item in users) {
            if(email == item.email && motDePasse == item.motDePasse){
                return true;
            }
        }
        return false;
    }
}