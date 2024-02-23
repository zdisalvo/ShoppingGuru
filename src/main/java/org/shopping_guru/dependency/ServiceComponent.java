package org.shopping_guru.dependency;


import dagger.Component;
import org.shopping_guru.activity.DisplaySavedActivity;
import org.shopping_guru.activity.SaveProductsActivity;
import org.shopping_guru.activity.ScrapeProductsActivity;

import javax.inject.Singleton;

@Component(modules = {DaoModule.class})
@Singleton
public interface ServiceComponent {
    //root objects
    ScrapeProductsActivity provideScrapeProductsActivity();

    SaveProductsActivity provideSaveProductsActivity();

    DisplaySavedActivity provideDisplaySavedActivity();
}

