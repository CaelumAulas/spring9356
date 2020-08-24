package br.com.alura.forum.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role implements GrantedAuthority {
    public static final Role admin = new Role("ROLE_ADMIN");
    public static final Role aluno = new Role("ROLE_ALUNO");

    @Id
    private String authority;

    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
