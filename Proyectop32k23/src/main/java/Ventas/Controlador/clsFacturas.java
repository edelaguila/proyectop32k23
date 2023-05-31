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
import Ventas.Modelo.daoPedidos;
import Ventas.Vista.frmConsultaCotizacion;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsFacturas {
    private int IdProducto;
    private int IdFactura;//
    private int IdTienda;//
    private String NombreProducto;
    private Double PrecioProducto;
    private int ExistenciaProducto;
    private double CantidadProducto;
    private int IdCliente;//
    private int IdVendedor;//
    private int IdPedido;
    private String FechaFactura;//
    private double TotalFactura;//
    private int CodigoProducto;
    private Double DescuentoFactura;//
    private Double ImpuestosFactura;
    private Double TotalIndividualFactura;
    
    

    public clsFacturas() {
    }

    public clsFacturas(int IdCliente) {
        this.IdFactura = IdCliente;
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

    public clsFacturas(int IdFactura, String NombreProducto, double PrecioProducto, int ExistenciaProducto) {
        this.IdFactura = IdFactura;
        this.NombreProducto = NombreProducto;
        this.PrecioProducto = PrecioProducto;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
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

public void setCantidadProducto(double CantidadProducto) {
    this.CantidadProducto = CantidadProducto;
}

public double getCantidadProducto() {
    return CantidadProducto;
}
public void setExistenciaProducto(int ExistenciaProducto) {
    this.ExistenciaProducto = ExistenciaProducto;
}

public int getIdPedido() {
    return IdPedido;
}

public void setIdPedido(int IdPedidos) {
    this.IdPedido = IdPedidos;
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

public String getFechaFactura() {
    return FechaFactura;
}

public void setFechaFactura(String FechaFactura) {
    this.FechaFactura = FechaFactura;
}

public double getTotalFactura() {
    return TotalFactura;
}

public void setTotalFactura(double TotalFactura) {
    this.TotalFactura = TotalFactura;
}
public int getIdTienda() {
    return IdTienda;
}

public void setIdTienda(int IdTienda) {
    this.IdTienda = IdTienda;
}
public int getCodigoProducto() {
    return CodigoProducto;
}

public void setCodigoProducto(int CodigoProducto) {
    this.CodigoProducto = CodigoProducto;
}
public Double getDescuentoFactura() {
    return DescuentoFactura;
}

public void setDescuentoFactura(Double DescuentoFactura) {
    this.DescuentoFactura = DescuentoFactura;
}
public Double getImpuestosFactura() {
    return ImpuestosFactura;
}

public void setImpuestosFactura(Double ImpuestosFactura) {
    this.ImpuestosFactura = ImpuestosFactura;
}
public Double getTotalIndividualFactura() {
    return TotalIndividualFactura;
}

public void setTotalIndividualFactura(Double TotalIndividualFactura) {
    this.TotalIndividualFactura = TotalIndividualFactura;
}
public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }


    @Override
    public String toString() {
        return "clsFacturas{" + "IdFactura=" + IdFactura + ", NombreProducto=" + NombreProducto + ", PrecioProducto=" + PrecioProducto + ", ExistenciaProducto=" + ExistenciaProducto + "IdPedido=" + IdPedido + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaFactura=" + FechaFactura + ", TotalFactura=" + TotalFactura +", CodigoProducto=" + CodigoProducto +'}';
    }
    //Metodos de acceso a la capa controlador
 
    public List<clsFacturas> getListadoProductos()
    {
        daoFacturas daoProducto = new daoFacturas();
        List<clsFacturas> listadoProductos = daoProducto.consultaProducto();
        return listadoProductos;
    }
    

    public String toString2() {
        return "clsFacturas{" + "IdPedido=" + IdPedido + ", IdCliente=" + IdCliente + ", IdVendedor=" + IdVendedor + ", FechaFactura=" + FechaFactura + ", TotalFactura=" + TotalFactura +'}';
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
    public void registrarCotizacionDetalle(int cotizacionId, DefaultTableModel model, double descuento) {
    daoFacturas dao = new daoFacturas();
    dao.registrarCotizacionDetalle( cotizacionId, model, descuento);
}   
    public void registrarCotizacion(int idCliente, int idVendedor, String idTienda, LocalDate fecha, double total) {
    daoFacturas dao = new daoFacturas();
    dao.registrarCotizacion( idCliente,  idVendedor, idTienda, fecha, total);
}
    public int obtenerUltimoIdCotizacion() {
    daoFacturas dao = new daoFacturas();
    return dao.obtenerUltimoIdCotizacion();
}
    
    public void CancelarPedido(int cotid4, int idcliente2){
            daoFacturas dao = new daoFacturas();
            dao.cancelarPedido(cotid4, idcliente2);
        }
    
    
}
