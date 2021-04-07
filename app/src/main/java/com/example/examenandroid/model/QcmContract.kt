package com.example.examenandroid.model

import android.provider.BaseColumns

object QcmContract {
    object Chapitre : BaseColumns {

        // Le nom de la table chapitre et les nom des colonnes
        const val TABLE_NAME_CHAPITRE = "chapitre"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_NOM = "nom"

        const val CREATE_TABLE_CHAPITRE = "CREATE TABLE $TABLE_NAME_CHAPITRE(" +
                                        "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                                        "$COLUMN_NOM TEXT)"

        const val DROP_TABLE_CHAPITRE = "DROP TABLE IF EXISTS $TABLE_NAME_CHAPITRE"

    }

    object Reponse : BaseColumns {

        // Le nom de la table chapitre et les nom des colonnes
        const val TABLE_NAME_REPONSE = "reponse"
        const val  COLUMN_ID = "_id"
        const val  COLUMN_ID_QUESTION = "id_question"
        const val  COLUMN_REPONSE = "reponse"
        const val  COLUMN_EST_CORRECTE = "est_correct"

        const val CREATE_TABLE_REPONSE = "CREATE TABLE $TABLE_NAME_REPONSE(" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_REPONSE TEXT," +
                "$COLUMN_EST_CORRECTE BOOLEAN," +
                " FOREIGN KEY ("+ COLUMN_ID_QUESTION+") REFERENCES " + Chapitre.TABLE_NAME_CHAPITRE+ "(" + Chapitre.COLUMN_ID + ") )"

        const val DROP_TABLE_REPONSE = "DROP TABLE IF EXISTS $TABLE_NAME_REPONSE"

    }


}