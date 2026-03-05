package br.edu.fatecpg.apptelas.model

interface ProdutoDao {
    fun postProduto(produto:  Produto) // passa um produto do tipo Produto (classe)
    fun getProdutos():List<Produto> // função():tipo_de_retorno
}