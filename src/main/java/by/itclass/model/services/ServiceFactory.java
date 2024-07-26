package by.itclass.model.services;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<ServiceType, Service> services = new HashMap<>();

    public static void init() {
        services.put(ServiceType.CART_SERVICE, new CartService());
        services.put(ServiceType.LAPTOP_SERVICE, new LaptopService());
        services.put(ServiceType.ORDER_HISTORY_SERVICE, new OrderHistoryService());
        services.put(ServiceType.ORDER_SERVICE, new OrderService());
        services.put(ServiceType.TV_SERVICE, new TvService());
        services.put(ServiceType.USER_SERVICE, new UserService());
    }

    public static Service getInstance(ServiceType serviceType) {
        return services.get(serviceType);
    }
}
