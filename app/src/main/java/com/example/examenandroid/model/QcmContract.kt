package com.example.examenandroid.model

import android.provider.BaseColumns

object QcmContract {
    object Chapitre : BaseColumns {

        // Le nom de la table chapitre et les nom des colonnes
        const val TABLE_NAME_CHAPITRE = "chapitre"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_TITRE = "titre"

        const val CREATE_TABLE_CHAPITRE = "CREATE TABLE $TABLE_NAME_CHAPITRE(" +
                                        "${BaseColumns._ID} INTEGER PRIMARY KEY " +
                                        "$COLUMN_TITRE TEXT)"

        const val DROP_TABLE_CHAPITRE = "DROP TABLE IF EXISTS $TABLE_NAME_CHAPITRE"

    }

    object Reponse : BaseColumns {

        // Le nom de la table chapitre et les nom des colonnes
        const val TABLE_NAME_REPONSE = "reponse"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_ID_QUESTION = "id_question"
        const val  COLUMN_REPONSE = "reponse"
        const val  COLUMN_EST_CORRECTE = "est_correcte"

        const val CREATE_TABLE_REPONSE = "CREATE TABLE $TABLE_NAME_REPONSE(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_REPONSE TEXT," +
                "$COLUMN_EST_CORRECTE BOOLEAN," +
                " FOREIGN KEY ("+ COLUMN_ID_QUESTION+") REFERENCES " + Question.TABLE_NAME_QUESTION+ "(" + Question.COLUMN_ID + ") )"

        const val DROP_TABLE_REPONSE = "DROP TABLE IF EXISTS $TABLE_NAME_REPONSE"

    }
    object Question : BaseColumns {

        // Le nom de la table question et les nom des colonnes
        const val TABLE_NAME_QUESTION = "question"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_QUESTION = "question"
        const val  COLUMN_ID_CHAPITRE= "id_chapitre"

        const val CREATE_TABLE_QUESTION= "CREATE TABLE $TABLE_NAME_QUESTION(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_QUESTION TEXT" +
                " FOREIGN KEY ("+ COLUMN_ID_CHAPITRE+") REFERENCES " + Chapitre.TABLE_NAME_CHAPITRE+ "(" + Chapitre.COLUMN_ID + ") )"

        const val DROP_TABLE_QUESTION = "DROP TABLE IF EXISTS $TABLE_NAME_QUESTION"

    }
    object User : BaseColumns {

        // Le nom de la table utilisateur et les nom des colonnes
        const val TABLE_NAME_USER = "utilisateur"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_NOM = "nom"
        const val  COLUMN_MOT_DE_PASSE =  "motDePasse"
        const val  COLUMN_EMAIL =  "email"

        const val CREATE_TABLE_USER= "CREATE TABLE $TABLE_NAME_USER(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NOM TEXT" +
                "$COLUMN_MOT_DE_PASSE TEXT" +
                "$COLUMN_EMAIL TEXT"

        const val DROP_TABLE_USER = "DROP TABLE IF EXISTS $TABLE_NAME_USER"

    }


}