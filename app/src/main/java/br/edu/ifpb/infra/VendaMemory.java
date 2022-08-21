package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Venda;
import br.edu.ifpb.domain.Vendas;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VendaMemory implements Venda {
    private List<Vendas> vendas = new CopyOnWriteArrayList<>();
    @Override
    public void novaVenda(Vendas vendas) {
        this.vendas.add(vendas);
    }

    @Override
    public Vendas localizarPorCodigo(String codigo) {
        return this.vendas
                .stream()
                .filter(e->e.getCodigo().equals(codigo))
                .findFirst()
                .orElse(Vendas.vazio());
    }

    @Override
    public Vendas incluirLivro(String codigo, Livro livro) {
        Vendas vendas = localizarPorCodigo(codigo);
        if(Vendas.vazio().equals(vendas)){
            return vendas;
        }
        vendas.adicionarLivro(livro);
        return vendas;
    }
}
