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

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorOrden.class)

public class ComandoControladorOrdenTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    public void registrar() throws Exception {
        //arrange
        ComandoOrden orden = new ComandoOrdenDataTestBuilder()
                .conIdOrden(null)
                .build();
        //act-assert
        mocMvc.perform(post("/ordenes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orden)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor: 3}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void actualizar() throws Exception {
        //arrange
        ComandoOrden orden = new ComandoOrdenDataTestBuilder()
                .conIdOrden(1L)
                .build();
        //act-assert
        mocMvc.perform(put("/ordenes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orden)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor: true}"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void generarOrdenSalida() throws Exception {
        //arragne
        ComandoOrden orden = new ComandoOrdenDataTestBuilder()
                .conFechaSalida(LocalDateTime.now())
                .build();
        //act-asert
        mocMvc.perform(put("/ordenes/generar-orden")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orden)))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor: true}"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void eliminar() throws Exception {
        //arrange
        ComandoOrden orden = new ComandoOrdenDataTestBuilder().build();
        //act-assert
        mocMvc.perform(delete("/ordenes/" + orden.getIdOrden())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{valor: true}"))
                .andDo(MockMvcResultHandlers.print());
    }
}
