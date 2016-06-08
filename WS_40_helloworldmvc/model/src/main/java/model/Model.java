package model;

import contract.IModel;

public class Model implements IModel {
	private DAOHelloWorld dao ;
	
	public Model(){
		this.dao = new DAOHelloWorld() ;
	}
	public String getHelloWorld() {
		dao.open();
		dao.getInstance() ;
		dao.close();
		return DAOHelloWorld.INSTANCE ;
	}
}
