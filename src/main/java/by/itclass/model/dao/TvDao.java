package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Tv;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static by.itclass.constants.DbConst.*;

public class TvDao {
    public static final String SELECT_ALL_TV = "SELECT * FROM tv";

    public List<Tv> selectAllTv() {
        return fillingCollection(SELECT_ALL_TV);
    }

    public List<Tv> selectFilteredTV(String[] vendors, String[] sizes, String from, String to) {
        var query = new StringBuilder(SELECT_ALL_TV);
        if (vendors != null || sizes != null || !from.isEmpty() || !to.isEmpty()) {
            query.append(" WHERE ")
                    .append(getQueryAppendix(vendors, sizes, from, to));
        }
        return fillingCollection(query.toString());
    }

    private List<Tv> fillingCollection(String query) {
        var tvs = new ArrayList<Tv>();
        try (var cn = ConnectionManager.getConnection();
             var ps = cn.prepareStatement(query)){
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getInt(ID_COL);
                var vendor = rs.getString(VENDOR_COL);
                var model = rs.getString(MODEL_COL);
                var screenSize = rs.getInt(SCREEN_COL);
                var price = rs.getDouble(PRICE_COL);
                tvs.add(new Tv(id, vendor, model, screenSize, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tvs;
    }

    private String getQueryAppendix(String[] vendors, String[] sizes, String from, String to) {
        var queryList = new ArrayList<String>();
        queryList.add(vendors != null ? "(vendor='" + String.join("' OR vendor='", vendors) + "')" : null);
        queryList.add(sizes != null ? "(screenSize=" + String.join(" OR screenSize=", sizes) + ")" : null);
        queryList.add(!from.isEmpty() ? " price>=" + Double.parseDouble(from) : null);
        queryList.add(!to.isEmpty() ? " price<=" + Double.parseDouble(to) : null);
        return queryList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(" AND "));
    }
}
