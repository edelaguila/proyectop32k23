/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoClientes;
/**
 *
 * @author visitante
 */
//Carlos Javier Sandoval Catalán
//9959-21-1324
//clsClientes

public class clsClientes {
    private int IdCliente;
    private String NombreCliente;
    private String EstatusCliente;
    private String EstatusCliente2;
    private String TelefonoCliente;
    private String EmailCliente;
    private String NitCliente;
    private Double HaberCliente;
    private Double DebeCliente;

    public clsClientes() {
    }

    public clsClientes(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public clsClientes(String NombreCliente, String EstatusCliente, String TelefonoCliente, String EmailCliente, String NitCliente, double HaberCliente, double DebeCliente, String EstatusCliente2) {
        this.NombreCliente = NombreCliente;
        this.EstatusCliente = EstatusCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.EmailCliente =EmailCliente;
        this.NitCliente = NitCliente;
        this.HaberCliente = HaberCliente;
        this.DebeCliente = DebeCliente;
        this.EstatusCliente2 = EstatusCliente2;
    }

    public clsClientes(int IdCliente, String NombreCliente, String EstatusCliente, String TelefonoCliente, String EmailCliente, String NitCliente, double HaberCliente, double DebeCliente, String EstatusCliente2) {
        this.IdCliente = IdCliente;
        this.NombreCliente = NombreCliente;
        this.EstatusCliente = EstatusCliente;
        this.TelefonoCliente = TelefonoCliente;
        this.EmailCliente =EmailCliente;
        this.NitCliente = NitCliente;
        this.HaberCliente = HaberCliente;
        this.DebeCliente = DebeCliente;
        this.EstatusCliente2 = EstatusCliente2;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getEstatusCliente() {
        return EstatusCliente;
    }

    public void setEstatusCliente(String EstatusCliente) {
        this.EstatusCliente = EstatusCliente;
    }
    
        public String getEstatusCliente2() {
        return EstatusCliente2;
    }

    public void setEstatusCliente2(String EstatusCliente2) {
        this.EstatusCliente2 = EstatusCliente2;
    }

    public String getTelefonoCliente() {
    return TelefonoCliente;
}

public void setTelefonoCliente(String TelefonoCliente) {
    this.TelefonoCliente = TelefonoCliente;
}

public String getEmailCliente() {
    return EmailCliente;
}

public void setEmailCliente(String EmailCliente) {
    this.EmailCliente = EmailCliente;
}

public String getNitCliente() {
    return NitCliente;
}

public void setNitCliente(String NitCliente) {
    this.NitCliente = NitCliente;
}

public Double getHaberCliente() {
    return HaberCliente;
}

public void setHaberCliente(Double HaberCliente) {
    this.HaberCliente = HaberCliente;
}

public Double getDebeCliente() {
    return DebeCliente;
}

public void setDebeCliente(Double DebeCliente) {
    this.DebeCliente = DebeCliente;
}


    @Override
    public String toString() {
        return "clsClientes{" + "IdCliente=" + IdCliente + ", NombreCliente=" + NombreCliente + ", EstatusCliente=" + EstatusCliente + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionClientePorNombre(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientePorNombre(cliente);
    }
    public clsClientes getBuscarInformacionClientePorId(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.consultaClientePorId(cliente);
    }    
    public List<clsClientes> getListadoClientes()
    {
        daoClientes daocliente = new daoClientes();
        List<clsClientes> listadoClientes = daocliente.consultaCliente();
        return listadoClientes;
    }
    public int setBorrarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.borrarCliente(cliente);
    }          
    public int setIngresarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.ingresaCliente(cliente);
    }              
    public int setModificarCliente(clsClientes cliente)
    {
        daoClientes daocliente = new daoClientes();
        return daocliente.actualizaCliente(cliente);
    }              
}
