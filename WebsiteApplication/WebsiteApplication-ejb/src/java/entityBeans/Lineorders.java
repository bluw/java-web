/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "LINEORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineorders.findAll", query = "SELECT l FROM Lineorders l"),
    @NamedQuery(name = "Lineorders.findByIdLineorders", query = "SELECT l FROM Lineorders l WHERE l.idLineorders = :idLineorders"),
    @NamedQuery(name = "Lineorders.findByQuantity", query = "SELECT l FROM Lineorders l WHERE l.quantity = :quantity"),
    @NamedQuery(name = "Lineorders.findByPrice", query = "SELECT l FROM Lineorders l WHERE l.price = :price")})
public class Lineorders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LINEORDERS")
    private Integer idLineorders;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @JoinColumn(name = "FK_KEYBOARD", referencedColumnName = "ID_KEYBOARD")
    @ManyToOne(optional = false)
    private Keyboard fkKeyboard;
    @JoinColumn(name = "FK_ORDERS", referencedColumnName = "ID_ORDERS")
    @ManyToOne(optional = false)
    private Orders fkOrders;

    public Lineorders() {
    }

    public Lineorders(Integer idLineorders) {
        this.idLineorders = idLineorders;
    }

    public Lineorders(Integer idLineorders, short quantity, BigDecimal price) {
        this.idLineorders = idLineorders;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getIdLineorders() {
        return idLineorders;
    }

    public void setIdLineorders(Integer idLineorders) {
        this.idLineorders = idLineorders;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Keyboard getFkKeyboard() {
        return fkKeyboard;
    }

    public void setFkKeyboard(Keyboard fkKeyboard) {
        this.fkKeyboard = fkKeyboard;
    }

    public Orders getFkOrders() {
        return fkOrders;
    }

    public void setFkOrders(Orders fkOrders) {
        this.fkOrders = fkOrders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineorders != null ? idLineorders.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineorders)) {
            return false;
        }
        Lineorders other = (Lineorders) object;
        if ((this.idLineorders == null && other.idLineorders != null) || (this.idLineorders != null && !this.idLineorders.equals(other.idLineorders))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Lineorders[ idLineorders=" + idLineorders + " ]";
    }
    
}
