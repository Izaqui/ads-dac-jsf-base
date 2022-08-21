package br.edu.ifpb.web.jsf;

import br.edu.ifpb.domain.ISBN;
import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;

import java.util.Arrays;
import java.util.List;

public class ControllLivros {
    private Livros livros = new LivrosEmJDBC();
    private Livro livro = new Livro();

    public String salvar(){
        return null;
    }
    public List<ISBN> isbns(){
        return Arrays.asList(
                new ISBN("2234567800")
        );
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
