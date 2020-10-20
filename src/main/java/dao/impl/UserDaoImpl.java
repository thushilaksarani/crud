package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.JDBCconnection;
import domain.Person;

public class UserDaoImpl {
	
	private final String insertSql = "INSERT INTO person(pId, fName, lName, email, contacNo) VALUES(?,?,?,?,?)";
	private final String updateSql = "UPDATE person SET email=?, contacNo=? WHERE pId=?" ;
	private final String selectSql = "SELECT pId, fName, lName, email, contacNo FROM person WHERE pId=? ";
	private final String selectAllSql = "SELECT * FROM person";
	private final String deleteSql = "DELETE FROM person WHERE pId=?";
	private final String deleteAllSql = "DELETE FROM person";
	Connection con;
	PreparedStatement ps;
	
	 public void  insertPerson(Person p) throws SQLException {
			try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
			
			ps=con.prepareStatement(insertSql);
			ps.setString(1,p.getId());
			ps.setString(2,p.getFname());
			ps.setString(3,p.getLname());
			ps.setString(4,p.getEmail());
			ps.setString(5,p.getContactNo());
			ps.execute();
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
	}	 
	
	 public void updatePerson(Person p) throws SQLException {
		 
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		ps=con.prepareStatement(updateSql);
		ps.setString(1,p.getEmail());
		ps.setString(2,p.getContactNo());
		ps.setString(3,p.getId());
		ps.execute();
		
		con.commit();
	 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
	 }

	 public void selectPerson(Person p) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(selectSql);
			ps.setString(1,p.getId());
			ResultSet r =ps.executeQuery();
			while (r.next()) {
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getString(5));
			}
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
			
		}

	 public void selectAllPerson(Person p) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(selectAllSql);
			ResultSet r =ps.executeQuery();
			while (r.next()) {
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getString(5));
			}
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
			
		}

	 public void deletePerson(Person p) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(deleteSql);
			ps.setString(1,p.getId());
			ps.execute();
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}

	 public void deleteAllPerson(Person p) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		  ps=con.prepareStatement(deleteAllSql);
			ps.execute();
			
			con.commit();
		 	
			}catch (SQLException e) {
				try {
					if (con != null) {
						con.rollback();
					}
				} catch (SQLException e1) {
					throw e1;
				}
				throw e;
			}
			finally {
				try {
					JDBCconnection.closePreparedStatement(ps);
					JDBCconnection.closeConnection(con);
				} catch (SQLException e2) {
					throw e2;
				}
			}
		}
	 
	 
	 
}
















