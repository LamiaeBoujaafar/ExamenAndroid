package com.example.examenandroid.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examenandroid.model.QcmContract.Chapitre.CREATE_TABLE_CHAPITRE
import com.example.examenandroid.model.QcmContract.Chapitre.DROP_TABLE_CHAPITRE
import com.example.examenandroid.model.QcmContract.Reponse.CREATE_TABLE_REPONSE
import com.example.examenandroid.model.QcmContract.Reponse.DROP_TABLE_REPONSE

class QcmDBHelper(context: Context) :SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){
    companion object {
        const val DATABASE_NAME    = "qcmdb.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL( CREATE_TABLE_CHAPITRE )
        db?.execSQL( CREATE_TABLE_REPONSE )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL( DROP_TABLE_CHAPITRE )
        db?.execSQL(DROP_TABLE_REPONSE )
    }
}