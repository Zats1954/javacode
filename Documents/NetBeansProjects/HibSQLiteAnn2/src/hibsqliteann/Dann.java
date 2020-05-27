/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibsqliteann;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alexander
 */
@Entity
@Table(name = "dann")

public class Dann implements Serializable {
    private static final long serialVersionUID = 15489L;
    @Id
    @Column(name = "id")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "t11")
    private String t11;
    @Column(name = "t12")
    private String t12;
    @Column(name = "t13")
    private String t13;
    @Column(name = "t14")
    private String t14;
    @Column(name = "t15")
    private String t15;
    @Column(name = "t16")
    private String t16;
    @Column(name = "t1j")
    private String t1j;
    @Column(name = "date")
    private String date;
    @Column(name = "t21")
    private String t21;
    @Column(name = "t22")
    private String t22;
    @Column(name = "t23")
    private String t23;
    @Column(name = "t24")
    private String t24;
    @Column(name = "t25")
    private String t25;
    @Column(name = "t26")
    private String t26;
    @Column(name = "t2j")
    private String t2j;

    public Dann() {
    }

    public Dann(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getT11() {
        return t11;
    }

    public void setT11(String t11) {
        this.t11 = t11;
    }

    public String getT12() {
        return t12;
    }

    public void setT12(String t12) {
        this.t12 = t12;
    }

    public String getT13() {
        return t13;
    }

    public void setT13(String t13) {
        this.t13 = t13;
    }

    public String getT14() {
        return t14;
    }

    public void setT14(String t14) {
        this.t14 = t14;
    }

    public String getT15() {
        return t15;
    }

    public void setT15(String t15) {
        this.t15 = t15;
    }

    public String getT16() {
        return t16;
    }

    public void setT16(String t16) {
        this.t16 = t16;
    }

    public String getT1j() {
        return t1j;
    }

    public void setT1j(String t1j) {
        this.t1j = t1j;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getT21() {
        return t21;
    }

    public void setT21(String t21) {
        this.t21 = t21;
    }

    public String getT22() {
        return t22;
    }

    public void setT22(String t22) {
        this.t22 = t22;
    }

    public String getT23() {
        return t23;
    }

    public void setT23(String t23) {
        this.t23 = t23;
    }

    public String getT24() {
        return t24;
    }

    public void setT24(String t24) {
        this.t24 = t24;
    }

    public String getT25() {
        return t25;
    }

    public void setT25(String t25) {
        this.t25 = t25;
    }

    public String getT26() {
        return t26;
    }

    public void setT26(String t26) {
        this.t26 = t26;
    }

    public String getT2j() {
        return t2j;
    }

    public void setT2j(String t2j) {
        this.t2j = t2j;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dann)) {
            return false;
        }
        Dann other = (Dann) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "isp.Dann[ id=" + id + " ]";
    }
    
}
