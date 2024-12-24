package med.voll.api.medico;

import med.voll.api.paciente.Paciente;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String Especialidad,
        String documento,
        String email
) {

    public DatosListadoMedico(Medico medico){
        this(medico.getId(), medico.getNombre(),medico.getEspecialidad().toString(),medico.getDocumento(),medico.getEmail());
    }

}
