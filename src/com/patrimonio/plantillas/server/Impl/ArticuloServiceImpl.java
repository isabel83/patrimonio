package com.patrimonio.plantillas.server.Impl;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.patrimonio.plantillas.server.DAOs.ArticuloDao;
import com.patrimonio.plantillas.shared.DTOs.ArticuloDTO;
import com.patrimonio.plantillas.shared.DTOs.ArticuloProDTO;
import com.patrimonio.plantillas.shared.services.ArticuloService;


@RemoteServiceRelativePath("articulos")
public class ArticuloServiceImpl implements ArticuloService{

	public ArticuloDao articuloDAO;
//	private static final String SQL_SELECT =
//            "SELECT id_articulo, id_seccion, id_familia, id_subfamilia, codigo, nombre, marca, n_minimo, n_idoneo, observaciones, id_estado "
//            + "  FROM Articulo where id_articulo= ?";
	
	
	@Override
	public ArticuloDTO findArticulo(long idArticulo) {
		return articuloDAO.findById(idArticulo).get(0);

	}

	@Override
	public void saveArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
		  ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo).get(0);
		  if(articuloDTO == null) {
			  articuloDTO = new ArticuloDTO(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
			 // articuloDAO.persist(articuloDTO);
		  }
		
	}

	@Override
	public void updateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observaciones, int estado)
			throws Exception {
		ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo).get(0); 
		   
		  if(articuloDTO != null) { 
		   articuloDTO.setId_seccion(seccion);
		   articuloDTO.setId_familia(familia);
		   articuloDTO.setId_subfamilia(subFamilia);
		   articuloDTO.setCodigo(codigo);
		   articuloDTO.setNombre(nombre);
		   articuloDTO.setMarca(marca);
		   articuloDTO.setN_minimo(numMin);
		   articuloDTO.setN_idoneo(numIdeal);
		   articuloDTO.setObservaciones(observaciones);
		   articuloDTO.setId_estado(estado);
		  } 
		
	}

	@Override
	public void saveOrUpdateArticulo(long idArticulo, int seccion, int familia,int subFamilia, int codigo, String nombre, String marca,int numMin, int numIdeal, String observacion, int estado)
			throws Exception {
		
//		ArticuloDTO articuloDTO = new ArticuloDTO(idArticulo, seccion, familia, subFamilia, codigo,nombre,marca, numMin, numIdeal, observacion,estado);
//		articuloDAO.merge(articuloDTO);
	
	}

	@Override
	public void deleteArticulo(long idArticulo) throws Exception {
		
//		ArticuloDTO articuloDTO = articuloDAO.findById(idArticulo);
//		 
//		if(articuloDTO != null) {
//			articuloDAO.remove(articuloDTO);
//		}
	}

	@Override
	public List<ArticuloDTO> loadArticulosPro(int idProveedor) {
		List<ArticuloDTO> lstArticulos = null;
		List<ArticuloProDTO> todos = articuloDAO.findArtProveedor(idProveedor);
		for(ArticuloProDTO art: todos){
			lstArticulos.add(articuloDAO.findById(Long.parseLong(String.valueOf(art.getArticulo()))).get(0));
		}
		return lstArticulos;
	}
	
//	 public ArticuloDTO load(ArticuloDTO dto, Connection conn) throws SQLException {
//	        PreparedStatement ps = null;
//	        ResultSet rs = null;
//	        try {
//	            ps = conn.prepareStatement(SQL_SELECT);
//	            ps.setLong(1, dto.getId_articulo());
//	            rs = ps.executeQuery();
//	            List results = getResults(rs);
//	            if (results.size() > 0) {
//	                return (ArticuloDTO) results.get(0);
//	            } else {
//	                return null;
//	            }
//	        } finally {
//	            cerrar(rs);
//	            cerrar(ps);
//	            cerrar(conn);
//	        }
//	    }
//	 
//	 private List getResults(ResultSet rs) throws SQLException {
//	        List results = new ArrayList();
//	        while (rs.next()) {
//	            ArticuloDTO dto = new ArticuloDTO();
//	            dto.setId_articulo(rs.getLong("id_articulo"));
//	            dto.setId_seccion(rs.getInt("id_seccion"));
//	            dto.setId_familia(rs.getInt("id_familia"));
//	            dto.setId_subfamilia(rs.getInt("id_subfamilia"));
//	            dto.setCodigo(rs.getInt("codigo"));
//	            dto.setNombre(rs.getString("nombre"));
//	            dto.setMarca(rs.getString("marca"));
//	            dto.setN_minimo(rs.getInt("n_minimo"));
//	            dto.setN_idoneo(rs.getInt("n_idoneo"));
//	            dto.setObservaciones(rs.getString("observaciones"));
//	            dto.setId_estado(rs.getInt("id_estado"));
//	            results.add(dto);
//	        }
//	        return results;
//	    }
//
//	 private void cerrar(PreparedStatement ps) throws SQLException {
//	        if (ps != null) {
//	            try {
//	                ps.close();
//	            } catch (SQLException e) {
//	            }
//	        }
//	    }
//	    private void cerrar(ResultSet rs) {
//	        if (rs != null) {
//	            try {
//	                rs.close();
//	            } catch (SQLException e) {
//	            }
//	        }
//	    }
//	    private void cerrar(Connection cnn) {
//	        if (cnn != null) {
//	            try {
//	                cnn.close();
//	            } catch (SQLException e) {
//	            }
//	        }
//	    }
}
