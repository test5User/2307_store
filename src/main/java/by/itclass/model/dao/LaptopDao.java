package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Laptop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.DbConst.*;

public class LaptopDao {
    public static final String SELECT_ALL_LAPTOP = "SELECT * FROM laptop";

    public List<Laptop> selectAllLaptop() {
        var laptops = new ArrayList<Laptop>();
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(SELECT_ALL_LAPTOP)){
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getInt(ID_COL);
                var vendor = rs.getString(VENDOR_COL);
                var model = rs.getString(MODEL_COL);
                var cpu = rs.getString(CPU_COL);
                var memory = rs.getInt(MEMORY_COL);
                var price = rs.getDouble(PRICE_COL);
                laptops.add(new Laptop(id, vendor, model, cpu, memory, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptops;
    }

}
