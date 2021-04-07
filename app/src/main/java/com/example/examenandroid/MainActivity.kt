package com.example.examenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.examenandroid.databinding.ActivityMainBinding
import com.example.examenandroid.model.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val myDBHelper = QcmDBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val signInBtn = binding.signInBtn
        val username = binding.username.text.toString()
        val password = binding.password.text.toString()
        val users = DataManager.recupererUsers(myDBHelper)
        signInBtn.setOnClickListener {
//            Toast.makeText(this, username + " " + password, Toast.LENGTH_SHORT).show()
//            if(DataManager.authentication(username,password,users)){
//                val myIntent = Intent(this, SecondeActivity::class.java)
//                startActivity(myIntent)
//            }else{
//                //Toast.makeText(this, "mot de passe incorrecte", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, username + " 555 " + password, Toast.LENGTH_SHORT).show()
//            }
//            val myQcmDBHelper = QcmDBHelper(this)
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(1,"Introduction au développement Android avec Android Studio"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(2,"Introduction au langage Kotlin"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(3,"Cycle de vie d'une activité"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(4,"Les fragments"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(5,"Stockage et SQLite"))
            val myIntent = Intent(this, SecondeActivity::class.java)
            startActivity(myIntent)
        }

    }




}