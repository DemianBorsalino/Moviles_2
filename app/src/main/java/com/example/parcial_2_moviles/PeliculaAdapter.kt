package com.example.parcial_2_moviles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_2_moviles.databinding.ItemPeliculaBinding

class PeliculaAdapter(private val lista: List<Pelicula>) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    class PeliculaViewHolder(val binding: ItemPeliculaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = lista[position]
        holder.binding.tvTitulo.text = pelicula.titulo
        holder.binding.tvAnio.text = "Año: ${pelicula.anoDeEstreno}"
        holder.binding.tvGenero.text = "Género: ${pelicula.genero}"
        holder.binding.tvResena.text = "Reseña: ${pelicula.resena}"
    }

    override fun getItemCount(): Int = lista.size
}