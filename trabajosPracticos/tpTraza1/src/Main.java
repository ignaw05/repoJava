import entities.*;
import repositories.InMemoryRepository;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

//      CREO EL PAIS
        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();

//      BUENOS AIRES, LOCALIDADES Y DOMICILIOS
        Provincia buenosAires = Provincia.builder()
                .id(1L)
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();

        Localidad caba = Localidad.builder()
                .id(1L)
                .nombre("CABA")
                .provincia(buenosAires)
                .build();

        Localidad laPlata = Localidad.builder()
                .id(2L)
                .nombre("laPlata")
                .provincia(buenosAires)
                .build();

        Domicilio domicilioCABA = Domicilio.builder()
                .id(1L)
                .localidad(caba)
                .calle("General Paz")
                .numero(912)
                .cp(5515)
                .build();

        Domicilio domicilioLaPlata = Domicilio.builder()
                .id(2L)
                .localidad(laPlata)
                .calle("Avenida Fernando Zuqui")
                .numero(102)
                .cp(5125)
                .build();


//      CORDOBA LOCALIDADES Y DOMICILIOS
        Provincia cordoba = Provincia.builder()
                .id(2L)
                .nombre("Cordoba")
                .pais(argentina)
                .build();

        Localidad cordobaCapital = Localidad.builder()
                .id(3L)
                .nombre("Cordoba Capital")
                .provincia(cordoba)
                .build();

        Localidad carlosPaz = Localidad.builder()
                .id(4L)
                .nombre("Villa Carlos Paz")
                .provincia(cordoba)
                .build();

        Domicilio domicilioCordobaCap = Domicilio.builder()
                .id(3L)
                .localidad(cordobaCapital)
                .calle("Avenida Fernet")
                .numero(7030)
                .cp(1921)
                .build();

        Domicilio domicilioCarlosPaz = Domicilio.builder()
                .id(4L)
                .localidad(carlosPaz)
                .calle("Avenida Cuarteto")
                .numero(5050)
                .cp(1121)
                .build();

//      SUCURSALES

        Sucursal sucursal1 = Sucursal.builder()
                .id(1L)
                .nombre("Sucursal 1 Porteñito")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(18, 0))
                .esCasaMatriz(true)
                .domicilio(domicilioCABA)
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal 2 Bidonazo")
                .horarioApertura(LocalTime.of(10, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .esCasaMatriz(true)
                .domicilio(domicilioLaPlata)
                .build();

        Sucursal sucursal3 = Sucursal.builder()
                .id(3L)
                .nombre("Sucursal 3 Fernecito")
                .horarioApertura(LocalTime.of(3, 0))
                .horarioCierre(LocalTime.of(7, 0))
                .esCasaMatriz(false)
                .domicilio(domicilioCordobaCap)
                .build();

        Sucursal sucursal4 = Sucursal.builder()
                .id(4L)
                .nombre("Sucursal 4 Cuartetazo")
                .horarioApertura(LocalTime.of(2, 0))
                .horarioCierre(LocalTime.of(23, 0))
                .esCasaMatriz(true)
                .domicilio(domicilioCarlosPaz)
                .build();

//      EMPRESAS

        Empresa empresa1 = Empresa.builder()
                .id(1L)
                .nombre("Empresa 1 Sho")
                .razonSocial("Sho soy porteño")
                .cuil(1020304050L)
                .sucursales(new HashSet<>(Set.of(sucursal1, sucursal2)))
                .build();

        Empresa empresa2 = Empresa.builder()
                .id(2L)
                .nombre("Empresa 2 ferneteros")
                .razonSocial("Siempre 70/30")
                .cuil(70307030L)
                .sucursales(new HashSet<>(Set.of(sucursal3, sucursal4)))
                .build();

//      ASIGNO LAS EMPRESAS A LAS SUCURSALES
        sucursal1.setEmpresa(empresa1);
        sucursal2.setEmpresa(empresa1);
        sucursal3.setEmpresa(empresa2);
        sucursal4.setEmpresa(empresa2);

//      CREO EL inMemoryRepository
        InMemoryRepository<Empresa> empresasInMemoryRepository = new InMemoryRepository<>();

        System.out.println("GUARDANDO EMPRESAS");
        empresasInMemoryRepository.save(empresa1);
        empresasInMemoryRepository.save(empresa2);

//      MUESTRO TODAS LAS EMPRESAS
        System.out.println("\nMOSTRANDO TODAS LAS EMPRESAS");
        List<Empresa> empresas = empresasInMemoryRepository.findAll();
        for (Empresa empresa:empresas){
            System.out.println(empresa);
        }

//      BUSCANDO UNA EMPRESA POR ID
        System.out.println("\nBUSCANDO EMPRESA POR ID: 1");
        Optional<Empresa> empresaBuscada = empresasInMemoryRepository.findById(1L);
        System.out.println(empresaBuscada);

//      BUSCANDO UNA EMPRESA POR NOMBRE
        System.out.println("\nBUSCANDO EMPRESA POR NOMBRE: Empresa 2 ferneteros");
        List<Empresa> empBuscadaPorNombre = empresasInMemoryRepository.genericFindByField("nombre","Empresa 2 ferneteros");
        System.out.println(empBuscadaPorNombre);

//      ACTUALIZAR DATOS DE EMPRESA ID: 1
        System.out.println("\nACTUALIZAR DATOS DE EMPRESA ID: 1");
        Optional<Empresa> empresaActualizada = empresasInMemoryRepository.genericUpdate(1L, Empresa.builder()
                .nombre(empresa1.getNombre())
                .razonSocial("Sho me actualice")
                .cuil(11111111L)
                .sucursales(empresa1.getSucursales())
                .build());
        Optional<Empresa> empresaBuscada2 = empresasInMemoryRepository.findById(1L);
        System.out.println(empresaBuscada2);

//      ELIMINAR EMPRESA POR ID
        System.out.println("\nELIMINAR EMPRESA ID: 1");
        empresasInMemoryRepository.genericDelete(1L);
        if(empresasInMemoryRepository.findById(1L).isEmpty()){
            System.out.println("Empresa eliminada correctamente");
        }
        System.out.println("\nEmpresas después de la eliminación:");
        List<Empresa> empresasRestantes = empresasInMemoryRepository.findAll();
        empresasRestantes.forEach(System.out::println);


    }

}