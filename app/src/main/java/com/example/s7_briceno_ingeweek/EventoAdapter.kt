package com.example.s7_briceno_ingeweek

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventoAdapter(private var actividades: List<Actividad>) :
    RecyclerView.Adapter<EventoAdapter.EventoViewHolder>() {

    class EventoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hora: TextView = itemView.findViewById(R.id.txtHora)
        val titulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val lugar: TextView = itemView.findViewById(R.id.txtLugar)
        val ponente: TextView = itemView.findViewById(R.id.txtPonente)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return EventoViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val actividad = actividades[position]
        holder.hora.text = actividad.hora
        holder.titulo.text = actividad.titulo
        holder.lugar.text = actividad.lugar
        holder.ponente.text = actividad.ponente
    }

    override fun getItemCount(): Int = actividades.size

    fun actualizarDatos(nuevas: List<Actividad>) {
        actividades = nuevas
        notifyDataSetChanged()
    }
}
