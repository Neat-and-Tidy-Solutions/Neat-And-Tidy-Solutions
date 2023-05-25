package Neat.and.Tidy.Solutions.cleaning.service.app.service.impl;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.GuarantorRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCleanerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.repositories.GuarantorRepository;
import Neat.and.Tidy.Solutions.cleaning.service.app.exception.NTSManagementException;
import Neat.and.Tidy.Solutions.cleaning.service.app.service.GuarantorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuarantorServiceImpl implements GuarantorService {
    private final GuarantorRepository guarantorRepository;
    @Override
    public String completeGuarantorForm(GuarantorRequest guarantorRequest) {
        Guarantor guarantor = new Guarantor();
        guarantor.setName(guarantor.getName());
        guarantor.setEmail(guarantor.getEmail());
        guarantor.setAddress(guarantor.getAddress());
        guarantor.setContactNumber(guarantor.getContactNumber());
        guarantor.setRelationship(guarantor.getRelationship());
        guarantor.setImage(guarantor.getImage());
        guarantorRepository.save(guarantor);

        return "Guarantor form filled completely";
    }

    @Override
    public Guarantor updateProfile(UpdateCleanerRequest registerCleanerRequest) {
        return null;
    }

    @Override
    public Guarantor getGuarantorById(long id) {
        return guarantorRepository.findById(id).orElseThrow(()->
                new NTSManagementException("Guarantor not found"));
    }

    @Override
    public Guarantor getGuarantorByEmail(String email) {
        return guarantorRepository.findGuarantorByEmailIgnoreCase(email);
    }

    @Override
    public List<Guarantor> getGuarantors() {
        return guarantorRepository.findAll();
    }

    @Override
    public void deleteGuarantorById(long id) {
        guarantorRepository.deleteById(id);
    }
}
