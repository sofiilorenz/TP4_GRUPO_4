package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.SeguroDao;
import dao.TipoSeguroDao;
import dominio.Seguro;
import dominio.TipoSeguro;


@WebServlet("/ServletSeguro")
public class ServletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    	SeguroDao sDao = new SeguroDao();

		//agregar seguro (viene del boton Aceptar de AgregarSeguro.jsp)
        if(request.getParameter("btnAceptar") != null)
                {
        			int filas = 0;
        			try {
        				Seguro s = new Seguro();

        				s.setDescripcion(request.getParameter("txtDescripcion"));
        				s.setCostoAsegurado(Integer.parseInt(request.getParameter("txtCostoAsegurado")));
        				s.setCostoContratacion(Integer.parseInt(request.getParameter("txtCostoContratacion")));
        				s.setIdTipo(Integer.parseInt(request.getParameter("idTipo")));

        				filas = sDao.agregarSeguro(s);
        			}
        			catch(NumberFormatException e) {
        				//algun costo vacio o con texto, o no hay tipo de seguro seleccionado
        				System.out.println("Error de formato numerico: " + e.getMessage());
        			}
                    request.setAttribute("cantFilas", filas); //envio la info a agregarSeguro
                }

		//siempre cargo los tipos de seguro para la ddl y el proximo id
        //(tanto al entrar por el link ?Param=agregar como despues de agregar)
		TipoSeguroDao tDao = new TipoSeguroDao();
		ArrayList<TipoSeguro> lista = tDao.listarTipos();
		System.out.println("Cantidad de tipos: " + lista.size());

		request.setAttribute("listaTipos", lista);
		request.setAttribute("proximoId", sDao.obtenerProximoId());

        //REDIRECCIONAR A LA OTRA PAG
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
