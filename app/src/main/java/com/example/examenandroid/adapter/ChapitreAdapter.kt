package com.example.examenandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenandroid.R
import com.example.examenandroid.SecondeActivity
import com.example.examenandroid.model.Chapitre

class ChapitreAdapter(context: SecondeActivity, private val chapitres: ArrayList<Chapitre>) : RecyclerView.Adapter<ChapitreAdapter.ViewHolder>() {

    var myActivity: ItemClicked = context
    interface ItemClicked {
        fun onItemClicked(chapitre: Chapitre)
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val idChapitre:TextView = itemView.findViewById(R.id.idChapitreText)
        val titreChapitre:TextView = itemView.findViewById(R.id.titreChapitreText)

        init {
            itemView.setOnClickListener { view -> myActivity.onItemClicked(view.tag as Chapitre) }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.activity_item_chapitre, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.idChapitre.text = chapitres[position].id.toString()
        viewHolder.titreChapitre.text = chapitres[position].titre
        viewHolder.itemView.tag = chapitres[position]
    }

    override fun getItemCount(): Int {
        return chapitres.size
    }
}