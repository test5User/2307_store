package by.itclass.model.services;

import by.itclass.model.dao.LaptopDao;
import by.itclass.model.entities.Laptop;
import by.itclass.model.entities.Tv;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;

import static by.itclass.constants.JspConst.*;
import static by.itclass.constants.JspConst.PRICE_TO_PARAM;

public class LaptopService implements Service {
    private LaptopDao dao;

    public LaptopService() {
        dao = new LaptopDao();
    }

    public List<Laptop> getLaptops(Map<String, String[]> params) {
        if (params.isEmpty()) {
            return dao.selectAllLaptop();
        }
        var vendors = params.get(VENDOR_PARAM);
        var cpu = params.get(CPU_PARAM);
        var memory = params.get(MEMORY_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return dao.selectAllLaptop().stream()
                .filter(it -> vendors == null || ArrayUtils.contains(vendors, it.getVendor()))
                .filter(it -> cpu == null || ArrayUtils.contains(cpu, it.getCpu()))
                .filter(it -> memory == null || ArrayUtils.contains(memory, String.valueOf(it.getMemorySize())))
                .filter(it -> from.isEmpty() || it.getPrice() >= Double.parseDouble(from))
                .filter(it -> to.isEmpty() || it.getPrice() <= Double.parseDouble(to))
                .toList();
    }
}
