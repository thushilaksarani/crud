package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connections.JDBCconnection;
import domain.Account;

public class AccountDaoImpl {
  
	private final String insertSql = "INSERT INTO account(accId, accNo, accType, pId, balance) VALUES(?,?,?,?,?)";
	private final String updateSql = "UPDATE account SET balance=? WHERE accId=?" ;
	private final String selectSql = "SELECT accId, accNo, accType, pId, balance FROM account WHERE accId=? ";
	private final String selectAllSql = "SELECT * FROM account";
	private final String deleteSql = "DELETE FROM account WHERE accId=?";
	private final String deleteAllSql = "DELETE FROM account";
	Connection con;
	PreparedStatement ps;
	
	 public void insertAccount(Account a) throws SQLException {
		 
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
			ps=con.prepareStatement(insertSql);
			ps.setLong(1,a.getAccId());
			ps.setString(2,a.getAccNo());
			ps.setString(3,a.getAccType());
			ps.setString(4,a.getUserId());
			ps.setDouble(5,a.getBalance());
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
	
	 public void updateAccount(Account a) throws SQLException {
		
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(updateSql);
		ps.setDouble(1,a.getBalance());
		ps.setLong(2,a.getAccId());
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

	 public void selectAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(selectSql);
			ps.setLong(1,a.getAccId());
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getDouble(5));
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

	 public void selectAllAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(selectAllSql);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getDouble(5));	
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

	 public void deleteAccount(Account a) throws SQLException {
			
		 try {
				con = JDBCconnection.getMyConnection();
				if (con == null) {
						System.out.println("Connection Error");
						return;
				}
			con.setAutoCommit(false);
		 
		 ps=con.prepareStatement(deleteSql);
			ps.setLong(1,a.getAccId());
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

	 public void deleteAllAccount(Account a) throws SQLException {
			
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
