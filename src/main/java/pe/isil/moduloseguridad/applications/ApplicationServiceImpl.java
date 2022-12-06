package pe.isil.moduloseguridad.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.moduloseguridad.applications.dto.ApplicationDto;

import java.util.List;
import java.util.Optional;

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
  public ApplicationDto updateApplication(Application application, Long id){
    try{
      Optional<Application> appToUpdate = applicationRepository.findById(id);
      if(appToUpdate.isPresent()){
        appToUpdate.get().setNombre(application.getNombre() != null ? application.getNombre() : appToUpdate.get().getNombre());
        appToUpdate.get().setBaseDatos(application.getBaseDatos() != null ? application.getBaseDatos() : appToUpdate.get().getBaseDatos());
        appToUpdate.get().setLenguage(application.getLenguage() != null ? application.getLenguage() : appToUpdate.get().getLenguage());
        appToUpdate.get().setUsuarioCreacion(application.getUsuarioCreacion() != null ? application.getUsuarioCreacion() : appToUpdate.get().getUsuarioCreacion());
        applicationRepository.save(appToUpdate.get());
        return ApplicationDto.onSuccess();
      }
      return ApplicationDto.whenApplicationsExists();
    } catch (Exception e){
      return ApplicationDto.whenApplicationsExists();
    }
  }

  @Override
  public Application findApplicationById(Long id) {
    return applicationRepository.findById(id).orElse(null);
  }


  @Override
  public List<Application> findAll() {
    return applicationRepository.findAll();
  }

  @Override
  public void deleteApplication(Long id) {

    Optional<Application> appToDelete = applicationRepository.findById(id);

    if (appToDelete.isPresent()){
      applicationRepository.delete(appToDelete.get());
    }

  }



}
