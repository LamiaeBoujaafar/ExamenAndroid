package com.example.examenandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.adapter.ChapitreAdapter
import com.example.examenandroid.fragment.ChapitreFragment
import com.example.examenandroid.fragment.QcmQuestionFragment
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper

class SecondeActivity : AppCompatActivity(), ChapitreAdapter.ItemClicked, QcmQuestionFragment.Ireset{

    //private lateinit var binding : ActivitySecondeBinding
    private val manager = this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconde)

        //      Ajouter le fragment qui affiche les chapitres a notre second activity
        val trans = manager.beginTransaction()
        val fragChapitre = ChapitreFragment()
        if(!fragChapitre.isAdded) {
            trans.add(R.id.conteneur, fragChapitre)
            trans.commit()
        }
    }


    override fun onItemClicked(chapitre: Chapitre) {
        Log.i("chapitre", chapitre.titre.toString())

        val qcmQuestionFragment = QcmQuestionFragment()

        val trans = manager.beginTransaction()
        if(!qcmQuestionFragment.isAdded) {
            val myBundle = Bundle()
            myBundle.putParcelable("chapitre", chapitre)
            qcmQuestionFragment.arguments = myBundle
            trans.add(R.id.conteneur, qcmQuestionFragment, "qcm")
            trans.addToBackStack(null)
            trans.commit()
        }

    }

    override fun reset() {
        val qcmQuestionFragment = manager.findFragmentByTag("qcm".toString())


        if(qcmQuestionFragment!!.isAdded) {
            val trans = manager.beginTransaction()

            trans.remove(qcmQuestionFragment!!)
            trans.commit()
            Log.i("resettt", "main")
            Log.i("resettt", qcmQuestionFragment!!.tag.toString())

        }
    }


}