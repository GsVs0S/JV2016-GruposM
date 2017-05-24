/** 
 * Proyecto: Juego de la vida.
 * Interfaz con las operaciones básicas DAO, necesarias para la fachada.
 * @since: prototipo2.1
 * @source: OperacionesDAO.java  
 * @version: 2.1 - 2017.05.24 
 * @author: ajp
 * @modificacion:JLC
 */

package accesoDatos;

import modelo.ModeloException;

public interface OperacionesDAO {

	/**
	 * Obtiene el objeto dado el id utilizado para el almacenamiento.
	 * @param id - el idUsr de Usuario a obtener.
	 * @return - el Usuario encontrado; null si no existe.
	 */	
	Object obtener(String id);

	/**
	 * Obtiene el objeto, dado otro objeto igual.
	 * reenvía al método que utiliza id.
	 * @param obj - el Objeto a buscar.
	 * @return - el Object encontrado; null si no existe.
	 */
	Object obtener(Object obj);
	
	/**
	 *  Alta de un objeto en el almacén de datos, 
	 *  sin repeticiones, según el campo id previsto. 
	 *	@param obj - Objeto a almacenar.
	 *  @throws DatosException - si ya existe.
	 */
	void alta(Object obj) throws DatosException;
	
	/**
	 * Elimina el objeto, dado el id utilizado para el almacenamiento.
	 * @param id - el identificador del objeto a eliminar.
	 * @return - el Objeto eliminado.
	 * @throws DatosException - si no existe.
	 */
	Object baja(String id) throws DatosException;
	
	/**
	 *  Actualiza datos de un Objeto reemplazando el almacenado por el recibido.
	 *	@param obj - Objeto nuevo.
	 *  @throws DatosException - si no existe.
	 * @throws ModeloException 
	 */
	void actualizar(Object obj) throws DatosException, ModeloException;
	
	/**
	 * Obtiene el listado de todos los datos almacenados.
	 * @return el texto con el volcado de datos.
	 */
	String listarDatos();
	
	/**
	 * Obtiene el listado de todos los datos almacenados.
	 * @return el texto con el volcado de datos.
	 */
	String listarId();
	
	/**
	 *  Cierra datos.
	 */
	void cerrar();

	/**
	 * Elimina todos los datos.
	 */
	void borrarTodo();

	
} // interface
