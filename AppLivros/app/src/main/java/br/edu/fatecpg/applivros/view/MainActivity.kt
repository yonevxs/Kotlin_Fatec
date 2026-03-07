package br.edu.fatecpg.applivros.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.applivros.R
import br.edu.fatecpg.applivros.data.BibliotecaRepository
import br.edu.fatecpg.applivros.model.Livro

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTitulo = findViewById<EditText>(R.id.editTitulo)
        val editEditor = findViewById<EditText>(R.id.editAutor)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val autor = editEditor.text.toString()

            if (titulo.isNotEmpty() && autor.isNotEmpty()) {
                val novoLivro = Livro(titulo, autor)
                BibliotecaRepository.salvarLivro(novoLivro)

                Toast.makeText(this, "Sucesso! Livro cadastrado.", Toast.LENGTH_SHORT).show()

                editTitulo.text.clear()
                editEditor.text.clear()

                editTitulo.requestFocus()
            } else {
                editTitulo.error = "Preencha o título!"
            }

        }
        val fabLista =
            findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabLista)

        fabLista.setOnClickListener {
            val intent = Intent(
                this,
                DetalhesActivity::class.java
            )
            startActivity(intent)
        }
    }
}