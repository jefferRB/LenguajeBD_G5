
package ora_query;

import com.example.demo.dao.ClienteDao;
import com.example.demo.domain.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jefferson
 */
public class Ora_Cliente {
    

    private String mensaje = "";
    @Autowired
    private ClienteDao clienteDao;

    public String agregarCliente(Connection con, Cliente cliente) {
        String sql = "{call cliente_pkg.create_cliente(?,?,?,?,?,?,?,?)}";
        try {
            System.out.println("SE INTENTOOOO");
            CallableStatement statement = con.prepareCall(sql);
            statement.setLong(1, cliente.getClienteId());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getPApellido());
            statement.setString(4, cliente.getSApellido());
            statement.setString(5, cliente.getCorreo());
            statement.execute();
        } catch (SQLException e) {
            mensaje = "No se pudo guardar correctamente \n" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarCliente(Connection con, Cliente cliente) {
        PreparedStatement pst = null;
        String sql = "{call cleinte_pkg.update_cliente(?,?,?,?,?,?)}";
        try {
            CallableStatement statement = con.prepareCall(sql);
            statement.setLong(1, cliente.getClienteId());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getPApellido());
            statement.setString(4, cliente.getSApellido());
            statement.setString(5, cliente.getCorreo());
    
            System.out.println("Modificado correctamente......");
            statement.execute();

        } catch (SQLException e) {
            mensaje = "No se pudo guardar correctamente \n" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(Connection con, long clienteId) {
        String sql = "{call cliente_pkg.delete_cliente(?)}";
        try {
            CallableStatement statement = con.prepareCall(sql);
            statement.setLong(1, clienteId);
            statement.execute();
        } catch (Exception e) {
            mensaje = "No se pudo guardar correctamente\n" + e.getMessage();
        }
        return mensaje;
    }

    public List<Cliente> ListarClientes(Connection con) {
        String sql = "{call cliente_pkg.buscar_clientes(?)}";
        List<Cliente> LstClientes = new ArrayList<>();

        ResultSet rs = null;
        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Cliente cli = new Cliente();

                cli.setClienteId(Long.parseLong(rs.getString(1)));
                cli.setNombre(rs.getString(2));
                cli.setPApellido(rs.getString(3));
                cli.setSApellido(rs.getString(4));
                cli.setCorreo(rs.getString(5));


                LstClientes.add(cli);
            }
            System.out.println("listado x Sp");
        } catch (SQLException e) {
            mensaje = "No se pudo guardar correctamente \n" + e.getMessage();
        }
        return LstClientes;
    }

    public Cliente ClienteByClienteId(Connection con, Cliente cliente) {

        String sql = "{call sp_read_un_cliente(?,?)}";
        Cliente cli = new Cliente();
        ResultSet rs = null;

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.setLong(2, cliente.getClienteId());
            cs.execute();
            rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                cli.setClienteId(Long.parseLong(rs.getString(1)));
                cli.setNombre(rs.getString(2));
                cli.setPApellido(rs.getString(3));
                cli.setSApellido(rs.getString(4));
                cli.setCorreo(rs.getString(5));
            }

        } catch (SQLException e) {
            mensaje = "No se pudo guardar correctamente \n" + e.getMessage();
        }
        System.out.println("Finalizó Carga por Id");
        return cli;
    }

    public int getClientesSize(Connection con) {

        String sql = "{? = call fn_obtener_cantidad_clientes ()}";
        ResultSet rs = null;

        try {
            CallableStatement cs = con.prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.VARCHAR);
            cs.execute();

            int total = ((OracleCallableStatement) cs).getInt(1);
            return total;

        } catch (SQLException e) {
            mensaje = "No se pudo guardar correctamente \n" + e.getMessage();
            return 0;
        }
    }

}
