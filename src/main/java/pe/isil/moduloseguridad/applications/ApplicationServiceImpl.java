package pe.isil.moduloseguridad.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.applications.dto.ApplicationDto;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public List<Application> getApplications() {
    return applicationRepository.findAll();
  }

  @Override
  public ApplicationDto addApplication(Application application) {
    try {
      applicationRepository.save(application);
      return ApplicationDto.onSuccess();
    } catch (Exception e) {
      return ApplicationDto.whenApplicationsExists();
    }
  }

  @Override
  public List<Application> findAll() {
    return applicationRepository.findAll();
  }

}
