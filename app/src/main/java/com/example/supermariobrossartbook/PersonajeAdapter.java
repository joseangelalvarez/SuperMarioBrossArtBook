package com.example.supermariobrossartbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter para el RecyclerView que muestra la lista de personajes.
 */
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {
    private java.util.List<Personaje> listaPersonajes;
    private OnPersonajeClickListener onClickListener;

    /**
     * Interfaz para manejar el evento de clic en un personaje.
     */
    public interface OnPersonajeClickListener {
        void onPersonajeClick(Personaje personaje);
    }

    /**
     * Constructor del adapter.
     *
     * @param listaPersonajes Lista de personajes a mostrar.
     * @param onClickListener Listener para evento de clic.
     */
    public PersonajeAdapter(java.util.List<Personaje> listaPersonajes, OnPersonajeClickListener onClickListener) {
        this.listaPersonajes = listaPersonajes;
        this.onClickListener = onClickListener;
    }

    /**
     * ViewHolder que contiene las referencias a los componentes gráficos de cada ítem.
     */
    public static class PersonajeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPersonaje;
        TextView tvNombre;
        View itemView;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            imgPersonaje = itemView.findViewById(R.id.imgPersonaje);
            tvNombre = itemView.findViewById(R.id.tvNombrePersonaje);
        }

        public void bind(final Personaje personaje, final OnPersonajeClickListener listener) {
            imgPersonaje.setImageResource(personaje.getImagenResId());
            tvNombre.setText(personaje.getNombre());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPersonajeClick(personaje);
                }
            });
        }
    }

    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        Personaje personaje = listaPersonajes.get(position);
        holder.bind(personaje, onClickListener);
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }
}
