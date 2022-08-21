package br.edu.ifpb.domain;

import java.util.Objects;

public class ISBN {
    private String numero;

    public ISBN(String value) {
        this.numero = value;
    }

    public static ISBN of(String value){
        if(value==null || "".equals(value.trim())) return null;
        return  new ISBN(value);
    }
    public String simple(){
        return this.numero;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ISBN isbn = (ISBN) o;
        return numero.equals(isbn.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
