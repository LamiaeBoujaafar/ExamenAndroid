package com.example.examenandroid.model
import android.content.ContentValues
import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_ID
import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_TITRE
import com.example.examenandroid.model.QcmContract.Chapitre.TABLE_NAME_CHAPITRE
import com.example.examenandroid.model.QcmContract.Question.TABLE_NAME_QUESTION
import com.example.examenandroid.model.QcmContract.User.COLUMN_EMAIL
import com.example.examenandroid.model.QcmContract.User.COLUMN_MOT_DE_PASSE
import com.example.examenandroid.model.QcmContract.User.COLUMN_NOM
import com.example.examenandroid.model.QcmContract.User.TABLE_NAME_USER
import com.example.examenandroid.model.QcmContract.Question
import com.example.examenandroid.model.QcmContract.Question.COLUMN_ID_CHAPITRE
import com.example.examenandroid.model.QcmContract.Reponse


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
    //FONCTIONS POUR Question et les reponses
    //fonction qui recupere les questions avec leurs reponses

//    fun recupererQuestionReponse(myUserDBHelper: QcmDBHelper, id_chapitre :Int) : ArrayList<QuestionReponse> {
//        val db   = myUserDBHelper.readableDatabase
//        val question_reponses = java.util.ArrayList<QuestionReponse>()
//        val query = "SELECT" + Question.COLUMN_ID + " , " + Question.COLUMN_QUESTION + " , " + Question.COLUMN_ID_CHAPITRE +
//                " , " + Reponse.COLUMN_ID + " , " + Reponse.COLUMN_REPONSE + " , " + Reponse.COLUMN_EST_CORRECTE +
//                " FROM " + TABLE_NAME_QUESTION +
//                " JOIN " + Reponse.TABLE_NAME_REPONSE + " ON " +  Question.COLUMN_ID + " = " + Reponse.COLUMN_ID +
//                " WHERE " + Question.COLUMN_ID_CHAPITRE + " = ?"
//
//        val cursor = db.rawQuery(
//                query,
//                arrayOf(id_chapitre.toString())
//        )
//        with(cursor) {
//            while (moveToNext()) {
//                val question_id = getInt( getColumnIndexOrThrow( Question.COLUMN_ID  ) )
//                val question = getString( getColumnIndexOrThrow( Question.COLUMN_QUESTION ) )
//                val id_chapitre = getInt( getColumnIndexOrThrow( Question.COLUMN_ID_CHAPITRE ) )
//                val reponse_id = getInt( getColumnIndexOrThrow( Reponse.COLUMN_ID ) )
//                val reponse = getString( getColumnIndexOrThrow( Reponse.COLUMN_REPONSE ) )
//                val est_correcte = getInt( getColumnIndexOrThrow( Reponse.COLUMN_EST_CORRECTE ) ) > 0
//                val question_reponse = QuestionReponse(question_id, question,id_chapitre,reponse_id,reponse,est_correcte)
//                question_reponses.add(question_reponse)
//            }
//            return question_reponses
//        }
//    }

    //FONCTION POUR RECUPERER LES QUESTIONS SELON CHAPITRE

    fun recupererQuestionParChapitre(myUserDBHelper: QcmDBHelper,id_chapitre: Int): ArrayList<com.example.examenandroid.model.Question>{
        val db   = myUserDBHelper.readableDatabase
        val questions = java.util.ArrayList<com.example.examenandroid.model.Question>()
        val selection = "$COLUMN_ID_CHAPITRE Like ?"
        val selectionArgs = arrayOf(id_chapitre.toString())
        val cursor = db.query(
                TABLE_NAME_USER,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
        )
        with(cursor) {
            while (moveToNext()) {
                val id_question = getInt( getColumnIndexOrThrow( Question.COLUMN_ID ) )
                val question_nom = getString( getColumnIndexOrThrow(Question.COLUMN_QUESTION) )
                val id_chapitre = getInt( getColumnIndexOrThrow(COLUMN_ID_CHAPITRE) )
                val question = Question(id_question, question_nom,id_chapitre)
                questions.add(question)
            }
            return questions
        }
    }


}