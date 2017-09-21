package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="AUTHORITIES",
	indexes={ 
			@Index(name="IX_AUTH_USERNAME",columnList="USERNAME,AUTHORITY",unique=true)}
		)
public class Authorities {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false)
	private long id;
	@ManyToOne
	@JoinColumn( 
			foreignKey=@ForeignKey(name="FK_AUTHORITIES_USERS"),
			referencedColumnName="USERNAME",
			name="USERNAME")
	private Users  userName;
	@Column(name="AUTHORITY",length=50, nullable=false)
	private String authority;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Users getUserName() {
		return userName;
	}
	public void setUserName(Users userName) {
		this.userName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	/**
	 * 
	 *   create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authorit
	 * 
	 */

}
