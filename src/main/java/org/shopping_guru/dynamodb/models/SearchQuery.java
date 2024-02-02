package org.shopping_guru.dynamodb.models;

public class SearchQuery {

    private String searchPhrase;
    private Double price;
    private Integer resultsNum;

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getResultsNum() {
        return resultsNum;
    }

    public void setResultsNum(Integer resultsNum) {
        this.resultsNum = resultsNum;
    }
}
