package com.example.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.adapter.ChapitreAdapter
import com.example.examenandroid.fragment.ChapitreFragment
import com.example.examenandroid.fragment.QcmQuestionFragment
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper

class SecondeActivity : AppCompatActivity(), ChapitreAdapter.ItemClicked{

    //private lateinit var binding : ActivitySecondeBinding
    val manager = this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconde)

        val frag = QcmQuestionFragment()

        val trans = manager.beginTransaction()
        val fragChapitre = ChapitreFragment()
        if(!fragChapitre.isAdded) {
            trans.add(R.id.conteneur, fragChapitre)
            trans.commit()
        }

//        manager.beginTransaction()
//                .show(manager.findFragmentById(R.id.chapitreFragment)!!)
//                .hide(manager.findFragmentById(R.id.fragment5)!!)
//                .commit()



    }


    override fun onItemClicked(chapitre: Chapitre) {
        Log.i("chapitre", chapitre.titre.toString())
        val frag = QcmQuestionFragment()

        val trans = manager.beginTransaction()
        val fragChapitre = ChapitreFragment()
        if(!frag.isAdded) {
            val myBundle = Bundle()
            myBundle.putParcelable("chapitre", chapitre)
            frag.arguments = myBundle
            trans.add(R.id.conteneur, frag)
            trans.addToBackStack(null)
            trans.commit()
        }
//
//        manager.beginTransaction()
//                .show(manager.findFragmentById(R.id.fragment5)!!)
//                .addToBackStack(null)
//                .commit()

        //findViewById<TextView>(R.id.fragment4TextView).text = chapitre.titre.toString()

    }



}