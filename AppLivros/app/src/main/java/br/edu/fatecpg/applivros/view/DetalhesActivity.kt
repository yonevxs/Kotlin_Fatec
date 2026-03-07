package br.edu.fatecpg.applivros.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.applivros.R
import br.edu.fatecpg.applivros.data.BibliotecaRepository

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        val listaDeLivros = BibliotecaRepository.obterTodos()

        if (listaDeLivros.isEmpty()) {
            txtResultado.text = "Nenhum livro cadastrado ainda."
        } else {
            var textoExibicao = ""

            for (livro in listaDeLivros) {
                textoExibicao += "Título: ${livro.titulo}\nAutor: ${livro.autor}\n\n-----------------\n\n"
            }

            txtResultado.text = textoExibicao
        }
    }
}