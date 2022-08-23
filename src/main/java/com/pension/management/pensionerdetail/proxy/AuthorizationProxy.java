package com.pension.management.pensionerdetail.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authentication-service" ,url="${AUTHORIZATION_SERVICE_URI:http://localhost:9030}")
@Service
public interface AuthorizationProxy {

	@GetMapping(value = "/auth/validate")
	public boolean validateAndReturnUser(@RequestHeader("Authorization") String token);

}
