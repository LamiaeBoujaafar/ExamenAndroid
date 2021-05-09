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
import com.example.examenandroid.model.QcmContract.Question.COLUMN_QUESTION
import com.example.examenandroid.model.QcmContract.Reponse.COLUMN_EST_CORRECTE
import com.example.examenandroid.model.QcmContract.Reponse.COLUMN_ID_QUESTION
import com.example.examenandroid.model.QcmContract.Reponse.COLUMN_REPONSE
import com.example.examenandroid.model.QcmContract.Reponse.TABLE_NAME_REPONSE


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

    //FONCTION POUR RECUPERER LES QUESTIONS SELON CHAPITRE
    fun recupererQuestionParChapitre(myUserDBHelper: QcmDBHelper,id_chapitre: Int): ArrayList<com.example.examenandroid.model.Question>{
        val db   = myUserDBHelper.readableDatabase
        val questions = java.util.ArrayList<com.example.examenandroid.model.Question>()
        val selection = "$COLUMN_ID_CHAPITRE = ?"
        val selectionArgs = arrayOf(id_chapitre.toString())
        val cursor = db.query(
                TABLE_NAME_QUESTION,
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
    fun recupererReponseParIdQuestion(myUserDBHelper: QcmDBHelper,id_question: Int):ArrayList<com.example.examenandroid.model.Reponse>{
        val db   = myUserDBHelper.readableDatabase
        val reponses = ArrayList<com.example.examenandroid.model.Reponse>()
        val selection = "$COLUMN_ID_QUESTION = ?"
        val selectionArgs = arrayOf(id_question.toString())
        val cursor = db.query(
                TABLE_NAME_REPONSE,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null,
        )
        with(cursor) {
            while (moveToNext()) {
                val id_reponse = getInt( getColumnIndexOrThrow( COLUMN_ID ) )
                val reponse_nom = getString( getColumnIndexOrThrow( COLUMN_REPONSE ) )
                val estCorrecte = getInt( getColumnIndexOrThrow( COLUMN_EST_CORRECTE ) ) > 0
                val id_question = getInt( getColumnIndexOrThrow( COLUMN_ID_QUESTION ) )
                val reponse = com.example.examenandroid.model.Reponse(id_reponse, reponse_nom,estCorrecte,id_question)
                reponses.add(reponse)
            }
            return reponses
        }
    }

    fun recupererQuestionReponse(myUserDBHelper: QcmDBHelper, id_chapitre :Int) : ArrayList<QuestionReponse>{
        val questionReponseTest = ArrayList<QuestionReponse>()
        val questions : ArrayList<com.example.examenandroid.model.Question> = recupererQuestionParChapitre(myUserDBHelper,id_chapitre)
        for(question in questions){
            val reponses : ArrayList<com.example.examenandroid.model.Reponse> = recupererReponseParIdQuestion(myUserDBHelper,question.id)
            var reponseCorrect = ""
            for (reponse in reponses){
                if(reponse.estCorrecte == true){
                    reponseCorrect = reponse.reponse.toString()
                }
            }
            val choixArray = arrayOf(reponses[0].reponse, reponses[1].reponse, reponses[2].reponse)
            val result = QuestionReponse(question.id,question.question, choixArray,reponseCorrect)
            questionReponseTest.add(result)
        }
        return questionReponseTest
    }

    //fonction pour inserer des question
    fun ajouterQuestion(myUserDBHelper: QcmDBHelper, question: com.example.examenandroid.model.Question) {
        val db = myUserDBHelper.writableDatabase
        val values = ContentValues()
        with( values ) {
            put(COLUMN_ID,question.id)
            put(COLUMN_QUESTION, question.question)
            put(COLUMN_ID_CHAPITRE, question.id_chapitre)
        }
        val  newRowId = db?.insert(TABLE_NAME_QUESTION, null, values)
    }

    //fonction pour inserer des reponses
    fun ajouterReponses(myUserDBHelper: QcmDBHelper, reponse: com.example.examenandroid.model.Reponse) {
        val db = myUserDBHelper.writableDatabase
        val values = ContentValues()
        with( values ) {
            put(COLUMN_ID,reponse.id)
            put(COLUMN_ID_QUESTION, reponse.id_question)
            put(COLUMN_REPONSE, reponse.reponse)
            put(COLUMN_EST_CORRECTE, reponse.estCorrecte)
        }
        val  newRowId = db?.insert(TABLE_NAME_REPONSE, null, values)
    }

}