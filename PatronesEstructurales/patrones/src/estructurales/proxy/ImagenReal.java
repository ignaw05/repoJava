package estructurales.proxy;

public class ImagenReal implements Imagen {
        private String archivo;

    public ImagenReal(String archivo) {
            this.archivo = archivo;
            cargarDesdeDisco(); // simulamos algo pesado
        }

        private void cargarDesdeDisco() {
            System.out.println("Cargando imagen desde disco: " + archivo);
        }

        @Override
        public void mostrar() {
            System.out.println("Mostrando imagen: " + archivo);
        }
    }
