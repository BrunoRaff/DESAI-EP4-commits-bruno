package pe.isil.moduloseguridad.applications;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_app", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre", name = "unique_app_name")
})
@Data
public class Application {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre", length = 200)
  private String nombre;
  private String baseDatos;
  private String lenguage;
  private String usuarioCreacion;
  private Date fechaCreacion = new Date();

  @PostPersist
  public void updateCreatedAt() {
    fechaCreacion = new Date();
  }

}
