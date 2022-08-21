package br.edu.ifpb.jsf;


import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Named
@RequestScoped
public class ControladorDeLivros {

    private Livros livros = new LivrosEmJDBC();
    private ResourceBundle json;
    private Livro livro = new Livro(-1, json.getString("titulo"), LocalDate.parse(json.getString("dataDeLancamento")), json.getString("capa"));

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
