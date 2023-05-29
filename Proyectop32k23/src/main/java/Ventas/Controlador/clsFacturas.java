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
import Ventas.Modelo.daoFacturas;
import Ventas.Vista.frmConsultaCotizacion;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsFacturas {
    private int IdProducto;
    private String NombreProducto;
    private Double PrecioProducto;
    private int ExistenciaProducto;
    private int CantidadProducto;
    private int IdCliente;
    private int IdVendedor;
    private int IdCot;
    private String FechaCot;
    private double TotalCot;

    public clsFacturas() {
    }

    public clsFacturas(int IdCliente) {
        this.IdProducto = IdCliente;
    }

    public ArrayList<String> obtenerNombresUsuarios() {
    daoFacturas dao = new daoFacturas();
    return dao.obtenerNombresUsuarios();
    }
    public clsFacturas(String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public clsFacturas(int IdProducto, String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
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

public void setCantidadProducto(int CantidadProducto) {
    this.CantidadProducto = CantidadProducto;
}

public int getCantidadProducto() {
    return CantidadProducto;
}
public void setExistenciaProducto(int ExistenciaProducto) {
    this.ExistenciaProducto = ExistenciaProducto;
}

public int getIdCot() {
    return IdCot;
}

public void setIdCot(int IdCot) {
    this.IdCot = IdCot;
}

public int getIdCliente() {
    return IdCliente;
}

public void setIdCliente(int IdCliente) {
    this.IdCliente = IdCliente;
}

public int getIdVendedor() {
    return IdVendedor;
}

public void setIdVendedor(int IdVendedor) {
    this.IdVendedor = IdVendedor;
}

public String getFechaCot() {
    return FechaCot;
}

public void setFechaCot(String FechaCot) {
    this.FechaCot = FechaCot;
}

public double getTotalCot() {
    return TotalCot;
}

public void setTotalCot(double TotalCot) {
    this.TotalCot = TotalCot;
}

    @Override
    public String toString() {
        return "clsFacturas{" + "IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", PrecioProducto=" + PrecioProducto + ", ExistenciaProducto=" + ExistenciaProducto + "IdCot=" + IdCot + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaCot=" + FechaCot + ", TotalCot=" + TotalCot +'}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsFacturas> getListadoProductos()
    {
        daoFacturas daoProducto = new daoFacturas();
        List<clsFacturas> listadoProductos = daoProducto.consultaProducto();
        return listadoProductos;
    }
    

    public String toString2() {
        return "clsFacturas{" + "IdCot=" + IdCot + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaCot=" + FechaCot + ", TotalCot=" + TotalCot +'}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsFacturas> getListadoCotizaciones()
    {
        daoFacturas daoCots = new daoFacturas();
        List<clsFacturas> listadoCotizaciones = daoCots.consultaCotizaciones();
        return listadoCotizaciones;
    }
    
    public List<clsFacturas> getListadoCotizacionesDetalle(int cotid)
    {
        daoFacturas dao = new daoFacturas();
    return dao.consultaCotizacionesDetalle(cotid);

    }
    public int verificarCotId() {
    frmConsultaCotizacion dao = new frmConsultaCotizacion();
    return dao.obtenerCotidSeleccionado();
}   
    public void RegistrarPedidoCot(int cotid2) {
    daoFacturas dao = new daoFacturas();
    dao.registroPedidoCot(cotid2);
} 

    
        public void RegistrarPedidoCotDet(int cotid3) {
    daoFacturas dao = new daoFacturas();
    dao.registroPedidoCotDet(cotid3);
} 
        
    public double obtenerPrecioProducto(int codigoProducto) {
    daoFacturas dao = new daoFacturas();
    return dao.obtenerPrecioProducto(codigoProducto);
} 
    public int verificarExistencias(int codigoProducto) {
    daoFacturas dao = new daoFacturas();
    return dao.verificarExistencias(codigoProducto);
}   
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model) {
    daoFacturas dao = new daoFacturas();
    dao.registrarCotizacionDetalle( cotizacionId, model);
}   
    public void registrarCotizacion(int idCliente, int idVendedor, LocalDate fecha, double total) {
    daoFacturas dao = new daoFacturas();
    dao.registrarCotizacion( idCliente,  idVendedor, fecha, total);
}
    public int obtenerUltimoIdCotizacion() {
    daoFacturas dao = new daoFacturas();
    return dao.obtenerUltimoIdCotizacion();
}
    
}
