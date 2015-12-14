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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRANSLATIONSCOUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translationscountry.findAll", query = "SELECT t FROM Translationscountry t"),
    @NamedQuery(name = "Translationscountry.findByIdTranslation", query = "SELECT t FROM Translationscountry t WHERE t.idTranslation = :idTranslation"),
    @NamedQuery(name = "Translationscountry.findByDescription", query = "SELECT t FROM Translationscountry t WHERE t.description = :description"),
    
    @NamedQuery(name = "Translationscountry.findCountryTranslationByLanguage", query = "SELECT t FROM Translationscountry t WHERE t.fkLanguage.label = :lang"),
    @NamedQuery(name = "Translationscountry.findCountryNameTranslated", query = "SELECT t FROM Translationscountry t WHERE t.fkLanguage.label = :lang AND t.fkCountry.label = :id")
    
})
public class Translationscountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TRANSLATION")
    private Integer idTranslation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "FK_COUNTRY", referencedColumnName = "LABEL")
    @ManyToOne(optional = false)
    private Country fkCountry;
    @JoinColumn(name = "FK_LANGUAGE", referencedColumnName = "LABEL")
    @ManyToOne(optional = false)
    private Languages fkLanguage;

    public Translationscountry() {
    }

    public Translationscountry(Integer idTranslation) {
        this.idTranslation = idTranslation;
    }

    public Translationscountry(Integer idTranslation, String description) {
        this.idTranslation = idTranslation;
        this.description = description;
    }

    public Integer getIdTranslation() {
        return idTranslation;
    }

    public void setIdTranslation(Integer idTranslation) {
        this.idTranslation = idTranslation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getFkCountry() {
        return fkCountry;
    }

    public void setFkCountry(Country fkCountry) {
        this.fkCountry = fkCountry;
    }

    public Languages getFkLanguage() {
        return fkLanguage;
    }

    public void setFkLanguage(Languages fkLanguage) {
        this.fkLanguage = fkLanguage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTranslation != null ? idTranslation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Translationscountry)) {
            return false;
        }
        Translationscountry other = (Translationscountry) object;
        if ((this.idTranslation == null && other.idTranslation != null) || (this.idTranslation != null && !this.idTranslation.equals(other.idTranslation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Translationscountry[ idTranslation=" + idTranslation + " ]";
    }
    
}
