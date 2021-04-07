package com.example.examenandroid.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examenandroid.model.QcmContract.Chapitre.CREATE_TABLE_CHAPITRE
import com.example.examenandroid.model.QcmContract.Chapitre.DROP_TABLE_CHAPITRE
import com.example.examenandroid.model.QcmContract.Question.CREATE_TABLE_QUESTION
import com.example.examenandroid.model.QcmContract.Question.DROP_TABLE_QUESTION
import com.example.examenandroid.model.QcmContract.Reponse.CREATE_TABLE_REPONSE
import com.example.examenandroid.model.QcmContract.Reponse.DROP_TABLE_REPONSE
import com.example.examenandroid.model.QcmContract.User.CREATE_TABLE_USER
import com.example.examenandroid.model.QcmContract.User.DROP_TABLE_USER

class QcmDBHelper(context: Context) :SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){
    companion object {
        const val DATABASE_NAME    = "qcmdb.db"
        const val DATABASE_VERSION = 1
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL( CREATE_TABLE_CHAPITRE )
        db?.execSQL( CREATE_TABLE_REPONSE )
        db?.execSQL( CREATE_TABLE_QUESTION )
        db?.execSQL( CREATE_TABLE_USER )
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL( DROP_TABLE_CHAPITRE )
        db?.execSQL(DROP_TABLE_REPONSE )
        db?.execSQL( DROP_TABLE_QUESTION )
        db?.execSQL(DROP_TABLE_USER )
    }
}