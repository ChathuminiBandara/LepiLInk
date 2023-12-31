package lk.ijse.dao.Custom.Impl;


import lk.ijse.dao.Custom.OrderdetailDAO;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderdetailDAO {

    @Override
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            if(!saveOrderDetails(orderId, tm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();

        String sql = "INSERT INTO order_detail VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, orderId);
        pstm.setString(2, tm.getCode());
        pstm.setInt(3, tm.getQty());
        pstm.setDouble(4, tm.getUnitPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(CartTm dto) throws SQLException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean save(CartTm dto) throws SQLException {
        return false;
    }
}
