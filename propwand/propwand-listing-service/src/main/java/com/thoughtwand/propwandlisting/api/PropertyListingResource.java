package com.thoughtwand.propwandlisting.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtwand.propwandlisting.domain.Property;
import com.thoughtwand.propwandlisting.service.PropertyListingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/properties")
public class PropertyListingResource {

	@Autowired
	private PropertyListingService service;

	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find a Property by a given ID",
	notes = "Provide an ID to look up for a Property",
	response = Property.class)
	public Property getPropertyById(
			@ApiParam (value = "ID of the Property", required = true)
			@PathVariable Long id) {
		//TODO: service.findbyId
		return new Property()
				.title("Helllo")
				.address("Colombo")
				.value(1000.00).withId(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation (value = "Find all Properties in the system",response = List.class)
	public List<Property> getAllProperties() {
		//TODO: service.getAllProperties
		return Arrays.asList(new Property().title("Abc"));
	}

	@PostMapping
	@ApiOperation (value = "Create a new Property in the system", response = Property.class)
	public Property createProperty(@RequestBody Property property) {
		return service.createProperty(property);
	}


	@PutMapping ("/{id}")
	@ApiOperation (value = "Update an existing Property")
	public Property update(@ApiParam (value = "Property to update") @RequestBody Property 
			property, @ApiParam (value = "ID of the Property to update") @PathVariable Long id) {
		return service.updateProperty(property, id);
	}
	
	@DeleteMapping
	@ApiOperation (value = "Remove a Property from the system")
	public void deleteProperty(@ApiParam (value = "ID of the property to delete") @PathVariable Long id) {
		service.deleteProperty(id);
	}
	
	

}
