package quemepongo.Guardarropa;

class GuardarropaNotFoundException extends RuntimeException {

    GuardarropaNotFoundException(Long id) {
        super("Could not find guardarropa: " + id);
    }
}
