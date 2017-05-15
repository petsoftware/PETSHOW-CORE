package br.com.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GROUP_MEMBERS")
public class GroupMembers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false)
	private long id;
	@Column(name="",nullable=false,length=50)
	private String userName;
	@ManyToOne
	@JoinColumn(name="GROUP_ID",referencedColumnName="ID",foreignKey=@ForeignKey(name="FK_GROUP_MEMBERS_GROUP"))
	private Groups groups;
/*
 * create table group_members (
  id bigint generated by default as identity(start with 0) primary key,
  username varchar(50) not null,
  group_id bigint not null,
  constraint fk_group_members_group foreign key(group_id) references groups(id));
 * 	
 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	
	//https://docs.spring.io/spring-security/site/docs/3.0.x/reference/springsecurity.pdf

}