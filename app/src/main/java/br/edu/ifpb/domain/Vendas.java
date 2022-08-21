package br.edu.ifpb.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Vendas {
    private List<Livro> livros;
    private String codigo;
    private StatusVenda status;

    private LocalDate dataVenda;
    private String cpf;

    public Vendas() {
        this.livros = new ArrayList<>();
        this.codigo = UUID.randomUUID().toString();
        this.status = StatusVenda.CRIADO;
        this.cpf = cpf;
    }
    private Vendas(String codigo){
        this.codigo = codigo;
    }
    @Contract(value = " -> new", pure = true)
    public static @NotNull Vendas vazio() {
        return new Vendas("vazio");
    }

    public void incluirCliente(String cpf){
        this.cpf = cpf;
    }
    public void adicionarLivro(Livro livro){
        this.livros.add(livro);
    }
    public void cancelar(){
        this.status = StatusVenda.CANCELADO;
    }
    public void finalizar(){
        this.status = StatusVenda.FINALIZADO;
        this.dataVenda = LocalDate.now();
    }

    public Object getCodigo() {
        this.codigo = codigo;
        return codigo;
    }

    

}
