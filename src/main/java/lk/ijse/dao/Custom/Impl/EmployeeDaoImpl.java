package lk.ijse.dao.Custom.Impl;

import lk.ijse.dao.Custom.EmployeeDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.employeeDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDAO {

    @Override
    public boolean update(employeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "UPDATE employee SET eId = ?, eName = ?, contact = ?, startedDate = ? WHERE eSrt = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEId());
        pstm.setString(2, dto.getEName());
        pstm.setString(3, dto.getTP());
        pstm.setString(4, dto.getStartedDate());
        pstm.setString(5, dto.getESrt());
        return pstm.executeUpdate() > 0;

    }

    @Override
    public  boolean delete(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM employee WHERE eId = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean save(employeeDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO employee VALUES(?,?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, dto.getEId());
        pstm.setString(2, dto.getEName());
        pstm.setString(3, dto.getTP());
        pstm.setString(4, dto.getStartedDate());
        pstm.setString(5, dto.getESrt());

        boolean isSaved = pstm.executeUpdate() > 0;

        return isSaved;
    }
}
