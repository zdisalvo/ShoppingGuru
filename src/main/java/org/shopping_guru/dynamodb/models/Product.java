package org.shopping_guru.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.concurrent.atomic.AtomicLong;

@DynamoDBTable(tableName = "products")
public class Product {




    private String source;


    private String title;

    private String price;


    private Double rating;

    private Integer reviews;
    private Long productId;
    private String thumbnail;

    private String link;



    @DynamoDBHashKey(attributeName = "productId")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @DynamoDBAttribute(attributeName = "rating")
    public Double getRating() {
        return rating;
    }


    public void setRating(Double rating) {
        this.rating = rating;
    }

    @DynamoDBAttribute(attributeName = "reviews")
    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    @DynamoDBAttribute(attributeName = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @DynamoDBAttribute(attributeName = "thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @DynamoDBAttribute(attributeName = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", link='" + link + '\'' +
                ", source='" + source + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
