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
  @GeneratedValue
  private Long id;

  @Column(name = "nombre", length = 200)
  private String nombre;
  private String baseDatos;
  private String language;
  private String usuarioCreacion;
  private Date fechaCreacion;

  @PostPersist
  public void postPersistFecha() {
    this.fechaCreacion = new Date();
  }
}
