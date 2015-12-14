/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByIdOrders", query = "SELECT o FROM Orders o WHERE o.idOrders = :idOrders"),
    @NamedQuery(name = "Orders.findByOrdersdate", query = "SELECT o FROM Orders o WHERE o.ordersdate = :ordersdate"),
    
    @NamedQuery(name = "Orders.findLast", query = "SELECT o FROM Orders o ORDER BY o.idOrders DESC")
})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDERS")
    private Integer idOrders;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERSDATE")
    @Temporal(TemporalType.DATE)
    private Date ordersdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkOrders")
    private Collection<Lineorders> lineordersCollection;
    @JoinColumn(name = "FK_CLIENT", referencedColumnName = "ID_CLIENT")
    @ManyToOne(optional = false)
    private Client fkClient;

    public Orders() {
    }

    public Orders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public Orders(Integer idOrders, Date ordersdate) {
        this.idOrders = idOrders;
        this.ordersdate = ordersdate;
    }

    public Integer getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(Integer idOrders) {
        this.idOrders = idOrders;
    }

    public Date getOrdersdate() {
        return ordersdate;
    }

    public void setOrdersdate(Date ordersdate) {
        this.ordersdate = ordersdate;
    }

    @XmlTransient
    public Collection<Lineorders> getLineordersCollection() {
        return lineordersCollection;
    }

    public void setLineordersCollection(Collection<Lineorders> lineordersCollection) {
        this.lineordersCollection = lineordersCollection;
    }

    public Client getFkClient() {
        return fkClient;
    }

    public void setFkClient(Client fkClient) {
        this.fkClient = fkClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrders != null ? idOrders.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idOrders == null && other.idOrders != null) || (this.idOrders != null && !this.idOrders.equals(other.idOrders))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Orders[ idOrders=" + idOrders + " ]";
    }
    
}
