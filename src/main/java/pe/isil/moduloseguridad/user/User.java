package pe.isil.moduloseguridad.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tbl_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name="unique_email_user")
})
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String lastname;

  @Column(name = "email", length = 200)
  private String email;

  private String photo;
}
