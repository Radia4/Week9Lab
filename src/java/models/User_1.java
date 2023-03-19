/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author radia
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User_1.findAll", query = "SELECT u FROM User_1 u")
    , @NamedQuery(name = "User_1.findByEmail", query = "SELECT u FROM User_1 u WHERE u.email = :email")
    , @NamedQuery(name = "User_1.findByFirstName", query = "SELECT u FROM User_1 u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "User_1.findByLastName", query = "SELECT u FROM User_1 u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "User_1.findByPassword", query = "SELECT u FROM User_1 u WHERE u.password = :password")})
public class User_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role_1 role;

    public User_1() {
    }

    public User_1(String email) {
        this.email = email;
    }

    public User_1(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role_1 getRole() {
        return role;
    }

    public void setRole(Role_1 role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User_1)) {
            return false;
        }
        User_1 other = (User_1) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.User_1[ email=" + email + " ]";
    }
    
}
