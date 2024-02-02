//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

//package com.amazon.ata.aws.dynamodb;

package org.shopping_guru.util;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDbClientProvider {
    public DynamoDbClientProvider() {
    }

    public static AmazonDynamoDB getDynamoDBClient() {
        return getDynamoDBClient(Regions.US_WEST_2);
    }

    public static AmazonDynamoDB getDynamoDBClient(Regions region) {
        if (null == region) {
            throw new IllegalArgumentException("region cannot be null");
        } else {
            return (AmazonDynamoDB)((AmazonDynamoDBClientBuilder)((AmazonDynamoDBClientBuilder)AmazonDynamoDBClientBuilder.standard().withCredentials(DefaultAWSCredentialsProviderChain.getInstance())).withRegion(region)).build();
        }
    }
}
