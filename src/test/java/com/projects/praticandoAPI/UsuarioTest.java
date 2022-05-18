package com.projects.praticandoAPI;

import static org.junit.Assert.*;

import com.projects.praticandoAPI.modelo.TipoPlano;
import com.projects.praticandoAPI.modelo.Usuario;

import org.junit.Test;

public class UsuarioTest {
    @Test()
    public void deveSerCriadoUsuarioCom200Moedas() {
        Usuario usuario = new Usuario("leonardo", "leonardo", "leonardo", TipoPlano.Free);

        assertEquals(200, usuario.getMoedas().intValue());
    }

    @Test()
    public void deveSerCriadoUsuarioCom0Moedas() {
        Usuario usuario = new Usuario("leonardo", "leonardo", "leonardo", TipoPlano.VIP);

        assertEquals(0, usuario.getMoedas().intValue());
    }
}
