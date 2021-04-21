package com.ceiba.vehiculo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.comando.ComandoVehiculo;
import com.ceiba.vehiculo.servicio.testdatabuilder.ComandoVehiculoTestDataBuilder;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorVehiculo.class)
public class ConsultaControladorVehiculoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listar() throws Exception {
        //arragne
        //act-assert
        mockMvc.perform(get("/vehiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("KHW980")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void listarByPlaca() throws Exception {
        //arragne
        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().build();
        //act-assert
        mockMvc.perform(get("/vehiculos/" + vehiculo.getPlaca())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa", is("KHW980")))
                .andDo(MockMvcResultHandlers.print());
    }


}
