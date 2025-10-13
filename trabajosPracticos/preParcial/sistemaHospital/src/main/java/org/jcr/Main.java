package org.jcr;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.jcr.entidades.*;

import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws CitaException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital-persistence-unit");
        EntityManager em = emf.createEntityManager();

        Hospital hospital = Hospital.builder()
                .nombre("Hospital Español")
                .telefono("489098082")
                .direccion("Godoy Cruz 1921").build();

        Departamento cardiologia = Departamento.builder()
                .nombre("CARDIOLOGIA")
                .especialidad(EspecialidadMedica.CARDIOLOGIA)
                .build();

        Departamento pediatria = Departamento.builder()
                .nombre("PEDIATRIA")
                .especialidad(EspecialidadMedica.PEDIATRIA)
                .build();

        Departamento trauma = Departamento.builder()
                .nombre("TRAUMATOLOGIA")
                .especialidad(EspecialidadMedica.TRAUMATOLOGIA)
                .build();



        hospital.agregarDepartamento(cardiologia);
        hospital.agregarDepartamento(pediatria);
        hospital.agregarDepartamento(trauma);

        cardiologia.crearSala("1","Niños");
        pediatria.crearSala("2","Niños");
        cardiologia.crearSala("3","Adultos");
        trauma.crearSala("4","Adultos");

        Medico medico1 = Medico.builder()
                .apellido("Wuilloud")
                .dni("46398525")
                .especialidad(EspecialidadMedica.CARDIOLOGIA)
                .matricula(new Matricula("MP-51153"))
                .build();
        Medico medico2 = Medico.builder()
                .apellido("Lopez")
                .dni("46393823")
                .especialidad(EspecialidadMedica.PEDIATRIA)
                .matricula(new Matricula("MP-20222"))
                .build();
        Medico medico3 = Medico.builder()
                .apellido("Gonzalez")
                .dni("34290182")
                .especialidad(EspecialidadMedica.TRAUMATOLOGIA)
                .matricula(new Matricula("MP-12345"))
                .build();

        medico1.setDepartamento(cardiologia);
        medico2.setDepartamento(pediatria);
        medico3.setDepartamento(trauma);
        Paciente pac1 = Paciente.builder()
                .nombre("Lucas")
                .apellido("Catriel")
                .tipoSangre(TipoSangre.A_NEGATIVO)
                .telefono("2612514127")
                .direccion("Soas de Civit")
                .dni("23456789").build();

        Paciente pac2 = Paciente.builder()
                .nombre("Maercos")
                .apellido("Dillom")
                .tipoSangre(TipoSangre.B_NEGATIVO)
                .telefono("2612514122")
                .direccion("Emilio Civit")
                .dni("23456123").build();

        Paciente pac3 = Paciente.builder()
                .nombre("Patricio")
                .apellido("Amoroso")
                .tipoSangre(TipoSangre.A_POSITIVO)
                .telefono("2612514121")
                .direccion("Las Civit")
                .dni("23456098").build();

        pac1.setHospital(hospital);
        pac2.setHospital(hospital);
        pac3.setHospital(hospital);

        HistoriaClinica historia1 = pac1.getHistoriaClinica();
        historia1.agregarDiagnostico("Hipertensión arterial");
        historia1.agregarTratamiento("Enalapril 10mg");
        historia1.agregarAlergia("Penicilina");

        HistoriaClinica historia2 = pac2.getHistoriaClinica();
        historia2.agregarDiagnostico("Refriado");
        historia2.agregarTratamiento("Ibuprofeno 10mg");

        HistoriaClinica historia3 = pac3.getHistoriaClinica();
        historia3.agregarDiagnostico("Lesion");
        historia3.agregarTratamiento("Ibuprofeno 600");
        System.out.println("LISTO");

        CitaManager citaManager = new CitaManager();
        Cita cita1 = citaManager.programarCita(
                pac1,
                medico1,
                cardiologia.getSalaPorNumero("1"),
                LocalDateTime.now().plusDays(1).withHour(10).withMinute(0),
                new BigDecimal("10000"));
        System.out.println("Cita programada");

        Cita cita2 = citaManager.programarCita(
                pac2,
                medico2,
                pediatria.getSalaPorNumero("2"),
                LocalDateTime.now().plusDays(10).withHour(10).withMinute(0),
                new BigDecimal("500"));
        System.out.println("Cita programada");

        Cita cita3 = citaManager.programarCita(
                pac3,
                medico3,
                trauma.getSalaPorNumero("4"),
                LocalDateTime.now().plusDays(20).withHour(10).withMinute(0),
                new BigDecimal("990"));
        System.out.println("Cita programada");


        em.getTransaction().begin();
        try {
            em.persist(hospital);
            em.persist(cita1);
            em.persist(cita2);
            em.persist(cita3);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }

        em.getTransaction().begin();
        cita1.setEstado(EstadoCita.COMPLETADA);
        em.merge(cita1);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("SISTEMA EJECUTADO EXITOSAMENTE");
    }
}