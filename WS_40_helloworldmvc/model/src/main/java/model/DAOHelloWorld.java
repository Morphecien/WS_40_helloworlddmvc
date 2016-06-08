package model;

import java.sql.*;

public class DAOHelloWorld {
	static String INSTANCE = "" ;
	private static final String LOGIN = "root" ;
	private static final String PASSWORD = "" ;
	private static final String URL = "jdbc:mysql://localhost/ws_helloworldmvc?autoReconnect=true&useSSL=false" ;
	
	private Connection connection ;
	private Statement statement ;
	private ResultSet resultSet ;
	
	public DAOHelloWorld() {
		this.connection = null ;
		this.statement = null ;
	}
	
	public DAOHelloWorld getInstance(){
		try {
			resultSet = statement.executeQuery(getQuerySelectFirstHelloWorld()) ;
			if (resultSet.next()){
				DAOHelloWorld.INSTANCE = resultSet.getString("Texte") ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this ;
	}
	
	public String getQuerySelectFirstHelloWorld(){
		return "SELECT `Texte` FROM `message` ;";	
	}
	
	protected ResultSet executeQuery(String query){
		try {
			this.resultSet = statement.executeQuery(query) ;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.resultSet;
	}
	
	protected boolean open(){
		try {
	//		System.out.println("Debut connection...");
			Class.forName("com.mysql.jdbc.Driver");
	//		System.out.println("	Driver ok... connection en cours");
			this.connection = DriverManager.getConnection(DAOHelloWorld.URL, DAOHelloWorld.LOGIN, DAOHelloWorld.PASSWORD);
	//		System.out.println("	connection réussie... initialisation du statement");
			this.statement = this.connection.createStatement();
	//		System.out.println("	initialisation réussie... (:");
		}
		catch (final ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		catch (final SQLException e) {
			e.printStackTrace();
			return false;
		}
	//	System.out.println("On est connecté ! (:") ;
		return true;
	}

	protected void close(){
		try {
			this.connection.close();
			this.statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	//	System.out.println("Ah ben... c'est fini !!! <musique de fin>");
	}
}
