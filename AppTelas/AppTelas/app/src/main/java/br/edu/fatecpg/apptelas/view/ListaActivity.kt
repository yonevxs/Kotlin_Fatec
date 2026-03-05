package br.edu.fatecpg.apptelas.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.apptelas.R
import br.edu.fatecpg.apptelas.adapter.ProdutoAdapter
import br.edu.fatecpg.apptelas.model.ProdutoDaoImpl

class ListaActivity : AppCompatActivity(R.layout.activity_lista) {

    private val dao = ProdutoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvProdutos = findViewById<RecyclerView>(R.id.rv_produtos)
        val produtos = dao.getProdutos()
        rvProdutos.layoutManager = LinearLayoutManager(this)
        rvProdutos.adapter = ProdutoAdapter(produtos)
    }
}