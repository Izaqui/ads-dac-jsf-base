package br.edu.ifpb.jsf;


import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorDeLivros {

    private Livros livros = new LivrosEmJDBC();
    private Livro livro = new Livro();

    public String salvar(){
        return null;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
