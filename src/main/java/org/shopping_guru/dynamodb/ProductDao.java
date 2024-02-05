package org.shopping_guru.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.shopping_guru.dynamodb.models.Product;
import org.shopping_guru.dynamodb.models.ProductOrig;
import org.shopping_guru.exceptions.ProductNotFoundException;
import org.shopping_guru.util.DynamoDbClientProvider;

import javax.inject.Inject;

public class ProductDao {

    private final DynamoDBMapper mapper;

    @Inject
    public ProductDao(DynamoDBMapper mapper) {
        this.mapper = mapper;
    }

    public Product getProductById(Long id) {
        Product product = this.mapper.load(Product.class, id);

        if (product == null) {
            throw new ProductNotFoundException("Could not find product with id: " + id);
        }

        return product;
    }

    public Product saveProduct(Product product) {
        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());

        dynamoDBMapper.save(product);

        return product;
    }


}
