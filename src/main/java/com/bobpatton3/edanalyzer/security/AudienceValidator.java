package com.bobpatton3.edanalyzer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

class AudienceValidator implements OAuth2TokenValidator<Jwt> {
    private final String audience;
    private static final Logger LOG = LoggerFactory.getLogger(AudienceValidator.class);

    AudienceValidator(String audience) {
        this.audience = audience;
    }
    
    @Override
    public OAuth2TokenValidatorResult validate(Jwt jwt) {
        OAuth2Error error = new OAuth2Error("invalid_token", "The required audience is missing", null);
        
        if (jwt.getAudience().contains(audience)) {
            
            LOG.info("JWT successfully validated");
            return OAuth2TokenValidatorResult.success();
        }
        LOG.info("JWT NOT validated");
        return OAuth2TokenValidatorResult.failure(error);
    }
}
