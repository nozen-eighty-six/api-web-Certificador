package pe.company.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="productos")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "sp_actualizarproducto",
        procedureName = "sp_actualizarproducto", // Reemplaza con el nombre real de tu procedimiento almacenado
        parameters = {
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "idproducto", type = Integer.class),
            @StoredProcedureParameter(mode = ParameterMode.IN, name = "cantidadproducto", type = Integer.class)
        
        }
    )
})
public class Producto  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Double precio;
	private Integer cantidad;
	
	//Recibe un objeto Usuario

	@ManyToOne
	private Usuario usuario;
	

	@ManyToOne
	private Categoria categoria;
	

	@ManyToOne
	private Marca marca;
	
	
	//Desde producto tengo que asignarle un proveedor
	@ManyToMany
	private Set<Proveedor> itemsProveedor = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "itemsProducto")
	private Set<Pedido> itemsPedido = new HashSet<>();

	@JsonIgnore
	 @ManyToMany(mappedBy = "productos")
	    private Set<LineaPedido> lineasPedido = new HashSet<>();
	
	/*
	@ManyToOne
	private Categoria categoria;*/
	
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}






	public Producto(Integer id, String nombre, String descripcion, String imagen, Double precio, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;

	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/*
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}*/

	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Set<Proveedor> getItemsProveedor() {
		return itemsProveedor;
	}


	public void setItemsProveedor(Set<Proveedor> itemsProveedor) {
		this.itemsProveedor = itemsProveedor;
	}
	


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public Set<Pedido> getItemsPedido() {
		return itemsPedido;
	}


	public void setItemsPedido(Set<Pedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
}
