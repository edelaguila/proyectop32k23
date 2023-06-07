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
import Ventas.Modelo.daoCotizacion;
import Ventas.Vista.frmConsultaCotizacion;
import Ventas.Vista.frmConsultaCotizacionDetalle;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsCotizacion {
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
    private String estatusCot;

    public clsCotizacion() {
    }

    public clsCotizacion(int IdCliente) {
        this.IdProducto = IdCliente;
    }

    public clsCotizacion(String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public clsCotizacion(int IdProducto, String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
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

public String getEstatusCot() {
    return estatusCot;
}

public void setEstatusCot(String estatusCot) {
    this.estatusCot = estatusCot;
}

public double getTotalCot() {
    return TotalCot;
}

public void setTotalCot(double TotalCot) {
    this.TotalCot = TotalCot;
}

    @Override
    public String toString() {
        return "clsCotizacion{" + "IdProducto=" + IdProducto + ", NombreProducto=" + NombreProducto + ", PrecioProducto=" + PrecioProducto + ", ExistenciaProducto=" + ExistenciaProducto + "IdCot=" + IdCot + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaCot=" + FechaCot + ", TotalCot=" + TotalCot +'}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsCotizacion> getListadoProductos()
    {
        daoCotizacion daoProducto = new daoCotizacion();
        List<clsCotizacion> listadoProductos = daoProducto.consultaProducto();
        return listadoProductos;
    }
    

    public String toString2() {
        return "clsCotizacion{" + "IdCot=" + IdCot + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaCot=" + FechaCot + ", TotalCot=" + TotalCot +'}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsCotizacion> getListadoCotizaciones()
    {
        daoCotizacion daoCots = new daoCotizacion();
        List<clsCotizacion> listadoCotizaciones = daoCots.consultaCotizaciones();
        return listadoCotizaciones;
    }
    
    public List<clsCotizacion> getListadoCotizacionesDetalle(int cotid)
    {
        daoCotizacion dao = new daoCotizacion();
    return dao.consultaCotizacionesDetalle(cotid);

    }
    public int verificarCotId() {
    frmConsultaCotizacion dao = new frmConsultaCotizacion();
    return dao.obtenerCotidSeleccionado();
}   
    public void RegistrarPedidoCot(int cotid2) {
    daoCotizacion dao = new daoCotizacion();
    dao.registroPedidoCot(cotid2);
} 

    
        public void RegistrarPedidoCotDet(int cotid3) {
    daoCotizacion dao = new daoCotizacion();
    dao.registroPedidoCotDet(cotid3);
} 
        
    public double obtenerPrecioProducto(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.obtenerPrecioProducto(codigoProducto);
} 
    public int verificarExistencias(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.verificarExistencias(codigoProducto);
}   
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model) {
    daoCotizacion dao = new daoCotizacion();
    dao.registrarCotizacionDetalle( cotizacionId, model);
}   
    public void registrarCotizacion(int idCliente, int idVendedor, LocalDate fecha, double total) {
    daoCotizacion dao = new daoCotizacion();
    dao.registrarCotizacion( idCliente,  idVendedor, fecha, total);
}
    public int obtenerUltimoIdCotizacion() {
    daoCotizacion dao = new daoCotizacion();
    return dao.obtenerUltimoIdCotizacion();
}
    
}
