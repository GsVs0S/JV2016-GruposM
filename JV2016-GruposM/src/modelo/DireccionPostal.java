/** Proyecto: Juego de la vida.
 *  Implementa el concepto de direccion postal según el modelo 2.
 *  Se hace validacialón de datos pero no se gestionan todavÃ­a los errores correspondientes.
 *  @since: prototipo1.2
 *  @source: DireccionPostal.java 
 *  @version: 2.1 - 2017.03.30
 *  @author: ajp
 *  @author: Jesus Lopez, Grupo2 (David, Samuel, Sandra, Ruben, Alejandro, Jesus)
 */

package modelo;

import java.io.Serializable;
import util.Formato;

public class DireccionPostal implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String calle;
	private String numero;
	private String cp;
	private String poblacion;

	public DireccionPostal(String calle, String numero, String cp, String poblacion) throws ModeloException {
		setCalle(calle);
		setNumero(numero);
		setCP(cp);
		setPoblacion(poblacion);
	}

	public DireccionPostal() throws ModeloException {
		this("Calle", "00", "99999", "Población");
	}

	public DireccionPostal(DireccionPostal direccion) throws ModeloException {
		this(direccion.calle, direccion.numero, direccion.cp, 
				direccion.poblacion);
	}

	public void setCalle(String calle) throws ModeloException {
		if(calleValida(calle)){
			this.calle = calle;
			return;
		}
		throw new ModeloException ( "La calle " + calle +" no es válida" );
	}

	/**
	 * Comprueba validez de la calle.
	 * @param via.
	 * @return true si cumple.
	 */
	private boolean calleValida(String calle) {
		assert calle != null;
				return util.Formato.validar(calle, Formato.PATRON_NOMBRE_VIA)
				&& calleAutentica(calle);
	}

	/**
	 * Comprueba que existe la calle.
	 * @param calle.
	 * @return true si cumple.
	 */
	private boolean calleAutentica(String calle) {
		// Comprueba que la calle no es falsa.
		//--Pendiente--
		return true;
	}

	public void setNumero(String numero) throws ModeloException {
		if (numeroValido(numero)) {
			this.numero = numero;
			return;
		}
		throw new ModeloException ( "El número " + numero +" no es válido" );
	}

	/**
	 * Comprueba validez de la vía pública.
	 * @param via.
	 * @return true si cumple.
	 */
	private boolean numeroValido(String numero) {
		assert numero != null;
				return util.Formato.validar(numero, Formato.PATRON_NUMERO_POSTAL);
			
	}

	public void setCP(String cp) throws ModeloException {
		if (codigoPostalValido(cp)){
			this.cp = cp;
			return;
		}
		throw new ModeloException ( "El código postal " + cp +" no es válido" );
	}

	/**
	 * Comprueba validez de un código Postal.
	 * @param codigoPostal.
	 * @return true si cumple.
	 */
	private boolean codigoPostalValido(String codigoPostal) {
		assert codigoPostal != null;
				return util.Formato.validar(codigoPostal, Formato.PATRON_CP) 
				&& codigoPostalAutentico(codigoPostal);
	}

	/**
	 * Comprueba que existe el cÃ³digo postal.
	 * @param codigoPostal.
	 * @return true si cumple.
	 */
	private boolean codigoPostalAutentico(String codigoPostal) {
		// Comprueba que el codigo postal no es falso. 
		//--Pendiente--
		return true;
	}

	public void setPoblacion(String poblacion) throws ModeloException {
		if (poblacionValida(poblacion)){
			this.poblacion = poblacion;
			return;
		}
		throw new ModeloException ( "La población " + poblacion +" no es válido" );
	}

	/**
	 * Comprueba validez de la poblacion.
	 * @param poblacion.
	 * @return true si cumple.
	 */
	private boolean poblacionValida(String poblacion) {
		
		assert poblacion != null;
		return util.Formato.validar(poblacion, Formato.PATRON_TOPONIMO)
			&& poblacionAutentica(poblacion);
		
	}

	/**
	 * Comprueba que existe la poblaciÃ³n.
	 * @param poblacion.
	 * @return true si cumple.
	 */
	private boolean poblacionAutentica(String poblacion) {
		// Comprueba que la población no es falsa.
		//--Pendiente--
		return true;
	}

	public String getCodigoPostal() {
		return calle;
	}

	public String getCalle() {
		return calle;
	}


	public String getNumero() {
		return numero;
	}

	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado -valores de atributos- de objeto de la clase Usuario.  
	 */
	@Override
	public String toString() {
		return String.format(
				"calle: %s\t"
						+ "numero: %s\t"
						+ "cp: %s\t"
						+ "poblacion: %s\n",
						calle, numero, cp, poblacion);		
	}

	/**
	 * hashCode() complementa al método equals y sirve para comparar objetos de forma 
	 * rápida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al mé©todo hashcode y luego el equals.
	 * @return un nÃºmero entero de 32 bit.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((poblacion == null) ? 0 : poblacion.hashCode());
		return result;
	}

	/**
	 * Dos objetos son iguales si: 
	 * Son de la misma clase.
	 * Tienen los mismos valores en los atributos; o son el mismo objeto.
	 * @return falso si no cumple las condiciones.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (calle.equals(((DireccionPostal)obj).calle) &&
					cp.equals(((DireccionPostal)obj).cp) &&
					numero.equals(((DireccionPostal)obj).numero) &&
					poblacion.equals(((DireccionPostal)obj).poblacion)
					) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Genera un clon del propio objeto realizando una copia profunda.
	 * @return el objeto clonado.
	 */
	@Override
	public Object clone() {
		Object clon = null;
		try {
			clon = new DireccionPostal(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clon;
	}

} // class
