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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "KEYBOARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keyboard.findAll", query = "SELECT k FROM Keyboard k"),
    @NamedQuery(name = "Keyboard.findByIdKeyboard", query = "SELECT k FROM Keyboard k WHERE k.idKeyboard = :idKeyboard"),
    @NamedQuery(name = "Keyboard.findByKeyboardname", query = "SELECT k FROM Keyboard k WHERE k.keyboardname = :keyboardname"),
    @NamedQuery(name = "Keyboard.findByPrice", query = "SELECT k FROM Keyboard k WHERE k.price = :price"),
    @NamedQuery(name = "Keyboard.findByWeight", query = "SELECT k FROM Keyboard k WHERE k.weight = :weight"),
    @NamedQuery(name = "Keyboard.findByLed", query = "SELECT k FROM Keyboard k WHERE k.led = :led"),
    @NamedQuery(name = "Keyboard.findByLongeur", query = "SELECT k FROM Keyboard k WHERE k.longeur = :longeur"),
    @NamedQuery(name = "Keyboard.findByLayout", query = "SELECT k FROM Keyboard k WHERE k.layout = :layout"),
    @NamedQuery(name = "Keyboard.findBySwitches", query = "SELECT k FROM Keyboard k WHERE k.switches = :switches"),
    @NamedQuery(name = "Keyboard.findByBrand", query = "SELECT k FROM Keyboard k WHERE k.brand = :brand"),
    @NamedQuery(name = "Keyboard.findByUrlimage", query = "SELECT k FROM Keyboard k WHERE k.urlimage = :urlimage"),
    
    //query ajoutee
    @NamedQuery(name = "Keyboard.findByCategory", query = "SELECT k FROM Keyboard k, Possession p, Category c WHERE p.fkCategory = c.label AND p.fkKeyboard = k.idKeyboard AND c.label = :label")
})
public class Keyboard implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_KEYBOARD")
    private Integer idKeyboard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "KEYBOARDNAME")
    private String keyboardname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WEIGHT")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LED")
    private Boolean led;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGEUR")
    private BigDecimal longeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "LAYOUT")
    private String layout;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SWITCHES")
    private String switches;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BRAND")
    private String brand;
    @Size(max = 200)
    @Column(name = "URLIMAGE")
    private String urlimage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkKeyboard")
    private Collection<Lineorders> lineordersCollection;

    public Keyboard() {
    }

    public Keyboard(Integer idKeyboard) {
        this.idKeyboard = idKeyboard;
    }

    public Keyboard(Integer idKeyboard, String keyboardname, BigDecimal price, BigDecimal weight, Boolean led, BigDecimal longeur, String layout, String switches, String brand) {
        this.idKeyboard = idKeyboard;
        this.keyboardname = keyboardname;
        this.price = price;
        this.weight = weight;
        this.led = led;
        this.longeur = longeur;
        this.layout = layout;
        this.switches = switches;
        this.brand = brand;
    }

    public Integer getIdKeyboard() {
        return idKeyboard;
    }

    public void setIdKeyboard(Integer idKeyboard) {
        this.idKeyboard = idKeyboard;
    }

    public String getKeyboardname() {
        return keyboardname;
    }

    public void setKeyboardname(String keyboardname) {
        this.keyboardname = keyboardname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Boolean getLed() {
        return led;
    }

    public void setLed(Boolean led) {
        this.led = led;
    }

    public BigDecimal getLongeur() {
        return longeur;
    }

    public void setLongeur(BigDecimal longeur) {
        this.longeur = longeur;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getSwitches() {
        return switches;
    }

    public void setSwitches(String switches) {
        this.switches = switches;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    @XmlTransient
    public Collection<Lineorders> getLineordersCollection() {
        return lineordersCollection;
    }

    public void setLineordersCollection(Collection<Lineorders> lineordersCollection) {
        this.lineordersCollection = lineordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKeyboard != null ? idKeyboard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Keyboard)) {
            return false;
        }
        Keyboard other = (Keyboard) object;
        if ((this.idKeyboard == null && other.idKeyboard != null) || (this.idKeyboard != null && !this.idKeyboard.equals(other.idKeyboard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Keyboard[ idKeyboard=" + idKeyboard + " ]";
    }
    
}
