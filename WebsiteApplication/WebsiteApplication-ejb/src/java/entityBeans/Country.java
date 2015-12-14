/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
    @NamedQuery(name = "Country.findByLabel", query = "SELECT c FROM Country c WHERE c.label = :label"),
    @NamedQuery(name = "Country.findByShippingcost", query = "SELECT c FROM Country c WHERE c.shippingcost = :shippingcost")
})
public class Country implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "LABEL")
    private String label;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHIPPINGCOST")
    private BigDecimal shippingcost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCountry")
    private Collection<Translationscountry> translationscountryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCountry")
    private Collection<Client> clientCollection;

    public Country() {
    }

    public Country(String label) {
        this.label = label;
    }

    public Country(String label, BigDecimal shippingcost) {
        this.label = label;
        this.shippingcost = shippingcost;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getShippingcost() {
        return shippingcost;
    }

    public void setShippingcost(BigDecimal shippingcost) {
        this.shippingcost = shippingcost;
    }

    @XmlTransient
    public Collection<Translationscountry> getTranslationscountryCollection() {
        return translationscountryCollection;
    }

    public void setTranslationscountryCollection(Collection<Translationscountry> translationscountryCollection) {
        this.translationscountryCollection = translationscountryCollection;
    }

    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.label == null && other.label != null) || (this.label != null && !this.label.equals(other.label))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Country[ label=" + label + " ]";
    }
    
}
