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

        //      Utilisation du binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //      recuperation des donnees entree par utilisateur
        val loginBtn = binding.loginBtn
        val emailInput = binding.emailInput
        val mdpInput = binding.mdpInput

        //      fonction pour recuperer tous les utilisateurs stocker dans bd
        val users = DataManager.recupererUsers(myDBHelper)

//        val qcmDBHelper = QcmDBHelper(this)

//        Remplissage de la base de donnees
//        FillDB.FillChapitre(qcmDBHelper)
//        FillDB.FillUser(qcmDBHelper)
//        FillDB.FillQuestion(qcmDBHelper)
//        FillDB.FillReponse(qcmDBHelper)
        loginBtn.setOnClickListener {


            val email = emailInput.text.toString()
            val mdp = mdpInput.text.toString()

            if(DataManager.authentication(email,mdp,users)){
                val myIntent = Intent(this, SecondeActivity::class.java)
                startActivity(myIntent)
                emailInput.text.clear()
                mdpInput.text.clear()

            }else{
                Toast.makeText(this, "mot de passe ou email incorrecte(s)", Toast.LENGTH_SHORT).show()
            }

        }

    }




}