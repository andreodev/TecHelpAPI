package br.com.TecHelpAPI.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(nullable = false, length = 40)
    private String nameUser;

<<<<<<< HEAD
    @Column(nullable = false, length = 12)
=======
    @Column(nullable = false)
>>>>>>> alexandre-features
    private String password;

    @Column(nullable = false, length = 20)
    private String dept;

<<<<<<< HEAD
    @Column(nullable = false, length = 50)
=======
    @Column(nullable = false, length = 50, unique = true)
>>>>>>> alexandre-features
    private String email;

    public User(){ }

<<<<<<< HEAD
=======


>>>>>>> alexandre-features
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
<<<<<<< HEAD
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser()) && Objects.equals(getNameUser(), user.getNameUser()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getDept(), user.getDept()) && Objects.equals(getEmail(), user.getEmail());
=======
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser());
>>>>>>> alexandre-features
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(getIdUser(), getNameUser(), getPassword(), getDept(), getEmail());
    }
}
=======
        return Objects.hash(getIdUser());
    }
}
>>>>>>> alexandre-features
