package Neat.and.Tidy.Solutions.cleaning.service.app.data.repository;

import Neat.and.Tidy.Solutions.cleaning.service.app.data.models.AppUser;

public interface AppUserRepository {

    AppUser findByEmail(String email);
}
