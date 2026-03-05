package br.edu.fatecpg.apptelas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.apptelas.R
import br.edu.fatecpg.apptelas.model.Produto
import br.edu.fatecpg.apptelas.model.ProdutoDaoImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val dao = ProdutoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val edtNomeProduto = findViewById<EditText>(R.id.edt_nome_produto)
        val btnCadastrar: Button = findViewById(R.id.btn_cadastrar)
        val fabLista: FloatingActionButton = findViewById(R.id.fab_lista)

        btnCadastrar.setOnClickListener{
            val nomeProduto = edtNomeProduto.text.toString()
            dao.postProduto(Produto(nomeProduto))
            Toast.makeText(this, "Cadastro OK", Toast.LENGTH_SHORT).show()
            edtNomeProduto.text.clear()
        }

        fabLista.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }
    }
}