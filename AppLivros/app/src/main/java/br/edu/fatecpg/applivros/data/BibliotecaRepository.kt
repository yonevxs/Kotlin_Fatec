package br.edu.fatecpg.applivros.data
import br.edu.fatecpg.applivros.model.Livro
object BibliotecaRepository {
    private val _listaDeLivros = mutableListOf<Livro>()

    fun salvarLivro(livro: Livro) {
        _listaDeLivros.add(livro)
    }

    fun obterTodos(): List<Livro> {
        return _listaDeLivros.toList() // Retorna uma cópia segura
    }
}