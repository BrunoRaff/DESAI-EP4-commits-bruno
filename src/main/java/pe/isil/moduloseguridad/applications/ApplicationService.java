package pe.isil.moduloseguridad.applications;

import pe.isil.moduloseguridad.applications.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {
  List<Application> getApplications();
  ApplicationDto addApplication(Application application);

  ApplicationDto updateApplication(Application application, Long id);

  Application findApplicationById(Long id);

  List<Application> findAll();

  void deleteApplication(Long id);
}
