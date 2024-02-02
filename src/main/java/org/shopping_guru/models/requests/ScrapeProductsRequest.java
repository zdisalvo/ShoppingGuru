package org.shopping_guru.models.requests;

import org.shopping_guru.models.results.ScrapeProductsResult;

import java.util.Objects;

public class ScrapeProductsRequest {

    private String searchPhrase;
    private Double price;
    private Integer resultsNum;

    public ScrapeProductsRequest(){};

    public ScrapeProductsRequest(Builder builder) {
        this.searchPhrase = builder.searchPhrase;
        this.price = builder.price;
        this.resultsNum = builder.resultsNum;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrapeProductsRequest)) return false;
        ScrapeProductsRequest that = (ScrapeProductsRequest) o;
        return Objects.equals(getSearchPhrase(), that.getSearchPhrase()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getResultsNum(), that.getResultsNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSearchPhrase(), getPrice(), getResultsNum());
    }

    @Override
    public String toString() {
        return "ScrapeProductsRequest{" +
                "searchPhrase='" + searchPhrase + '\'' +
                ", price=" + price +
                ", resultsNum=" + resultsNum +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {

        private String searchPhrase;
        private Double price;
        private Integer resultsNum;

        public Builder withSearchPhrase(String searchPhraseToUse) {
            this.searchPhrase = searchPhraseToUse;
            return this;
        }

        public Builder withPrice(Double priceToUse) {
            this.price = priceToUse;
            return this;
        }

        public Builder withResultsNum(Integer resultsNumToUse) {
            this.resultsNum = resultsNumToUse;
            return this;
        }

        public ScrapeProductsRequest build(){return new ScrapeProductsRequest(this);}
    }

}
