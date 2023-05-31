/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Meyglin del Rosario Rosales Ochoa 
// 9959 - 21 - 4490 

package Ventas.Controlador;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Ventas.Modelo.daoPedidos;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsPedidos {
    private int IdProducto;
    private String NombreProducto;
    private Double PrecioProducto;
    private int ExistenciaProducto;
    private int IdCliente;
    private int IdPed;
    private String FechaPed;
    private String estatusPed;
    private double TotalPed;
    private int CantidadProducto;

    public clsPedidos() {
    }

    public clsPedidos(int IdCliente) {
        this.IdProducto = IdCliente;
    }

    public clsPedidos(String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public clsPedidos(int IdProducto, String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }


public Double getPrecioProducto() {
    return PrecioProducto;
}

public void setPrecioProducto(Double PrecioProducto) {
    this.PrecioProducto = PrecioProducto;
}

public int getExistenciaProducto() {
    return ExistenciaProducto;
}


public void setExistenciaProducto(int ExistenciaProducto) {
    this.ExistenciaProducto = ExistenciaProducto;
}
public void setCantidadProducto(int CantidadProducto) {
    this.CantidadProducto = CantidadProducto;
}

public int getCantidadProducto() {
    return CantidadProducto;
}
public int getIdPed() {
    return IdPed;
}

public void setIdPed(int IdPed) {
    this.IdPed = IdPed;
}

public int getIdCliente() {
    return IdCliente;
}

public void setIdCliente(int IdCliente) {
    this.IdCliente = IdCliente;
}

public String getFechaPed() {
    return FechaPed;
}

public void setFechaPed(String FechaPed) {
    this.FechaPed = FechaPed;
}

public double getTotalPed() {
    return TotalPed;
}

public void setTotalPed(double TotalPed) {
    this.TotalPed = TotalPed;
}

public String getEstatusPed() {
    return estatusPed;
}

public void setEstatusPed(String estatusPed) {
    this.estatusPed = estatusPed;
}

    @Override
    public String toString() {
        return "clsPedidos{" + "IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", PrecioProducto=" + PrecioProducto + ", ExistenciaProducto=" + ExistenciaProducto + '}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsPedidos> getListadoProductos()
    {
        daoPedidos daoProducto = new daoPedidos();
        List<clsPedidos> listadoProductos = daoProducto.consultaProducto();
        return listadoProductos;
    }
    
    public List<clsPedidos> getListadoPedidos()
    {
        daoPedidos daoCots = new daoPedidos();
        List<clsPedidos> listadoPedidos = daoCots.consultaPedidos();
        return listadoPedidos;
    }
    
    public List<clsPedidos> getListadoPedidosDetalle(int cotid)
    {
        daoPedidos dao = new daoPedidos();
    return dao.consultaPedidosDetalle(cotid);

    }
        
    public double obtenerPrecioProducto(int codigoProducto) {
    daoPedidos dao = new daoPedidos();
    return dao.obtenerPrecioProducto(codigoProducto);
} 
    public int verificarExistencias(int codigoProducto) {
    daoPedidos dao = new daoPedidos();
    return dao.verificarExistencias(codigoProducto);
}   
    public void registrarPedidoDetalle(int pedidoId, DefaultTableModel model) {
    daoPedidos dao = new daoPedidos();
    dao.registrarPedidoDetalle( pedidoId, model);
}   
    public void registrarPedido(int idCliente, LocalDate fecha, double total) {
    daoPedidos dao = new daoPedidos();
    dao.registrarPedido( idCliente, fecha, total);
}
    public int obtenerUltimoIdPedido() {
    daoPedidos dao = new daoPedidos();
    return dao.obtenerUltimoIdPedido();
}
    
        public void RegistrarPedidoCot(int cotid2, int idvendedor, String tienda, double descuento) {
    daoPedidos dao = new daoPedidos();
    dao.registroPedidoCot(cotid2, idvendedor, tienda, descuento);
} 
    public ArrayList<String> obtenerNombresUsuarios() {
    daoPedidos dao = new daoPedidos();
    return dao.obtenerNombresUsuarios();
    }
    
        public void RegistrarPedidoCotDet(int cotid3, double descuento) {
    daoPedidos dao = new daoPedidos();
    dao.registroPedidoCotDet(cotid3, descuento);
} 
        
        public void CancelarPedido(int cotid4){
            daoPedidos dao = new daoPedidos();
            dao.cancelarPedido(cotid4);
        }
    
}
