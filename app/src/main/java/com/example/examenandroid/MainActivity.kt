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
        val users = DataManager.recupererUsers(myDBHelper)
        val qcmDBHelper = QcmDBHelper(this)
        loginBtn.setOnClickListener {
//            FillDB.FillChapitre(qcmDBHelper)
//            FillDB.FillUser(qcmDBHelper)
//            FillDB.FillQuestion(qcmDBHelper)
//            FillDB.FillReponse(qcmDBHelper)
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

        }

    }




}