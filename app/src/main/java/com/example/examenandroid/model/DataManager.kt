package com.example.examenandroid.model

import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_ID
import com.example.examenandroid.model.QcmContract.Chapitre.COLUMN_TITRE
import com.example.examenandroid.model.QcmContract.Chapitre.TABLE_NAME_CHAPITRE

class DataManager {

    //FONCTIONS POUR CHAPITRES

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
                val chapitreId = getInt( getColumnIndexOrThrow( COLUMN_ID ) )
                val chapitreTitle = getString( getColumnIndexOrThrow( COLUMN_TITRE ) )
                val chapitre = Chapitre(chapitreId, chapitreTitle)
                chapitres.add(chapitre)
            }
            return chapitres
        }
    }
}