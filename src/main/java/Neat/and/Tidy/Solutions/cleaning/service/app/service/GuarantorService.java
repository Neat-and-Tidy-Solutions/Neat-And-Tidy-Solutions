package Neat.and.Tidy.Solutions.cleaning.service.app.service;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.GuarantorRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.request.UpdateCleanerRequest;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.dto.response.RegisterCleanerResponse;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Cleaner;
import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.Guarantor;

import java.util.List;

public interface GuarantorService {
    String completeGuarantorForm(GuarantorRequest guarantorRequest);
    Guarantor updateProfile(UpdateCleanerRequest registerCleanerRequest);
    Guarantor getGuarantorById(long id);
    Guarantor getGuarantorByEmail(String email);

    List<Guarantor> getGuarantors();

    void deleteGuarantorById(long id);
    }
