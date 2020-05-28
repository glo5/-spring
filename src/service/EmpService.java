package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtils;
import vo.EmpVO;
import vo.SalaryVO;

import java.sql.Connection;

public class EmpService {

	public List<EmpVO> empList() {
		List<EmpVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(
					"SELECT empno, empname, joindate , decode(rank , 'A', '사원','B','대리','C','과장')rank, decode(dept , 'A', '디자인','B','벡엔드','C','프론트')dept FROM employee_tbl");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEmpname(rs.getString("empname"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setRank(rs.getString("rank"));
				vo.setDept(rs.getString("dept"));
				list.add(vo);
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			DBUtils.close(pstmt);
			DBUtils.close(rs);
		}
		return list;
	}

	public int empInsert(EmpVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int no = 0;
		String sql = "INSERT INTO employee_tbl VALUES(?,?,?,?,?)";

		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEmpname());
			pstmt.setDate(3, vo.getJoindate());
			pstmt.setString(4, vo.getRank());
			pstmt.setString(5, vo.getDept());

			no = pstmt.executeUpdate();

			if (no > 0) {
				conn.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			DBUtils.close(pstmt);
		}
		return no;

	}

	public EmpVO getEmp(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpVO vo = new EmpVO();

		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(
					"SELECT empno, empname, joindate , rank, dept FROM employee_tbl WHERE empno = ?");
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo.setEmpno(rs.getInt("empno"));
				vo.setEmpname(rs.getString("empname"));
				vo.setJoindate(rs.getDate("joindate"));
				vo.setRank(rs.getString("rank"));
				vo.setDept(rs.getString("dept"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			DBUtils.close(pstmt);
			DBUtils.close(rs);
		}
		return vo;

	}

	public int empUpdate(EmpVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int no = 0;
		String sql = "Update employee_tbl SET empname = ?, joindate = ?, rank = ?, dept = ? where empno =?";

		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getEmpname());
			pstmt.setDate(2, vo.getJoindate());
			pstmt.setString(3, vo.getRank());
			pstmt.setString(4, vo.getDept());
			pstmt.setInt(5, vo.getEmpno());

			no = pstmt.executeUpdate();

			if (no > 0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);

		}
		return no;

	}

	public int getMaxEmpNo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int no = 0;
		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement("SELECT MAX(empno)+ 1 empno FROM employee_tbl ");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				no = rs.getInt("empno");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			DBUtils.close(pstmt);
			DBUtils.close(rs);
		}
		return no;
	}

	public List<SalaryVO> empSalary() {
		List<SalaryVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			pstmt = conn.prepareStatement("SELECT A.empno, A.empname , B.pay, "
					+ " FROM (select empno, sum(pay) AS pay from salary_tbl Group by empno ) B, emplyee_tbl A WHERE A.empno = B.empno Order by pay desc   ");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SalaryVO vo = new SalaryVO();
				vo.setEmpno(rs.getInt("empno"));
				vo.setPayday(rs.getDate("payday"));
				vo.setPay(rs.getInt("pay"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(conn);
			DBUtils.close(pstmt);
			DBUtils.close(rs);
		}
		return list;
	}

}
