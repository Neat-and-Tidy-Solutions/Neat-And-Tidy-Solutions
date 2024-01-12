package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.*;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.AppUserRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.CleanerRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.GuarantorRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.CleanerService;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
@AllArgsConstructor
public class CleanerServiceImpl implements CleanerService {
    private final CleanerRepository cleanerRepository;
    private final AppUserRepository appUserRepository;
    private final GuarantorRepository guarantorRepository;
    @Override
    public RegisterCleanerResponse updateProfile(UpdateCleanerRequest updateCleanerRequest) {
        AppUser foundUser = appUserRepository.findByEmailIgnoreCase(updateCleanerRequest.getEmail());
        Guarantor foundGuarantor = guarantorRepository.findGuarantorByEmailIgnoreCase(updateCleanerRequest.getEmail());

        Cleaner cleaner = new Cleaner();
        if(Objects.isNull(foundUser)) throw new NTSManagementException("user not found");
        if(Objects.isNull(foundGuarantor)) throw new NTSManagementException("guarantor does not exist");
        foundUser.setFullName(updateCleanerRequest.getFullName());
        cleaner.setAppuser(foundUser);
        cleaner.setId(foundUser.getId());
        cleaner.setProfileImage(updateCleanerRequest.getProfileImage().toString());
        cleaner.setAddress(updateCleanerRequest.getAddress());
        cleaner.setGuarantor(foundGuarantor);

        cleanerRepository.save(cleaner);
        return RegisterCleanerResponse.builder()
                .message("Thank you" + foundUser.getUsername() +"Profile updated")
                .build();
    }

    @Override
    public Cleaner getCleanerById(long id) {
        return cleanerRepository.findById(id).orElseThrow(()->
                new NTSManagementException("Cleaner not found"));
    }


    @Override
    public List<Cleaner> getCleaners() {
        return cleanerRepository.findAll();
    }

    @Override
    public void deleteCleanerById(long id) {
        cleanerRepository.deleteById(id);
    }


}

