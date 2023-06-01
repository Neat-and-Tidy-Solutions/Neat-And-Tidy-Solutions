package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.CreateServiceRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.CreateServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.FindServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Services;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.ServiceRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSServiceNotFoundException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.NTSService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Primary
public class NTSServiceImpl implements NTSService {

    private final ServiceRepository serviceRepository;
    @Override
    public CreateServiceResponse createService(CreateServiceRequest createServiceRequest) {
        Services serviceToBeCreated = Services.builder()
                .name(createServiceRequest.getServiceName())
                .serviceDescription(createServiceRequest.getServiceDescription())
                .build();
        Services savedService = serviceRepository.save(serviceToBeCreated);
        return CreateServiceResponse.builder()
                .id(savedService.getId())
                .message("Service created successfully")
                .build();
    }
    public FindServiceResponse findServiceById(Long serviceId){
        Optional<Services> foundService = serviceRepository.findById(serviceId);
        if(foundService.isEmpty()) throw new NTSServiceNotFoundException("No service has been created");
        return getFindServiceResponse(foundService.get());
        }
    public FindServiceResponse getFindServiceResponse(Services foundService) {
        return FindServiceResponse.builder()
                .id(foundService.getId())
                .serviceName(foundService.getName())
                .serviceDescription(foundService.getServiceDescription())
                .build();
    }
    public FindServiceResponse findServiceByName(String serviceName){
        Services foundService = serviceRepository.findServiceByName(serviceName).orElseThrow(NTSServiceNotFoundException::new);
        return getFindServiceResponse(foundService);
    }
    public List<Services> findAllServices(){
        return serviceRepository.findAll();
    }


}
