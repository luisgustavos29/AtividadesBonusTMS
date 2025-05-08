package usuariosValida;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class UsuarioTest {

    @Test
    public void testValidarNome() {
        assertTrue(Usuario.validarNome("João Silva"));
        assertTrue(Usuario.validarNome("Maria"));
        assertTrue(Usuario.validarNome("Ana Paula"));

        assertFalse(Usuario.validarNome(null));
        assertFalse(Usuario.validarNome(""));
        assertFalse(Usuario.validarNome(" "));
        assertFalse(Usuario.validarNome("João123"));
        assertFalse(Usuario.validarNome("M@ria"));
        assertFalse(Usuario.validarNome("Carlos-Alberto"));
    }

    @Test
    public void testValidarEmail() {
        assertTrue(Usuario.validarEmail("usuario@dominio"));
        assertTrue(Usuario.validarEmail("user.name@domain"));
        assertTrue(Usuario.validarEmail("user_name@domain"));

        assertFalse(Usuario.validarEmail(null));
        assertFalse(Usuario.validarEmail(""));
        assertFalse(Usuario.validarEmail(" "));
        assertFalse(Usuario.validarEmail("usuario@"));
        assertFalse(Usuario.validarEmail("@dominio"));
        assertFalse(Usuario.validarEmail("user@name@domain"));
        assertFalse(Usuario.validarEmail("user@domin!o"));
        assertFalse(Usuario.validarEmail("user@domínio"));
    }

    @Test
    public void testSetSenha() {
        Usuario usuario = new Usuario("João Silva", "joao@email", "senha123");
        assertNotNull(usuario.getSenhahash());
        assertFalse(usuario.getSenhahash().isEmpty());
        assertThrows(IllegalArgumentException.class, () -> usuario.setSenha(null));
        assertThrows(IllegalArgumentException.class, () -> usuario.setSenha(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"senha123", "outraSenha", "123456", "aVeryLongPasswordWithSpecialChars!@#$"})
    public void testSetSenhaWithValueSource(String senha) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        assertDoesNotThrow(() -> usuario.setSenha(senha));
        assertNotNull(usuario.getSenhahash());
        assertFalse(usuario.getSenhahash().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"SHA-256", "SHA-1", "MD5"})
    public void testSetSenhaWithAlgorithm(String algorithm) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        assertDoesNotThrow(() -> usuario.setSenha("senha123", algorithm));
        assertNotNull(usuario.getSenhahash());
        assertFalse(usuario.getSenhahash().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"UNKNOWN", "INVALID", "SHA-512"})
    public void testSetSenhaWithInvalidAlgorithm(String algorithm) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        assertThrows(RuntimeException.class, () -> usuario.setSenha("senha123", algorithm));
    }

    enum Algorithm {
        SHA_256("SHA-256"),
        SHA_1("SHA-1"), 
        MD5("MD5");

        private final String value;

        Algorithm(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @ParameterizedTest
    @EnumSource(Algorithm.class)
    public void testSetSenhaWithEnumSource(Algorithm algorithm) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        assertDoesNotThrow(() -> usuario.setSenha("senha123", algorithm.getValue()));
        assertNotNull(usuario.getSenhahash());
        assertFalse(usuario.getSenhahash().isEmpty());
    }

    @ParameterizedTest
    @CsvSource({
        "senha1, SHA-256",
        "senha2, MD5",
        "senha3, SHA-1",
        "longPasswordWithSpecialChars!@#, SHA-256"
    })
    public void testSetSenhaWithCsvSource(String senha, String algorithm) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        if (algorithm.equals("MD5") || algorithm.equals("SHA-1") || algorithm.equals("SHA-256")) {
            assertDoesNotThrow(() -> usuario.setSenha(senha, algorithm));
            assertNotNull(usuario.getSenhahash());
            assertFalse(usuario.getSenhahash().isEmpty());
        } else {
            assertThrows(RuntimeException.class, () -> usuario.setSenha(senha, algorithm));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/senhas_testes.csv", numLinesToSkip = 1)
    public void testSetSenhaWithCsvFileSource(String senha, String algorithm) {
        Usuario usuario = new Usuario("João Silva", "joao@email", "tempPassword");
        if (algorithm.equals("MD5") || algorithm.equals("SHA-1") || algorithm.equals("SHA-256")) {
            assertDoesNotThrow(() -> usuario.setSenha(senha, algorithm));
            assertNotNull(usuario.getSenhahash());
            assertFalse(usuario.getSenhahash().isEmpty());
        } else {
            assertThrows(RuntimeException.class, () -> usuario.setSenha(senha, algorithm));
        }
    }
}