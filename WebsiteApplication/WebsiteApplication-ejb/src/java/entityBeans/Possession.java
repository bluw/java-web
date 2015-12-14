/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "POSSESSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possession.findAll", query = "SELECT p FROM Possession p"),
    @NamedQuery(name = "Possession.findByIdPossession", query = "SELECT p FROM Possession p WHERE p.idPossession = :idPossession"),
    @NamedQuery(name = "Possession.findByFkCategory", query = "SELECT p FROM Possession p WHERE p.fkCategory = :fkCategory"),
    @NamedQuery(name = "Possession.findByFkKeyboard", query = "SELECT p FROM Possession p WHERE p.fkKeyboard = :fkKeyboard")})
public class Possession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_POSSESSION")
    private Integer idPossession;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FK_CATEGORY")
    private String fkCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FK_KEYBOARD")
    private int fkKeyboard;

    public Possession() {
    }

    public Possession(Integer idPossession) {
        this.idPossession = idPossession;
    }

    public Possession(Integer idPossession, String fkCategory, int fkKeyboard) {
        this.idPossession = idPossession;
        this.fkCategory = fkCategory;
        this.fkKeyboard = fkKeyboard;
    }

    public Integer getIdPossession() {
        return idPossession;
    }

    public void setIdPossession(Integer idPossession) {
        this.idPossession = idPossession;
    }

    public String getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(String fkCategory) {
        this.fkCategory = fkCategory;
    }

    public int getFkKeyboard() {
        return fkKeyboard;
    }

    public void setFkKeyboard(int fkKeyboard) {
        this.fkKeyboard = fkKeyboard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPossession != null ? idPossession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possession)) {
            return false;
        }
        Possession other = (Possession) object;
        if ((this.idPossession == null && other.idPossession != null) || (this.idPossession != null && !this.idPossession.equals(other.idPossession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Possession[ idPossession=" + idPossession + " ]";
    }
    
}
