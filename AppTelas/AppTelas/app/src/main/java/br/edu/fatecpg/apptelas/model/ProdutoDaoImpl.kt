package br.edu.fatecpg.apptelas.model

class ProdutoDaoImpl : ProdutoDao { // extends Interface
        companion object {
            private val produtos = mutableListOf<Produto>()
        }

        override fun postProduto(produto: Produto) {

            produtos.add(produto)
        }

        override fun getProdutos(): List<Produto> {
            return produtos
        }

}