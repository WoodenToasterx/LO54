/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "CLIENT", uniqueConstraints={@UniqueConstraint(columnNames={"CLIENT_ID"})})
public class Client implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CLIENT_ID", nullable=false, unique=true)
    private Integer id;
    
    @Column(name="CLIENT_LASTNAME", nullable=false)
    private String lastname;
    
    @Column(name="CLIENT_FIRSTNAME", nullable=false)
    private String firstname;
    
    @Column(name="CLIENT_ADDRESS", nullable=false)
    private String address;
    
    @Column(name="CLIENT_PHONE", nullable=false)
    private String phone;
    
    @Column(name="CLIENT_EMAIL", nullable=false)
    private String email;
    
    @OneToOne
    @JoinColumn(name = "CS_ID")
    private CourseSession courseSession;

    public Client() {
    }

    public Client(Integer id, String lastname, String firstname, String address, String phone, String email, CourseSession courseSession) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.courseSession = courseSession;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getCourseSession() {
        return courseSession;
    }

    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lastname);
        hash = 97 * hash + Objects.hashCode(this.firstname);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.phone);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.courseSession);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.courseSession, other.courseSession)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", address=" + address + ", phone=" + phone + ", email=" + email + ", courseSession=" + courseSession + '}';
    }
}
