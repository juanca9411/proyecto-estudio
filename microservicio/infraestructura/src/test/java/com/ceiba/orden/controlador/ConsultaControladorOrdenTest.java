package com.ceiba.orden.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.orden.servicio.testdatabuilder.ComandoOrdenDataTestBuilder;
import com.ceiba.usuario.comando.ComandoOrden;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorOrden.class)
public class ConsultaControladorOrdenTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    private static  final Long ID_ORDEN =2L;

    @Test
    public void listar() throws Exception {
        //arrange
        //act-assert
        mockMvc.perform(get("/ordenes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("khw960")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void listarByIdOrden() throws Exception {
        //arrange
        ComandoOrden orden = new ComandoOrdenDataTestBuilder()
                .conIdOrden(ID_ORDEN)
                .build();
        //act-arrange
        mockMvc.perform(get("/ordenes/" + orden.getIdOrden())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("khw960")))
                .andDo(MockMvcResultHandlers.print());
    }

}
