package org.shopping_guru.dependency;


import dagger.Component;
import org.shopping_guru.activity.*;

import javax.inject.Singleton;

@Component(modules = {DaoModule.class})
@Singleton
public interface ServiceComponent {
    //root objects
    ScrapeProductsActivity provideScrapeProductsActivity();

    SaveProductsActivity provideSaveProductsActivity();

    DisplaySavedActivity provideDisplaySavedActivity();

    CreateUserActivity provideCreateUserActivity();

    LoginActivity provideLoginActivity();
}

