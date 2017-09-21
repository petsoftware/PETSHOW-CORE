package br.com.petmooby.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Tabela de autorizacao para o Spring.
 * @author antoniorafael
 *
 */
@Entity
@Table(name="users")
public class Users {

	@Id
    private String username = ""; //varchar_ignorecase(50) not null primary key,
    private String password = "";//varchar_ignorecase(50) not null,
    private boolean enabled = false;//boolean not null);
}
