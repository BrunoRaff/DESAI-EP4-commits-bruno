package pe.isil.moduloseguridad.applications;

import pe.isil.moduloseguridad.applications.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
  List<Application> getApplications();
  ApplicationDto addApplication(Application application);

  List<Application> findAll();


}
