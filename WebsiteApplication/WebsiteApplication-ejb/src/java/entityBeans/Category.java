/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByLabel", query = "SELECT c FROM Category c WHERE c.label = :label"),
    
})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "LABEL")
    private String label;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCategory")
    private Collection<Translationscategory> translationscategoryCollection;

    public Category() {
    }

    public Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlTransient
    public Collection<Translationscategory> getTranslationscategoryCollection() {
        return translationscategoryCollection;
    }

    public void setTranslationscategoryCollection(Collection<Translationscategory> translationscategoryCollection) {
        this.translationscategoryCollection = translationscategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (label != null ? label.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.label == null && other.label != null) || (this.label != null && !this.label.equals(other.label))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Category[ label=" + label + " ]";
    }
    
}
