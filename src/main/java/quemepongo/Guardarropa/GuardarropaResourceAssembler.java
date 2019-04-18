package quemepongo.Guardarropa;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
class GuardarropaResourceAssembler implements ResourceAssembler<Guardarropa, Resource<Guardarropa>> {

    @Override
    public Resource<Guardarropa> toResource(Guardarropa employee) {

        return new Resource<>(employee,
                linkTo(methodOn(GuardarropaController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(GuardarropaController.class).all()).withRel("employees"));
    }
}
