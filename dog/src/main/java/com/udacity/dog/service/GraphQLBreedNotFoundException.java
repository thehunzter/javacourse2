package com.udacity.dog.service;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphQLBreedNotFoundException extends RuntimeException implements GraphQLError {
    private final Map<String, Object> extensions = new HashMap<>();

    public GraphQLBreedNotFoundException(String message, String invalidBreed) {
        super(message);
        extensions.put("invalidBreedId", invalidBreed);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
