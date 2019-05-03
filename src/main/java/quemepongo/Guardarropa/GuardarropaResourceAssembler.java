/*package quemepongo.Guardarropa;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
class GuardarropaResourceAssembler implements ResourceAssembler<Guardarropa, Resource<Guardarropa>> {

    @Override
    public Resource<Guardarropa> toResource(Guardarropa employee) {

        return new Resource<>(employee,
                linkTo(methodOn(GuardarropaController.class).one(employee.getId())).withSelfRel(),
                linkTo(methodOn(GuardarropaController.class).all()).withRel("employees"));
    }
}
*/