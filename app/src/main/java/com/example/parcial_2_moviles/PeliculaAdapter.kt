package com.example.parcial_2_moviles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_2_moviles.databinding.ItemPeliculaBinding

class PeliculaAdapter(
    private var peliculas: List<Pelicula>,
    private val onEliminarClick: (Pelicula) -> Unit
) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    inner class PeliculaViewHolder(val binding: ItemPeliculaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val binding = ItemPeliculaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeliculaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
        with(holder.binding) {
            tvTitulo.text = pelicula.titulo
            tvAnio.text = "Año: ${pelicula.anio}"
            tvGenero.text = "Género: ${pelicula.genero.name}"
            tvResena.text = "Comentario: ${pelicula.resena}"
            rbRanking.rating = pelicula.ranking.toFloat()

            btnEliminar.setOnClickListener {
                onEliminarClick(pelicula)
            }
        }
    }

    override fun getItemCount(): Int = peliculas.size

    fun actualizarLista(nuevaLista: List<Pelicula>) {
        peliculas = nuevaLista
        notifyDataSetChanged()
    }
}