package org.shopping_guru.util;

import org.shopping_guru.serpapi.GoogleSearch;

import java.util.Map;
import java.util.concurrent.Callable;

public class GoogleSearchCallable implements Callable<GoogleSearch> {

    private Map<String, String> parameter;

    public GoogleSearchCallable(Map<String, String> parameter) {
        this.parameter = parameter;
    }
    @Override
    public GoogleSearch call() throws Exception {

        GoogleSearch search = new GoogleSearch(parameter);
        return search;
    }
}
