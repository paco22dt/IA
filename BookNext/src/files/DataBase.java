package files;
import java.sql.*;
import java.util.ArrayList;


public class DataBase {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host="localhost";
	final private String user = "root";
	final private String password = "";
	final private String database= "dbbooknext";
	
	public void connectToDB() throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?" + "user=" +  user + "&password=" + password); 
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public void readBooks() throws Exception {
		try
		{
			statement = connect.createStatement();
			resultSet = statement.executeQuery("select * from book");
			while(resultSet.next())
			{
				int id = resultSet.getInt("id");
				String name = resultSet.getString("nombre");
				int h=9;
			}
		}
		catch (Exception e)
		{
			throw e;		
		}
	}

	public void LibroLeido(int id_libro, int id_usuario, String[] categorias, String[] palabras_clave, String[] autores) throws Exception
	{
		try
		{
			String query = "insert into usuario_libro (id_libro,id_usuario) values (" + id_libro + "," + id_usuario + ")";
			statement = connect.createStatement();
			statement.executeQuery(query);
			for(int i=0; i<categorias.length; i++)
			{
				query ="select * from categoria_usuario where id_usuario = " + id_usuario + "and categoria = " + categorias[i];
				resultSet = statement.executeQuery(query);
				if(resultSet.next())
				{
					query="update categoria_usuario set cantidad = cantidad + 1 where id_usuario = "+id_usuario + "and categoria = " + categorias[i];
					statement.executeUpdate(query);
				}
				else
				{
					query = "insert into categoria_usuario (categoria,cantidad,id_usuario) values (" + categorias[i]+ ",1," + id_usuario + ")";
					statement.executeUpdate(query);
				}
			}
			for(int i=0; i<palabras_clave.length; i++)
			{
				query ="select * from palabra_claves_usuario where id_usuario = " + id_usuario + "and palabra_clave = " + palabras_clave[i];
				resultSet = statement.executeQuery(query);
				if(resultSet.next())
				{
					query="update palabra_claves_usuario set cantidad = cantidad + 1 where id_usuario = "+id_usuario + "and palabra_clave = " + palabras_clave[i];
					statement.executeUpdate(query);
				}
				else
				{
					query = "insert into palabra_claves_usuario (palabra_clave,cantidad,id_usuario) values (" + palabras_clave[i]+ ",1," + id_usuario + ")";
					statement.executeUpdate(query);
				}
			}
			for(int i=0; i<autores.length; i++)
			{
				query ="select * from autor_usuario where id_usuario = " + id_usuario + "and autor = " + autores[i];
				resultSet = statement.executeQuery(query);
				if(resultSet.next())
				{
					query="update autor_usuario set cantidad = cantidad + 1 where id_usuario = "+id_usuario + "and autor = " + autores[i];
					statement.executeUpdate(query);
				}
				else
				{
					query = "insert into autor_usuario (autor,cantidad,id_usuario) values (" + autores[i]+ ",1," + id_usuario + ")";
					statement.executeUpdate(query);
				}
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public int Login(String username, String password) throws Exception{
		try
		{
			String query = "SELECT * FROM usuario WHERE username = '" + username + "' and password = '" + password + "'";
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			if(resultSet.next())
			{
				int id = resultSet.getInt("id_usuario");
				return id;
			}
			return 0;
		}
		catch (Exception e)
		{
			throw e;
		}
		
	}
	
	public void InsertUsuario(String username, String password)throws Exception
	{
		try
		{
			String query = "insert into usuario (username,password) values (" + username + "," + password + ")";
			statement = connect.createStatement();
			statement.executeUpdate(query);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public String[] GetCategorias(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT categoria FROM categoria_usuario WHERE id_usuario =" + id_usuario;
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			String resultados="";
			while(resultSet.next())
			{
				resultados += resultSet.getString("categoria")+"|";
			}
			resultados=resultados.substring(0, resultados.length()-1);
			return resultados.split("\\|");
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public String[] GetAutores(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT autor FROM autor_usuario WHERE id_usuario =" + id_usuario;
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			String resultados="";
			while(resultSet.next())
			{
				resultados += resultSet.getString("categoria")+"|";
			}
			resultados=resultados.substring(0, resultados.length()-1);
			return resultados.split("\\|");
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public String[] GetPalabrasClave(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT palabra_clave FROM palabra_claves_usuario WHERE id_usuario =" + id_usuario;
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			String resultados="";
			while(resultSet.next())
			{
				resultados += resultSet.getString("categoria")+"|";
			}
			resultados=resultados.substring(0, resultados.length()-1);
			return resultados.split("\\|");
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public int[] GetCategoriasCantidad(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT cantidad FROM categoria_usuario WHERE id_usuario = " + String.valueOf(id_usuario);
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			ArrayList<Integer> resultados = new ArrayList();
			while(resultSet.next())
			{
				resultados.add(resultSet.getInt("cantidad"));
			}
			return resultados.stream().mapToInt(i -> i).toArray();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public int[] GetAutoresCantidad(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT cantidad FROM autor_usuario WHERE id_usuario =" + id_usuario;
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			ArrayList<Integer> resultados = new ArrayList();
			while(resultSet.next())
			{
				resultados.add(resultSet.getInt("cantidad"));
			}
			return resultados.stream().mapToInt(i -> i).toArray();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public int[] GetPalabraClaveCantidad(int id_usuario) throws Exception
	{
		try
		{
			String query = "SELECT cantidad FROM palabra_claves_usuario WHERE id_usuario =" + id_usuario;
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			ArrayList<Integer> resultados = new ArrayList();
			while(resultSet.next())
			{
				resultados.add(resultSet.getInt("cantidad"));
			}
			return resultados.stream().mapToInt(i -> i).toArray();
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public void IngresarCategorias(int id_usuario, String[] categorias) throws Exception

	{
		for(int i=0; i<categorias.length; i++)
		{
			String query = "insert into categoria_usuario (categoria,cantidad,id_usuario) values ('" + categorias[i]+ "',1," + id_usuario + ")";
			try {
				statement = connect.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void IngresarAutores(int id_usuario, String[] autores) throws Exception
	{
		for(int i=0; i<autores.length; i++)
		{
			String query = "insert into autor_usuario (autor,cantidad,id_usuario) values ('" + autores[i]+ "',1," + id_usuario + ")";
			try {
				statement = connect.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	public void IngresarPalabrasClaves(int id_usuario, String[] palabras_clave) throws Exception
	{
		for(int i=0; i<palabras_clave.length; i++)
		{
			String query = "insert into palabra_claves_usuario (palabra_clave,cantidad,id_usuario) values (" + palabras_clave[i]+ ",1," + id_usuario + ")";
			try {
				statement = connect.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				throw e;
			}
		}
	}
	
	public int[] CalcularLibros() throws Exception
	{
		String query = "select id_libro from libro where id_libro = ANY(SELECT id_libro from usuario_libro WHERE id_usuario=3)";
		try
		{
			statement = connect.createStatement();
			resultSet = statement.executeQuery(query);
			ArrayList<Integer> resultados = new ArrayList();
			while(resultSet.next())
			{
				
			}
			return resultados.stream().mapToInt(i -> i).toArray();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
}
