package br.com.petmooby.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Rafael Rocha
 * @since 1.0 06/05/2017 as 00:17
 * @version 1.0
 */
@Entity
@Table(name="GROUP_AUTHORITIES")
public class GroupAuthorities {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID",nullable=false)
	private long id;
	@Column(name="AUTHORITY",length=50,nullable=false)
	private String authority;
	@ManyToOne
	@JoinColumn(name="GROUP_ID",
			referencedColumnName="ID", 
			foreignKey=@ForeignKey(name="FK_GROUP_AUTHORITIES_GROUP"))
	private Groups groups;
	/*groups
	 * 
	 * create table group_authorities (
  group_id bigint not null,
  authority varchar(50) not null,
  constraint fk_group_authorities_group foreign key(group_id) references groups(id));
	 */
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	

}
