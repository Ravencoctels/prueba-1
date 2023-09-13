package com.example.prueba_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.ViewHolder> {
    public List<lista_elementos> mdata;
    private LayoutInflater mInflater;
    private Context context;

    public adaptador(List<lista_elementos> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mdata=itemList;
    }
    @Override
    public int getItemCount() { return mdata.size();}

    @Override
    public adaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view=mInflater.inflate(R.layout.lista_elementos, null);
        return new adaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mdata.get(position));
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre,contenido,stock; {
        }



        ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre);
            contenido = itemView.findViewById(R.id.contenido);
            stock = itemView.findViewById(R.id.stock);
        }

        void bindData(final lista_elementos item){
            nombre.setText(item.getNombre());
            contenido.setText(item.getContenido());
            stock.setText(item.getStock());
        }
    }



}


