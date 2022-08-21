package br.edu.ifpb.Api;

import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

public class LivrosApi {
    @Inject
    private Livros livros;
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Livro> listarTodos(){
        return livros.todos();
    }

    @GET
    @Path("{id}") // /livros/{id}
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Livro recuperarPorId(@PathParam("id") long id){
        return livros.buscarId(id);
    }

    //    @Context UriInfo uriInfo;
    @POST
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response criar(JsonObject json, @Context UriInfo uriInfo){
        Livro livro = livros.criar(
                livroDe(json)
        );
        URI location = uriInfo.getAbsolutePathBuilder() //http://localhost:8080/core/api/livros"
                .path(String.valueOf(livro.getId())) //http://localhost:8080/core/api/livros/
                .build();
        return Response.created(location) //201
                .entity(livro) // livro
                .build();
    }
    @PUT
    @Path("{id}") // ../api/livros/{id}
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response atualizar(@PathParam("id") long id,
                              Livro livro){
        Livro resposta = livros.atualizar(id, livro);
        return Response.ok() //201
                .entity(resposta) // livro
                .build();
    }

    @DELETE
    @Path("{id}") // /livros/{id}
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response remover(@PathParam("id") long id){
        if(livros.remover(id)) {//true -> sucesso
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

    private Livro livroDe(JsonObject json) {
        return new Livro(-1,
                json.getString("titulo"),
                LocalDate.parse(
                        json.getString("dataDeLancamento")
                )
        );
    }
}
