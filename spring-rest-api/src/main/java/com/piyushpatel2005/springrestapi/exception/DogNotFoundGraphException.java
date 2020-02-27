package com.piyushpatel2005.springrestapi.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DogNotFoundGraphException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundGraphException(String message, Long invalidDogId) {
        super(message);
        extensions.put("invalidDogId", invalidDogId);
    }
    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
