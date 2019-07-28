package DBconnectpkg;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource; 
public class ConnectionProvider {

	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	public static CallableStatement csmt = null;

 
	

	public static Connection getConnection() throws Exception {
		// Connection con=null;
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/gliterdb");
		bds.setUsername("root");
		bds.setPassword("");
		bds.setMaxActive(15);
		bds.setMinIdle(5);
		bds.setMaxWait(1000 * 5);
		try {
			con = bds.getConnection();
		} catch (Exception e) {

			if (bds.getMaxActive() > 15) {
				System.out.println(bds.getMaxActive());
				throw new Exception("Please Closed All Connection two much connection is open ");

			} else {
				throw new Exception("Please Check Connection Credantials or start xampp");

			}
		}

		return con;
	}


	
	public static Connection concloser(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;

		} else if (con != null) {
			con.close();
			con = null;
		}

		return con;
	}

	public static PreparedStatement smtcloser(PreparedStatement pPs) throws SQLException {
		if (pPs != null) {
			pPs.close();
			pPs = null;
		} else if (ps != null) {
			ps.close();
			ps = null;
		}

		return ps;
	}

	public static ResultSet rstcloser(ResultSet rRs) throws SQLException {
		if (rRs != null) {
			rRs.close();
			rRs = null;

		} else if (rs != null) {
			rs.close();
			rs = null;
		}

		return rs;
	}

	public static Boolean InsertData(String tTbl_name, String pParamiters, String vValues) throws SQLException {
		Boolean b = false;
		if (tTbl_name == null && pParamiters == null && vValues == null
				|| tTbl_name == "" && pParamiters == "" && vValues == "")
			return false;
		try {
			String qQuery = new String();
			qQuery = "insert into " + tTbl_name + " ( " + pParamiters + " ) values( " + vValues + " ) ";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(qQuery);
			int a = ps.executeUpdate();
			if (a > 0)
				b = true;
			else
				b = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertion error is" + e);

		} finally {
			ConnectionProvider.smtcloser(ps);
			ConnectionProvider.concloser(con);
		}
		return b;

	}

	public static Boolean UpdateData(String tTbl_name, String pParamiters, String cCondition) throws SQLException {
		Boolean b = false;
		if (tTbl_name == null && pParamiters == null && cCondition == null
				|| tTbl_name == "" && pParamiters == "" && cCondition == "")
			return false;

		try {
			String qQuery = new String();
			qQuery = "Update " + tTbl_name + " set " + pParamiters + " where " + cCondition + "";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(qQuery);
			int a = ps.executeUpdate();
			if (a > 0)
				b = true;
			else
				b = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertion error is" + e);

		} finally {
			ConnectionProvider.smtcloser(ps);
			ConnectionProvider.concloser(con);
		}
		return b;

	}

	public static Boolean UpdateData1(String tTbl_name, String pParamiters, String vValues, String cCondition)
			throws SQLException {
		StringBuilder sb = new StringBuilder();
		int i = 1;
		String s = ",";
		String paramiters[] = pParamiters.split(s);
		String prmvalue[] = vValues.split(s);
		// set for que ? mark.....
		for (String prm : paramiters) {
			sb.append(prm + "= ?,");
		}
		StringBuilder finParam = sb.deleteCharAt(sb.length() - 1);
		Boolean b = false;

		if (tTbl_name == null && pParamiters == null && cCondition == null
				|| tTbl_name == "" && pParamiters == "" && cCondition == "")
			return false;

		try {
			String qQuery = new String();
			qQuery = "Update " + tTbl_name + " set " + finParam + " where " + cCondition + "";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(qQuery);
			for (String prm : prmvalue) {
				sb.append(prm + "= ?");
				ps.setString(i, prm);
				i++;
			}
			int a = ps.executeUpdate();
			if (a > 0)
				b = true;
			else
				b = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertion error is" + e);

		} finally {
			ConnectionProvider.smtcloser(ps);
			ConnectionProvider.concloser(con);
		}
		return b;
	}

	public static Boolean DeleteData(String tTbl_name, String cCondition) throws SQLException {

		Boolean b = false;

		if (tTbl_name == null && cCondition == null || tTbl_name == "" && cCondition == "")
			return b;

		try {
			String qQuery = new String();
			qQuery = "delete from " + tTbl_name + " where " + cCondition;
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(qQuery);
			int a = ps.executeUpdate();
			if (a > 0)
				b = true;
			else
				b = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insertion error is" + e);

		} finally {
			ConnectionProvider.smtcloser(ps);
			ConnectionProvider.concloser(con);
		}
		return b;

	}

	public static ResultSet SelectData(String qQuery) throws SQLException {
		if (qQuery != null || qQuery != "") {

			try {
				con = ConnectionProvider.getConnection();
				ps = con.prepareStatement(qQuery);
				rs = ps.executeQuery();
				if (rs != null) {
					return rs;
				} else {
					return rs = null;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("selection error is" + e);

			}

		}

		return rs;
	}

	public static void main(String[] args) throws SQLException {

		try {

			/*
			 * for delete database table data
			 * 
			 * 
			 * String cCondition = "sr_no = "+1+" "+""; Boolean result
			 * =ConnectionProvider.DeleteData ("data_insertion ", cCondition);
			 * if(result==true){ System.out.println("success"); }
			 */

			/*
			 * for update data base using string concat
			 * 
			 * 
			 * String pParamiters
			 * ="dateoftxn='"+"05/07/2018"+"',ladger_name ='"+"Naushad Sayyed"
			 * +"',dramt='"+"10"+"'"; String cCondition = "sr_no = "+1+" "+"";
			 * Boolean result =ConnectionProvider.UpdateData("data_insertion ",
			 * pParamiters, cCondition); if(result==true){
			 * System.out.println("success"); }
			 */

			/* for update tabple using prepared statements */String pParamiters = "dateoftxn,ladger_name,dramt";
			String pPvalues = "" + "05/07/2018" + "," + "Naushad Sayyed" + "," + "50" + "";
			String cCondition = "sr_no = " + 1 + " " + "";
			Boolean result = ConnectionProvider.UpdateData1("data_insertion ", pParamiters, pPvalues, cCondition);
			if (result == true) {
				System.out.println("success");
			}

			/*
			 * for insert example
			 *
			 * String pParamiters
			 * ="sr_no,dateoftxn,ladger_name,dramt,naration,ch_no,VoucherType";
			 * String vValues
			 * =""+"4"+","+"05/07/2018"+","+"Naushad Sayyed"+","+"0"+","+"Hello"
			 * +","+"00124"+","+"sales"+""; Boolean result
			 * =ConnectionProvider.InsertData(" data_insertion", pParamiters,
			 * vValues); if(result==true){ System.out.println("success"); }
			 * 
			 */

			/*
			 * for retrival of data rs =
			 * ConnectionProvider.SelectData("select * from accounts_ladger");
			 * while (rs.next()) {
			 * System.out.println(rs.getString("ladger_name")); }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			ConnectionProvider.concloser(null);
			ConnectionProvider.smtcloser(null);
			/* ConnectionProvider.rstcloser(null); */
		}

	}

	public static int StringToIntConv(String num) {
		int number = Integer.parseInt(num);
		return number;
	}

	public static Double StringToDouble(String num) {
		Double number = Double.parseDouble(num);
		return number;
	}

	public static Long StringToLong(String num) {
		Long number = Long.parseLong(num);
		return number;
	}

	public static Date StringtoDateConvertion(String date) {

		/* date should be in yyyy /mdd formate */

		DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = (Date) formatter1.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dt;
	}

}
