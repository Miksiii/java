/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.entities;

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
 * @author Milan
 */
@Entity
@Table(name = "follow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Follow.findAll", query = "SELECT f FROM Follow f"),
    @NamedQuery(name = "Follow.findByFollowId", query = "SELECT f FROM Follow f WHERE f.followId = :followId"),
    @NamedQuery(name = "Follow.findByFollowUser", query = "SELECT f FROM Follow f WHERE f.followUser = :followUser"),
    @NamedQuery(name = "Follow.findFollowedUsers", query = "SELECT f FROM Follow f WHERE f.userId = :userId"), 
    @NamedQuery(name = "Follow.findUserFollowers", query = "SELECT f FROM Follow f WHERE f.followUser = :userId"),
    @NamedQuery(name = "Follow.findFollowerByFollowUserAndUserRef", query = "SELECT f FROM Follow f WHERE f.followUser = :followUser AND f.userId = :userId"),
    @NamedQuery(name = "Follow.findFollowers", query = "SELECT f FROM Follow f WHERE f.followUser = :userId")
})  //findUserFollowesr => SELECT f FROM Follow f WHERE f.followUser = :userId
    //SELECT operT.id FROM SII_ARC_Oper operT, SII_ARC_Service serviceT  LEFT JOIN  operT.sid = serviceT.sid AND serviceT.duuid = ....
public class Follow implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "USER_NAME")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FOLLOW_USER_NAME")
    private String followUserName;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOLLOW_ID")
    private Integer followId;
    @Column(name = "FOLLOW_USER")
    private Integer followUser;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private User userId;

    public Follow() {
    }

    public Follow(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollowId() {
        return followId;
    }

    public void setFollowId(Integer followId) {
        this.followId = followId;
    }

    public Integer getFollowUser() {
        return followUser;
    }

    public void setFollowUser(Integer followUser) {
        this.followUser = followUser;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followId != null ? followId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Follow)) {
            return false;
        }
        Follow other = (Follow) object;
        if ((this.followId == null && other.followId != null) || (this.followId != null && !this.followId.equals(other.followId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fit.metropolitan.twitter.entities.Follow[ followId=" + followId + " ]";
    }

    public String getFollowUserName() {
        return followUserName;
    }

    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
