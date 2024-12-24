package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.medico.DatosListadoMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import med.voll.api.paciente.DatosListadoPaciente;
import med.voll.api.paciente.DatosRegistroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;


    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroPaciente datosRegistroPaciente){
        System.out.println("Datos recibidos" + datosRegistroPaciente);
        pacienteRepository.save(new Paciente(datosRegistroPaciente));
    }

    @GetMapping
    public Page<DatosListadoPaciente> listadoPacientes(@PageableDefault(size = 2, sort = "nombre", direction = Sort.Direction.DESC) Pageable paginacion){
        return pacienteRepository.findAll(paginacion).map(DatosListadoPaciente::new);
    }
}
