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

        val loginBtn = binding.loginBtn
        val emailInput = binding.emailInput
        val mdpInput = binding.mdpInput
        //POUR AJOUTER USERS DANS BASE DE DONNEES
//        val myQcmHelper = QcmDBHelper(this)
//        DataManager.ajouterUser(myQcmHelper,User(1,"lamiae","lamiae","lamiae20ber@gmail.com"))
//        DataManager.ajouterUser(myQcmHelper,User(2,"sakhr","sakhr","sakhr@gmail.com"))

        val users = DataManager.recupererUsers(myDBHelper)
        loginBtn.setOnClickListener {
            val email = emailInput.text.toString()
            val mdp = mdpInput.text.toString()

            if(DataManager.authentication("lamiae20ber@gmail.com","lamiae",users)){
                val myIntent = Intent(this, SecondeActivity::class.java)
                startActivity(myIntent)
                emailInput.text.clear()
                mdpInput.text.clear()
            }else{
                Toast.makeText(this, "mot de passe ou email incorrecte(s)", Toast.LENGTH_SHORT).show()
            }
//            val myQcmDBHelper = QcmDBHelper(this)
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(1,"Introduction au développement Android avec Android Studio"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(2,"Introduction au langage Kotlin"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(3,"Cycle de vie d'une activité"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(4,"Les fragments"))
//            DataManager.ajouterChapitre(myQcmDBHelper, Chapitre(5,"Stockage et SQLite"))
//            val myIntent = Intent(this, SecondeActivity::class.java)
//            startActivity(myIntent)
        }

    }




}