
public class Metodo {
	public String nombre;
	public Integer fanIn;
	public Integer fanOut;
	public Integer nroCiclomatico;
	public int definicion;
	public Integer cantLineasTotales = 0;
    public Integer cantComentarios = 0;
	public Integer cantCodigo = 0;
	
	public Metodo()
	{
		nombre = new String();
		fanIn = fanOut = -1;
		nroCiclomatico = 1;
		definicion = -1; 
	}
	
	public Metodo(Metodo obj) 
	{
		this.nombre = obj.nombre;
		this.fanIn = obj.fanIn;
		this.fanOut = obj.fanOut;
		this.nroCiclomatico = obj.nroCiclomatico;
		this.definicion = obj.definicion;
	}

	public boolean equals(Object obj)
	{
		if (obj != null)
		{
			if (obj.getClass() == this.getClass())
			{
				Metodo met = new Metodo((Metodo) obj);
				if (this.nombre.equalsIgnoreCase(met.nombre))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public String toString()
	{
		return "Nombre: " + nombre + "\nFanIn: " + fanIn + "\nFanOut: " + fanOut + "\nNro Ciclomatico: " + nroCiclomatico + "\nDefinicion: " + definicion;
	}

}
