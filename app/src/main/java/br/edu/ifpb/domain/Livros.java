package br.edu.ifpb.domain;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/04/2022, 10:50:41
 */
public interface Livros {

    public List<Livro> todos();
    
    public Livro criar(Livro livro);

    Livro buscarId(long id);

    Livro atualizar(long id, Livro livro);

    boolean remover(long id);
}
