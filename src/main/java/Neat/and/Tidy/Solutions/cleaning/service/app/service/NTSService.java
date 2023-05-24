package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.CreateServiceRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.CreateServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.FindServiceResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Services;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NTSService {
    CreateServiceResponse createService(CreateServiceRequest createServiceRequest);
    FindServiceResponse findServiceById(Long serviceId);
    FindServiceResponse findServiceByName(String serviceName);
    List<Services> findAllServices();
}
