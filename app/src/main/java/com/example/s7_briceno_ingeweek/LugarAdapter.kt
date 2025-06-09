package com.example.s7_briceno_ingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LugarAdapter(private val lugares: List<Lugar>) :
    RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    class LugarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.txtLugar)
        val imagen: ImageView = itemView.findViewById(R.id.imgLugar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lugar, parent, false)
        return LugarViewHolder(view)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = lugares[position]
        holder.nombre.text = lugar.nombre
        holder.imagen.setImageResource(lugar.imagenResId)
    }

    override fun getItemCount(): Int = lugares.size

}