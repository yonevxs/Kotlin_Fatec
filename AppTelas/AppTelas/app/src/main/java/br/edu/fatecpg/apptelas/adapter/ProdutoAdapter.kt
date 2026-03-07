package br.edu.fatecpg.apptelas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.apptelas.R
import br.edu.fatecpg.apptelas.model.Produto

class ProdutoAdapter(private val produtos:List<Produto>):
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){
            val txvNomeProduto: TextView = itemView.findViewById(R.id.txv_nome_produto)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.txvNomeProduto.text = produto.nome
    }
}