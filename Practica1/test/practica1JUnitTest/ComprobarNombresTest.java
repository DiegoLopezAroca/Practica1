package practica1JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import practica1JUnit.ComprobarNombres;

public class ComprobarNombresTest {

    @Test
    public void testValidarCorreo() {
        // Casos de correos válidos
        assertTrue(ComprobarNombres.validarCorreo("usuario@dominio.com"));
        assertTrue(ComprobarNombres.validarCorreo("nombre.apellido@dominio.co.uk"));

        // Casos de correos inválidos
        assertFalse(ComprobarNombres.validarCorreo("")); // Correo vacío
        assertFalse(ComprobarNombres.validarCorreo("correoInvalido")); // Sin @
        assertFalse(ComprobarNombres.validarCorreo("usuario@dominio")); // Sin extensión (com, org, etc.)
        assertFalse(ComprobarNombres.validarCorreo("correo espacios@dominio.com")); // Espacios en el correo
        assertFalse(ComprobarNombres.validarCorreo("@dominio.com")); // Sin nombre de usuario
        assertFalse(ComprobarNombres.validarCorreo("usuario@dominio@com")); // Múltiples @
    }

    @Test
    public void testConNumeros() {
        assertTrue(ComprobarNombres.validarCorreo("nombre123@dominio.com")); // Con números
        assertTrue(ComprobarNombres.validarCorreo("23@gmail.com")); // Con números, pero al inicio del nombre de usuario
    }

    @Test
    public void testConCaracteresEspeciales() {
        assertTrue(ComprobarNombres.validarCorreo("usuario@dominio.com")); // Sin caracteres especiales
        assertTrue(ComprobarNombres.validarCorreo("usuario+apellido@dominio.com")); // Con +
        assertTrue(ComprobarNombres.validarCorreo("usuario.apellido@dominio.com")); // Con .
        assertTrue(ComprobarNombres.validarCorreo("usuario_apellido@dominio.com")); // Con _
        assertTrue(ComprobarNombres.validarCorreo("usuario-123@dominio.com")); // Con -
        assertTrue(ComprobarNombres.validarCorreo("usuario&apellido@dominio.com")); // Con &
        assertTrue(ComprobarNombres.validarCorreo("correo_con_numeros123@dominio.org"));
    }

    @Test
    public void testConStringVacio() {
        assertFalse(ComprobarNombres.validarCorreo("")); // String vacío
        assertFalse(ComprobarNombres.validarCorreo("   ")); // String de espacios
    }

    @Test
    public void testExtensionCorreo() {
        assertFalse(ComprobarNombres.validarCorreo("usuario@dominio")); // Sin extensión (com, org, etc.)
        assertFalse(ComprobarNombres.validarCorreo("usuario@dominio.")); // Extensión vacía
        assertFalse(ComprobarNombres.validarCorreo("usuario@dominio.c")); // Extensión de una sola letra
        assertTrue(ComprobarNombres.validarCorreo("usuario@dominio.co.uk")); // Extensión válida
    }
}
