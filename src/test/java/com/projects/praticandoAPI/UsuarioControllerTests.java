package com.projects.praticandoAPI;

import static org.junit.Assert.assertEquals;

import com.projects.praticandoAPI.controller.dto.UsuarioDto;
import com.projects.praticandoAPI.controller.form.UsuarioForm;
import com.projects.praticandoAPI.modelo.TipoPlano;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class UsuarioControllerTests {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void criarNovoUsuario() {
        UsuarioForm form = new UsuarioForm();
        form.setNome("leonardo");
        form.setEmail("email");
        form.setSenha("senha");
        form.setTipoPlano(TipoPlano.Free);

        HttpEntity<UsuarioForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<UsuarioDto> response = this.testRestTemplate
                .exchange("/usuarios", HttpMethod.POST, httpEntity, UsuarioDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getNome(), "leonardo");
        assertEquals(response.getBody().getMoedas().intValue(), 200);
    }

    @Test
    public void listaTest() {
        ResponseEntity<UsuarioDto[]> response = this.testRestTemplate
                .exchange("/usuarios", HttpMethod.GET, null, UsuarioDto[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
