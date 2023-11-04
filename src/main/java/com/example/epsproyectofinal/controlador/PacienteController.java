package com.example.epsproyectofinal.controlador;

import com.example.epsproyectofinal.DTO.PacienteDTO;
import com.example.epsproyectofinal.entidad.*;
import com.example.epsproyectofinal.servicio.*;
import com.example.epsproyectofinal.servicio.excepciones.AttributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "http://localhost:4200")

public class PacienteController {


        @Autowired
        private PacienteService pacienteService;
        @Autowired
        private EpsService epsService;

        @Autowired
        private AlergiaService alergiaService;

        @Autowired
        private CloudinaryService cloudinaryService;
        @GetMapping(path = "/{idUsuario}")
        public Paciente obtenerPorId(@PathVariable String idUsuario) throws Exception {
            Optional<Paciente> clienteOptional = Optional.ofNullable(pacienteService.obtenerPacienteporId(idUsuario));

            if (clienteOptional.isPresent()) {
                return clienteOptional.get();
            } else {
                throw new AttributeException("Nose pudo encontrar paciente");
            }
        }

        @PostMapping("/crearPaciente")
        public Paciente crearPaciente(@RequestParam("imagen") MultipartFile imagen,
                                      @RequestParam("idUsuario") String idUsuario,
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("contrasena") String contrasena,
                                      @RequestParam("email") String email,
                                      @RequestParam("telefono") String telefono,
                                      @RequestParam("fechaNacimiento") String fechaNacimiento,
                                      @RequestParam("idEps") String idEps,
                                      @RequestParam("idCiudad") String idCiudad,
                                      @RequestParam("tipoSangre") String tipoSangre,
                                      @RequestParam("alergiasId") String alergiasId) throws Exception {
            try {
                // Crea una instancia de Paciente y configura los datos
                TipoUsuario tipoUsuario= TipoUsuario.valueOf("PAC");
                TipoSangre tipoSangre1= TipoSangre.valueOf(tipoSangre);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                Date fechaNacimiento1 = dateFormat.parse(fechaNacimiento);
                Map result = cloudinaryService.cargarImagen(imagen);
                String imageUrl = (String) result.get("url");
                Paciente paciente = new Paciente();
                paciente.setIdUsuario(idUsuario);
                paciente.setNombre(nombre);
                paciente.setContrasena(contrasena);
                paciente.setEmail(email);
                paciente.setTelefono(telefono);
                paciente.setFechaNacimiento(fechaNacimiento1);
                paciente.setTipoUsuario(tipoUsuario);
                paciente.setImagenUrl(imageUrl);
                EPS eps = new EPS();
                eps.setIdEPS(parseInt(idEps, 10));
                paciente.setEps(eps);

                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(parseInt(idCiudad, 10));
                paciente.setCiudad(ciudad);

                paciente.setTipoSangre(tipoSangre1);
                System.out.println("alergias"+alergiasId);
                String[] ids;
                if (alergiasId != null && !alergiasId.isEmpty()) {
                    // Divide el string usando comas como delimitador
                    ids = alergiasId.split(",");

                    List<Alergia> alergiaList = new ArrayList<>();
                    for (int i = 0; i < ids.length; i++) {
                        try {
                            Alergia alergia = new Alergia();


                            if (ids[i] != null && !ids[i].equals("")) {

                                alergia.setIdAlergia(Integer.parseInt(ids[i].trim(), 10));
                                alergiaList.add(alergia);

                            }
                        } catch (NumberFormatException e) {
                            System.out.println("error al crear las alergias");
                        }
                    }
                    System.out.println("lista"+paciente.getAlergiaList());
                    paciente.setAlergiaList(alergiaList);


                } else {
                    // Si el inputString es nulo o vacío, retorna un array vacío
                    System.out.println("no hay alergias");
                }





                return pacienteService.registrarPaciente(paciente);
            } catch (Exception e) {
                // Maneja las excepciones según tus necesidades
               throw  new AttributeException("error al crear el paciente");
            }

        }

}


