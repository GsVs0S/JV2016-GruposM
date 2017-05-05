/** 
 * Proyecto: Juego de la vida.
 * Es un punto del espacio donde se ubica un Patron de celulas, según el modelo 2
 * @since: prototipo2.0
 * @source: Posicion.java 
 * @version: 2.1 - 2017.05.03
 * @author: ajp
 * @author: Victor Ruiz Grupo 4
 */

package modelo;

import java.io.Serializable;

public class Posicion implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;

	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos.
	 * Utiliza métodos set... para la posible verificación.
	 * @param x
	 * @param y
	 */
	public Posicion(int x, int y) throws ModeloException {
		setX(x);
		setY(y);
	}

	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Posicion() throws ModeloException {
		this(0, 0);
	}

	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase.
	 * @param p
	 */
	public Posicion(Posicion p) throws ModeloException {
		this(p.x, p.y);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) throws ModeloException {
		if(posicionValida(x)){
		this.x = x;
		}
		throw new ModeloException("No se permiten posiciones negativas");
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) throws ModeloException {
		if(posicionValida(y)){
		this.y = y;
		}
		throw new ModeloException("No se permiten posciones negativas");
	}
	private boolean posicionValida(int posicion){
		if(posicion>=0){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

	/**
	 * hashCode() complementa al método equals y sirve para comparar objetos de forma 
	 * rápida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al método hashcode y luego el equals.
	 * @return un número entero de 32 bit.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
			if (x == ((Posicion)obj).x &&
					y == ((Posicion)obj).y
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
		//Utiliza el constructor copia.
		Object clon = null;
		try {
			clon = new Posicion(this);
		}
		catch (ModeloException e) {}
		return clon;
	}

} //class
