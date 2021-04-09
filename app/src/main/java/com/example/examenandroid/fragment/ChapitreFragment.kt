package com.example.examenandroid.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.adapter.ChapitreAdapter
import com.example.examenandroid.model.Chapitre
import com.example.examenandroid.model.DataManager
import com.example.examenandroid.model.QcmDBHelper


class ChapitreFragment : Fragment(){
    var myView : View? = null
    var myAdapter:RecyclerView.Adapter<ChapitreAdapter.ViewHolder>? = null
    var recyclerViewChapitre : RecyclerView? = null
    var layoutManager : RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myDBHelper = this.activity?.let { QcmDBHelper(it) }
        val chapitres : ArrayList<Chapitre> = DataManager.recupererChapitre(myDBHelper!!)
        recyclerViewChapitre = myView?.findViewById(R.id.recyclerViewChapitre)

        layoutManager = LinearLayoutManager(this.activity)
        recyclerViewChapitre?.layoutManager = layoutManager
        myAdapter = ChapitreAdapter(this.activity, chapitres)
        recyclerViewChapitre?.adapter = myAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_chapitre, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDBHelper = this.activity?.let { QcmDBHelper(it) }
        val chapitres : ArrayList<Chapitre> = DataManager.recupererChapitre(myDBHelper!!)
        recyclerViewChapitre = myView?.findViewById(R.id.recyclerViewChapitre)

        layoutManager = LinearLayoutManager(this.activity)
        recyclerViewChapitre?.layoutManager = layoutManager
        myAdapter = ChapitreAdapter(this.activity, chapitres)
        recyclerViewChapitre?.adapter = myAdapter
    }

//    override fun onItemClicked(chapitre: Chapitre) {
//        Log.i("ero", "")
//        val manager = this.activity?.supportFragmentManager
//
//       if (manager != null) {
//            manager.beginTransaction()
//    //                .show(manager.findFragmentById(R.id.qcmFragment)!!)
//                    .commit()
//        }
//    }

}