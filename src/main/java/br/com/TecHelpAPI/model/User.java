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
    @Column(nullable = false)
=======
    @Column(nullable = false, length = 12)
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    private String password;

    @Column(nullable = false, length = 20)
    private String dept;

<<<<<<< HEAD
    @Column(nullable = false, length = 50, unique = true)
=======
    @Column(nullable = false, length = 50)
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    private String email;

    public User(){ }

<<<<<<< HEAD


=======
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
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
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser());
=======
        if (!(o instanceof User user)) return false;
        return Objects.equals(getIdUser(), user.getIdUser()) && Objects.equals(getNameUser(), user.getNameUser()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getDept(), user.getDept()) && Objects.equals(getEmail(), user.getEmail());
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(getIdUser());
    }
}
=======
        return Objects.hash(getIdUser(), getNameUser(), getPassword(), getDept(), getEmail());
    }
}
>>>>>>> 89ac0d2685a46c2149fe250889388cfc52e677ab
