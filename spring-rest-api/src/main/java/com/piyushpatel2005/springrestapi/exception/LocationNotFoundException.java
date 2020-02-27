package com.piyushpatel2005.springrestapi.exception;

import com.piyushpatel2005.springrestapi.entity.Location;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();

    public LocationNotFoundException(String message, Long invalidLocationId) {
        super(message);
        extensions.put("invalidLocationId", invalidLocationId);
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
