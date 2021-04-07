package com.example.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenandroid.adapter.ChapitreAdapter
import com.example.examenandroid.databinding.ActivitySecondeBinding
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper

class SecondeActivity : AppCompatActivity(), ChapitreAdapter.ItemClicked {

    private lateinit var binding : ActivitySecondeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconde)

        val binding = ActivitySecondeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myDBHelper = QcmDBHelper(this)
        //val chapitres : ArrayList<Chapitre> = DataManager.recupererChapitre(myDBHelper)
        val chapitres : ArrayList<Chapitre> = ArrayList<Chapitre>()
        chapitres.add(Chapitre(1, "chapitre 1"))
        chapitres.add(Chapitre(2, "chapitre 2"))
        chapitres.add(Chapitre(3, "chapitre 3"))
        chapitres.add(Chapitre(4, "chapitre 4"))
        chapitres.add(Chapitre(5, "chapitre 5"))
        val recyclerViewChapitre = binding.recyclerViewChapitre

        recyclerViewChapitre.layoutManager = LinearLayoutManager(this)
        recyclerViewChapitre.adapter = ChapitreAdapter(this, chapitres)

    }

    override fun onItemClicked(chapitre: Chapitre) {
        Log.i("chapitre", chapitre.toString())
    }
}