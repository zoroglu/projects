package com.ent.main;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Bizde hiçbir şey ezber değil.ustamın dediği
 * kaynak http://www.devsniper.com/base-entity-class-in-jpa/ 
 * @author The Ceo :)
 *
 */
@MappedSuperclass  //entity ama bir tabloya bağlı değil
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = -5599994987931221314L;

	/*
	 * SEQ olan kısım entity classlardan geliyor.Her entity class için sequence ismini tanımlıyoruz class ın başında
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ")
	@Column(name = "id", updatable = false, nullable = false)  //update engellendi
	private Long id;
	
	public Long getId() {  
		return id;  
	}  

    @Override  
    public int hashCode() {  
        int hash = 0;  
        hash += (this.getId() != null ? this.getId().hashCode() : 0);  
  
        return hash;  
    }  
  
    @Override  
    public boolean equals(Object object) {  
    if (this == object)  
            return true;  
        if (object == null)  
            return false;  
        if (getClass() != object.getClass())  
            return false;  
  
        BaseEntity other = (BaseEntity) object; 
        if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {  
            return false;  
        }  
        return true;  
    }  
  
    @Override  
    public String toString() {
        return this.getClass().getName() + " [ID=" + id + "]";  
    }  
	
}
