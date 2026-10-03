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
		TipoSeguroDao tDao = new TipoSeguroDao();

		if (request.getParameter("Param") != null) {

			ArrayList<Seguro> listaSeguros = sDao.obtenerSeguros();

			request.setAttribute("listaS", listaSeguros);
			request.setAttribute("listaTipos", tDao.listarTipos());

			RequestDispatcher rdS = request.getRequestDispatcher("/ListarSeguros.jsp");
			rdS.forward(request, response);
			return;
		}
		
		if(request.getParameter("btnFiltrar")!=null)
		{
			int idTipo = Integer.parseInt(request.getParameter("ddlTipoFiltro"));
			ArrayList<Seguro> listaSeguros = sDao.obtenerSegurosPorTipo(idTipo);

			request.setAttribute("listaS", listaSeguros);
			request.setAttribute("listaTipos", tDao.listarTipos());

			RequestDispatcher rdF = request.getRequestDispatcher("/ListarSeguros.jsp");
			rdF.forward(request, response);
			return;
		}

		if (request.getParameter("btnAceptar") != null) {
			int filas = 0;
			try {
				Seguro s = new Seguro();

				s.setDescripcion(request.getParameter("txtDescripcion"));
				s.setCostoAsegurado(Integer.parseInt(request.getParameter("txtCostoAsegurado")));
				s.setCostoContratacion(Integer.parseInt(request.getParameter("txtCostoContratacion")));
				s.setIdTipo(Integer.parseInt(request.getParameter("idTipo")));

				filas = sDao.agregarSeguro(s);
			} catch (NumberFormatException e) {
				System.out.println("Error de formato numerico: " + e.getMessage());
			}
			request.setAttribute("cantFilas", filas);
		}

		ArrayList<TipoSeguro> lista = tDao.listarTipos();

		request.setAttribute("listaTipos", lista);
		request.setAttribute("proximoId", sDao.obtenerProximoId());

		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
