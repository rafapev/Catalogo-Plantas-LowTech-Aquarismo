package dio.desafio.controller;

import dio.desafio.controller.dto.PlantDto;
import dio.desafio.service.PlantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/plants")
@Tag(name = "Plant Controller", description = "RESTful API for managing users.")
public record PlantController(PlantService plantService) {

    @GetMapping
    @Operation(summary = "Get all plants", description = "Retrieve a list of all registered users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<PlantDto>> findAll(){
        var plants = plantService.findAll();
        var plantsDto = plants.stream().map(PlantDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(plantsDto);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a plant by ID", description = "Retrieve a specific plant based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Plant not found")
    })
    public ResponseEntity<PlantDto> findById(@PathVariable Long id){
        var plants = plantService.findById(id);
        return ResponseEntity.ok(new PlantDto(plants));
    }
    @PostMapping
    @Operation(summary = "Create a new plant", description = "Create a new plant and return the created plant's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plant created successfully"),
            @ApiResponse(responseCode = "422",  description = "Invalid plant data provided")
    })
    public ResponseEntity<PlantDto> create(@RequestBody PlantDto plantDto){
        var plant = plantService.create(plantDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(plant.getId())
                .toUri();
        return ResponseEntity.created(location).body(new PlantDto(plant));
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update a plant", description = "Update the data of an existing plant based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plant updated successfully"),
            @ApiResponse(responseCode = "404", description = "Plant not found"),
            @ApiResponse(responseCode = "422", description = "Invalid plant data provided")
    })
    public ResponseEntity<PlantDto> update(@PathVariable Long id, @RequestBody PlantDto plantDto){
        var planta = plantService.update(id, plantDto.toModel());
        return ResponseEntity.ok(new PlantDto(planta));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a plant", description = "Delete an existing plant based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Plant deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Plant not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        plantService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
