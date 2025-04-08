    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package wonderland.sistemarestaurantesnegocio.implementaciones;

    import java.util.List;
    import wonderland.sistemarestaurantesdominio.Cliente;
    import wonderland.sistemarestaurantesdominio.ClienteFrecuente;
    import wonderland.sistemarestaurantesdominio.dtos.ClienteFrecuenteDTO;
    import wonderland.sistemarestaurantesdominio.dtos.NuevoClienteFrecuenteDTO;
    import wonderland.sistemarestaurantesnegocio.IClientesBO;
    import wonderland.sistemarestaurantesnegocio.exceptions.NegocioException;
    import wonderland.sistemarestaurantespersistencia.IClientesFrecuentesDAO;

    /**
     *
     * Clase para implementar las reglas de negocio
     * al manejar los metodos de las DAOs de clientes
     */
    public class ClientesBO implements IClientesBO {

        private IClientesFrecuentesDAO clientesFrecuentesDAO;

        private static final int LIMITE_CARACTERES_NOMBRE = 100;
        private static final int LIMITE_CARACTERES_CORREO_ELECTRONICO = 100;
        private static final int LIMITE_CARACTERES_TELEFONO = 20;
        private static final int LIMITE_CARACTERES = 100;

        public ClientesBO(IClientesFrecuentesDAO clientesFrecuentesDAO){
            this.clientesFrecuentesDAO = clientesFrecuentesDAO;
        }

        @Override
        public ClienteFrecuente registrarCliente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws NegocioException {

            // Validaciones de campos obligatorios
            if (nuevoClienteFrecuente.getNombre() == null || nuevoClienteFrecuente.getNombre().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el nombre del cliente");
            }

            if (nuevoClienteFrecuente.getApellidoPaterno() == null || nuevoClienteFrecuente.getApellidoPaterno().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el apellido paterno del cliente");
            }

            if (nuevoClienteFrecuente.getApellidoMaterno() == null || nuevoClienteFrecuente.getApellidoMaterno().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el apellido materno del cliente");
            }

            if (nuevoClienteFrecuente.getTelefono() == null || nuevoClienteFrecuente.getTelefono().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el teléfono del cliente");
            }

            // Validaciones de formato (solo letras para nombre y apellidos)
            if (!nuevoClienteFrecuente.getNombre().matches("^[a-zA-Z ]+$")) {
                 throw new NegocioException("El nombre solo puede contener letras y espacios simples");
            }

            if (!nuevoClienteFrecuente.getApellidoPaterno().matches("^[a-zA-Z]+$")) {
                throw new NegocioException("El apellido paterno solo puede contener letras");
            }

            if (!nuevoClienteFrecuente.getApellidoMaterno().matches("^[a-zA-Z]+$")) {
                throw new NegocioException("El apellido materno solo puede contener letras");
            }

            // Validaciones de longitud
            if (nuevoClienteFrecuente.getNombre().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El nombre del cliente excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (nuevoClienteFrecuente.getApellidoPaterno().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El apellido paterno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (nuevoClienteFrecuente.getApellidoMaterno().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El apellido materno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (nuevoClienteFrecuente.getCorreoElectronico().length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
                throw new NegocioException("El correo electrónico excede el límite de " + LIMITE_CARACTERES_CORREO_ELECTRONICO + " caracteres.");
            }

            if (nuevoClienteFrecuente.getTelefono().length() > LIMITE_CARACTERES_TELEFONO) {
                throw new NegocioException("El teléfono excede el límite de " + LIMITE_CARACTERES_TELEFONO + " caracteres.");
            }

            // Validación de formato de teléfono
            String telefono = nuevoClienteFrecuente.getTelefono();
            if (!telefono.matches("^\\+?\\d+$")) {
                throw new NegocioException("El teléfono solo puede contener números y puede comenzar con un +.");
            }

            // Validación de formato de correo electrónico
            String correo = nuevoClienteFrecuente.getCorreoElectronico();
            if (correo != null && !correo.trim().isEmpty()) {
                if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    throw new NegocioException("El formato del correo electrónico no es válido.");
                }
            }

            return this.clientesFrecuentesDAO.registrarCliente(nuevoClienteFrecuente);
        }


        @Override
        public List<ClienteFrecuente> consultarClientesPorNombre(String filtroBusqueda) throws NegocioException {
            if (filtroBusqueda.length() > LIMITE_CARACTERES) {
                        throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                    }
                    return this.clientesFrecuentesDAO.consultarClientesPorNombre(filtroBusqueda);
        }

        @Override
        public List<ClienteFrecuente> consultarClientesPorTelefono(String filtroBusqueda) throws NegocioException {
            if (filtroBusqueda.length() > LIMITE_CARACTERES_TELEFONO) {
                        throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                    }
                    return this.clientesFrecuentesDAO.consultarClientesPorTelefono(filtroBusqueda);
        }

        @Override
        public List<ClienteFrecuente> consultarClientesPorCorreoElectronico(String filtroBusqueda) throws NegocioException {
            if (filtroBusqueda.length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
                        throw new NegocioException ("El Filtro de busqueda es demasiado largo");
                    }
                    return this.clientesFrecuentesDAO.consultarClientesPorCorreoElectronico(filtroBusqueda);
        }

        @Override
        public List<ClienteFrecuente> obtenerClientes() throws NegocioException {
            return this.clientesFrecuentesDAO.obtenerClientes();
        }

        @Override
        public ClienteFrecuente editarCliente(ClienteFrecuenteDTO clienteFrecuenteDTO) throws NegocioException {

            // Validaciones de campos obligatorios
            if (clienteFrecuenteDTO.getNombre() == null || clienteFrecuenteDTO.getNombre().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el nombre del cliente");
            }

            if (clienteFrecuenteDTO.getApellidoPaterno() == null || clienteFrecuenteDTO.getApellidoPaterno().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el apellido paterno del cliente");
            }

            if (clienteFrecuenteDTO.getApellidoMaterno() == null || clienteFrecuenteDTO.getApellidoMaterno().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el apellido materno del cliente");
            }

            if (clienteFrecuenteDTO.getTelefono() == null || clienteFrecuenteDTO.getTelefono().trim().isEmpty()) {
                throw new NegocioException("Debes proporcionar el teléfono del cliente");
            }

            // Validaciones de formato (solo letras para nombre y apellidos)
            if (!clienteFrecuenteDTO.getNombre().matches("^[a-zA-Z ]+$")) {
                throw new NegocioException("El nombre solo puede contener letras y espacios simples");
            }

            if (!clienteFrecuenteDTO.getApellidoPaterno().matches("^[a-zA-Z]+$")) {
                throw new NegocioException("El apellido paterno solo puede contener letras");
            }

            if (!clienteFrecuenteDTO.getApellidoMaterno().matches("^[a-zA-Z]+$")) {
                throw new NegocioException("El apellido materno solo puede contener letras");
            }

            // Validaciones de longitud
            if (clienteFrecuenteDTO.getNombre().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El nombre del cliente excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (clienteFrecuenteDTO.getApellidoPaterno().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El apellido paterno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (clienteFrecuenteDTO.getApellidoMaterno().length() > LIMITE_CARACTERES_NOMBRE) {
                throw new NegocioException("El apellido materno excede el límite de " + LIMITE_CARACTERES_NOMBRE + " caracteres.");
            }

            if (clienteFrecuenteDTO.getCorreoElectronico().length() > LIMITE_CARACTERES_CORREO_ELECTRONICO) {
                throw new NegocioException("El correo electrónico excede el límite de " + LIMITE_CARACTERES_CORREO_ELECTRONICO + " caracteres.");
            }

            if (clienteFrecuenteDTO.getTelefono().length() > LIMITE_CARACTERES_TELEFONO) {
                throw new NegocioException("El teléfono excede el límite de " + LIMITE_CARACTERES_TELEFONO + " caracteres.");
            }

            // Validación de formato de teléfono
            String telefono = clienteFrecuenteDTO.getTelefono();
            if (!telefono.matches("^\\+?\\d+$")) {
                throw new NegocioException("El teléfono solo puede contener números y puede comenzar con un +.");
            }

            // Validación de formato de correo electrónico
            String correo = clienteFrecuenteDTO.getCorreoElectronico();
            if (correo != null && !correo.trim().isEmpty()) {
                if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                    throw new NegocioException("El formato del correo electrónico no es válido.");
                }
            }

            return this.clientesFrecuentesDAO.editarCliente(clienteFrecuenteDTO);
        }

        @Override
        public ClienteFrecuente buscarClientePorId(Long id) throws NegocioException {
            return this.clientesFrecuentesDAO.buscarClientePorId(id);
        }

    }
