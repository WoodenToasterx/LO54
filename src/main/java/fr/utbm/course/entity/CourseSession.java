/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "COURSE_SESSION", uniqueConstraints={@UniqueConstraint(columnNames={"CS_ID"})})
public class CourseSession implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CS_ID", nullable=false, unique=true)
    private Integer id;
    
    @Column(name="CS_START_DATE", nullable=false)
    private Date startDate;
    
    @Column(name="CS_END_DATE", nullable=false)
    private Date endDate;
    
    @Column(name="CS_MAX_NUMBER", nullable=true)
    private Integer max;
    
    @OneToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;
    
    @OneToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    public CourseSession() {
    }

    public CourseSession(Integer id, Date startDate, Date endDate, Integer max, Course course, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.startDate);
        hash = 73 * hash + Objects.hashCode(this.endDate);
        hash = 73 * hash + Objects.hashCode(this.max);
        hash = 73 * hash + Objects.hashCode(this.course);
        hash = 73 * hash + Objects.hashCode(this.location);
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
        final CourseSession other = (CourseSession) obj;
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.max, other.max)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + ", course=" + course + ", location=" + location + '}';
    }
}