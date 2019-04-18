package quemepongo.Guardarropa;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
class GuardarropaController {

    private final GuardarropaRepository repository;
    private final GuardarropaResourceAssembler assembler;

    GuardarropaController(GuardarropaRepository repository, GuardarropaResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/guardarropa")
    Resources<Resource<Guardarropa>> all() {

        List<Resource<Guardarropa>> guardarropa = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(guardarropa,
                linkTo(methodOn(GuardarropaController.class).all()).withSelfRel());
    }

    @PostMapping("/guardarropa")
    Guardarropa newEmployee(@RequestBody Guardarropa newGuardarropa) {
        return repository.save(newGuardarropa);
    }

    @GetMapping("/guardarropa/{id}")
    Resource<Guardarropa> one(@PathVariable Long id) {

        Guardarropa employee = repository.findById(id)
                .orElseThrow(() -> new GuardarropaNotFoundException(id));

        return assembler.toResource(employee);
    }

    @PutMapping("/guardarropa/{id}")
    Guardarropa replaceGuardarropa(@RequestBody Guardarropa newGuardarropa, @PathVariable Long id) {

        return repository.findById(id)
                .map(guardarropa -> {
                    guardarropa.setNombre(newGuardarropa.getNombre());
                    guardarropa.setDuenio(newGuardarropa.getDuenio());
                    return repository.save(guardarropa);
                })
                .orElseGet(() -> {
                    newGuardarropa.setId(id);
                    return repository.save(newGuardarropa);
                });
    }

    @DeleteMapping("/guardarropa/{id}")
    void deleteGuardarropa(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
