package com.guptha.rest.web.services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Ratnaji Guptha");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Ratnaji", "Guptha"));
	}

	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParams() {
		return new PersonV1("Ratnaji Guptha");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParams() {
		return new PersonV2(new Name("Ratnaji", "Guptha"));
	}

	/*
	 * @GetMapping(path = "/person/header", headers = "X-API-VERSION=1") public
	 * PersonV1 getFirstVersionOfPersonHeader() { return new
	 * PersonV1("Ratnaji Guptha"); }
	 */

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonHeader() {
		return new PersonV2(new Name("Ratnaji", "Guptha"));
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.api-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeader() {
		return new PersonV1("Ratnaji Guptha");
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.api-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Ratnaji", "Guptha"));
	}
}
