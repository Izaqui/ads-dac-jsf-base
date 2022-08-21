package br.edu.ifpb.domain;

public interface Venda {
    public void novaVenda(Vendas vendas);
    public Vendas localizarPorCodigo(String codigo);
    public Vendas incluirLivro(String codigo, Livro livro);
}
