package com.example.demo.controller;

import com.example.demo.Utils.UploadUtils;
import com.example.demo.mapper.*;
import com.example.demo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/eshop")
public class UserController {
    @Autowired
    UserMapper um;
    @Autowired
    CollectionSQLMapper cm;
    @Autowired
    ProductMapper pm;
    @Autowired
    ProductPicMapper ppm;
    @Autowired
    OrderMapper om;
    @Autowired
    AddressMapper am;
    @Autowired
    OrderDetailMapper odm;
    @Autowired
    ShoppingCartMapper scm;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    ProductTypeMapper ptm;

    @RequestMapping("/get_message")
    public HashMap<String, String> getMessage() {
        String[] messages = {"有新的打折商品", "双十一特惠商品", "近期有%d个好友生日"};
        messages[2] = String.format(messages[2], (int) (Math.random() * 10) + 1);
        int i = (int) (Math.random() * 3);
        String message = messages[i];
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("RESULT", "S");
        hashMap.put("flag", i + "");
        hashMap.put("message", message);
        return hashMap;
    }

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();
        File fileDir = UploadUtils.getImgDirFile();
        File dest = new File(fileDir.getAbsolutePath() + File.separator + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败！";
    }

    @RequestMapping("/login")
    public HashMap<String, Object> userLogin(@RequestBody User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName()).andUserPasswordEqualTo(user.getUserPassword());
        List<User> list = um.selectByExample(userExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (list.size() == 0) {
            hashMap.put("RESULT", "F");
            return hashMap;
        } else {
            hashMap.put("RESULT", "S");
            hashMap.put("userId", list.get(0).getUserId());
            return hashMap;
        }
    }

    @RequestMapping("/register")
    public HashMap<String, Object> userRegister(@RequestBody User user) {
        user.setUserMoney(0f);
        HashMap<String, Object> hashMap = new HashMap<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> list = um.selectByExample(userExample);
        if (list.size() == 0) {
            um.insert(user);
            hashMap.put("RESULT", "S");
            return hashMap;
        } else {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
    }

    @RequestMapping("/get_collection")
    public HashMap<String, Object> getCollection(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        CollectionSQLExample cExample = new CollectionSQLExample();
        cExample.createCriteria().andUserIdEqualTo(userId);
        List<CollectionSQL> CollectionSQLList = cm.selectByExample(cExample);
        if (CollectionSQLList.size() == 0) {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
        List<Product> productList = new ArrayList<>();
        for (CollectionSQL collectionSQL : CollectionSQLList) {
            productList.add(pm.selectByPrimaryKey(collectionSQL.getProductId()));
        }
        hashMap.put("RESULT", "S");
        hashMap.put("products", productList);
        return hashMap;
    }

    @RequestMapping("/get_order_product")
    public HashMap<String, Object> getOrder(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        OrderExample oExample = new OrderExample();
        oExample.createCriteria().andUserIdEqualTo(userId);
        List<Order> orderList = om.selectByExample(oExample);
        ProductExample pExample = new ProductExample();
        if (orderList.size() == 0) {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            OrderDetailExample oDetailExample = new OrderDetailExample();
            oDetailExample.createCriteria().andOrderIdEqualTo(orderList.get(0).getOrderId());
            List<OrderDetail> orderDetailList = odm.selectByExample(oDetailExample);
            if (orderDetailList.size() == 0) {
                hashMap.put("RESULT", "F");
                hashMap.put("message", "订单为空");
                return hashMap;
            }
            pExample.createCriteria().andProductIdEqualTo(orderDetailList.get(i).getProductId());
            productList.addAll(pm.selectByExample(pExample));
            hashMap.put("RESULT", "S");
            hashMap.put("Pruduct", productList);
        }
        return hashMap;
    }

    @RequestMapping("/get_all_address")
    public HashMap<String, Object> getAllAddress(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        Address address = am.selectByPrimaryKey(user.getUserDefaultAddressId());

        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(userId);
        List<Address> addresses = am.selectByExample(addressExample);
        if (addresses.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无地址");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        hashMap.put("addresses", addresses);
        hashMap.put("defaultAddress", address);
        return hashMap;

    }

    @RequestMapping("/get_address")
    public HashMap<String, Object> getAddress(int userId, int addressId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        Address address = am.selectByPrimaryKey(addressId);
        if (address == null) {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        hashMap.put("defaultAddress", address);
        return hashMap;

    }

    @RequestMapping("/get_user")
    public HashMap<String, Object> getUser(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        } else {
            hashMap.put("RESULT", "S");
            hashMap.put("user", user);
            return hashMap;
        }

    }

    @RequestMapping("/get_all_product")
    public HashMap<String, Object> getAllProduct() {
        ProductExample productExample = new ProductExample();
        List<Product> products = pm.selectByExample(productExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (products.size() > 0) {
            hashMap.put("RESULT", "S");
            hashMap.put("products", products);
            return hashMap;
        }
        hashMap.put("RESULT", "F");
        hashMap.put("message", "获取商品失败");

        return hashMap;
    }

    @RequestMapping("/get_product_pic")
    public HashMap<String, Object> getProductPic(int productId) {
        ProductPicExample productPicExample = new ProductPicExample();
        productPicExample.createCriteria().andProductIdEqualTo(productId);
        List<ProductPic> productPics = ppm.selectByExample(productPicExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (productPics.size() > 0) {
            hashMap.put("RESULT", "S");
            hashMap.put("productPics", productPics);
            return hashMap;
        }
        hashMap.put("RESULT", "F");
        hashMap.put("message", "获取商品失败");
        return hashMap;
    }


    @RequestMapping("/get_productById")
    public HashMap<String, Object> getProductById(int productId) {
        Product product = pm.selectByPrimaryKey(productId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (product == null) {
            hashMap.put("RESULT", "F");
            return hashMap;
        } else {
            hashMap.put("RESULT", "S");
            hashMap.put("product", product);
            return hashMap;
        }
    }

    @RequestMapping("/get_productByFlag")
    public HashMap<String, Object> getProductByFlag(int flag) {
        ProductExample pExample = new ProductExample();
        pExample.createCriteria().andProductFlagEqualTo(flag);
        List<Product> products = pm.selectByExample(pExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (products == null) {
            hashMap.put("RESULT", "F");
            return hashMap;
        } else {
            hashMap.put("RESULT", "S");
            hashMap.put("product", products);
            return hashMap;
        }
    }

    @RequestMapping("/get_productByListId")
    public HashMap<String, Object> getProductByListId(List<Integer> productIdList) {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdIn(productIdList);
        List<Product> products = pm.selectByExample(productExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (products.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无符合条件商品");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        hashMap.put("products", products);
        return hashMap;
    }

    @RequestMapping("/get_productAndOrderAndDetail")
    public HashMap<String, Object> getProductByOrderAndDetail(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId);
        List<Order> orders = om.selectByExample(orderExample);
        List<Integer> orderIds = new ArrayList<>();

        if (orders.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无商品订单");
            return hashMap;
        }
        for (Order order : orders) {
            orderIds.add(order.getOrderId());
        }

        OrderDetailExample oDetailExample = new OrderDetailExample();
        oDetailExample.createCriteria().andOrderIdIn(orderIds);
        List<OrderDetail> orderDetails = odm.selectByExample(oDetailExample);

        List<Integer> productIds = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            productIds.add(orderDetail.getProductId());
        }

        ProductExample pExample = new ProductExample();
        pExample.createCriteria().andProductIdIn(productIds);
        List<Product> products = pm.selectByExample(pExample);

        if (products.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无符合条件商品");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        hashMap.put("orders", orders);
        hashMap.put("orderDetails", orderDetails);
        hashMap.put("products", products);
        return hashMap;
    }


    @RequestMapping("/get_shopping_cart_product")
    public HashMap<String, Object> getShoppingCart(int userId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        ShoppingCartExample scExample = new ShoppingCartExample();
        scExample.createCriteria().andUserIdEqualTo(userId);
        List<ShoppingCart> shoppingCarts = scm.selectByExample(scExample);

        if (shoppingCarts.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "购物车空空如也");
            return hashMap;
        }
        List<OrderDetail> orderDetails = new ArrayList<>();

        List<Integer> productIds = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            Order order = om.selectByPrimaryKey(shoppingCart.getOrderId());
            OrderDetailExample odExample = new OrderDetailExample();
            odExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
            List<OrderDetail> oDetails = odm.selectByExample(odExample);
            orderDetails.add(oDetails.get(0));
            if (!productIds.contains(oDetails.get(0).getProductId())) {
                productIds.add(oDetails.get(0).getProductId());
            }

        }
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andProductIdIn(productIds);
        List<Product> products = pm.selectByExample(productExample);
        if (products.size() > 0) {
            hashMap.put("RESULT", "S");
            hashMap.put("orderDetail", orderDetails);
            hashMap.put("products", products);
            return hashMap;
        } else {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
    }

    @RequestMapping("/get_sending")
    public HashMap<String, Object> getSending(int userId, int flag) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId).andFlagEqualTo(flag);
        List<Order> orders = om.selectByExample(orderExample);
        if (orders.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无订单");
            return hashMap;
        }
        List<Integer> orderIds = new ArrayList<>();

        for (Order order : orders) {
            orderIds.add(order.getOrderId());
        }

        OrderDetailExample oDetailExample = new OrderDetailExample();
        oDetailExample.createCriteria().andOrderIdIn(orderIds);
        List<OrderDetail> orderDetails = odm.selectByExample(oDetailExample);

        List<Integer> productIds = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            productIds.add(orderDetail.getProductId());
        }

        ProductExample pExample = new ProductExample();
        pExample.createCriteria().andProductIdIn(productIds);
        List<Product> products = pm.selectByExample(pExample);

        if (products.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无符合条件商品");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        hashMap.put("orders", orders);
        hashMap.put("orderDetails", orderDetails);
        hashMap.put("products", products);
        return hashMap;
    }

    @RequestMapping("/add_shopping_cart")
    public HashMap<String, Object> addShoppingCart(int userId, int productId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        ProductExample pExample = new ProductExample();
        pExample.createCriteria().andProductIdEqualTo(productId);
        List<Product> products = pm.selectByExample(pExample);
        if (products.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无此商品");
            return hashMap;
        }
        Address address = am.selectByPrimaryKey(user.getUserDefaultAddressId());
        if (address == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "请先设置默认地址");
            return hashMap;

        }

        Order order = new Order();
        order.setUserId(userId);
        order.setFlag(0);
        order.setOrderSendType("快递");
        order.setAdressId(user.getUserDefaultAddressId());
        if (productId == 0) {
            productId = 1;
        }
        om.insert(order);
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(userId);
        List<Order> orders = om.selectByExample(orderExample);
        int orderId = orders.get(orders.size() - 1).getOrderId();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId(productId);
        orderDetail.setProductNumber(1);
        orderDetail.setOrderId(orderId);
        odm.insert(orderDetail);

        ShoppingCart shopringCart = new ShoppingCart();
        shopringCart.setOrderId(orderId);
        shopringCart.setUserId(userId);
        scm.insert(shopringCart);
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/add_address")
    public HashMap<String, Object> addAddress(int userId, String address) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        Address addressBean = new Address();
        addressBean.setUserId(userId);
        addressBean.setAddress(address);
        try {
            am.insert(addressBean);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "添加失败");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;

    }

    @RequestMapping("/add_collection")
    public HashMap<String, Object> addCollection(int userId, int productId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        CollectionSQLExample collectionSQLExample = new CollectionSQLExample();
        collectionSQLExample.createCriteria().andProductIdEqualTo(productId);
        List<CollectionSQL> collectionSQLs = cm.selectByExample(collectionSQLExample);
        if (collectionSQLs.size() != 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "收藏夹已存在该商品");
            return hashMap;
        }

        ProductExample pExample = new ProductExample();
        pExample.createCriteria().andProductIdEqualTo(productId);
        List<Product> products = pm.selectByExample(pExample);
        if (products.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "无此商品");
            return hashMap;
        }
        CollectionSQL collectionSQL = new CollectionSQL();
        collectionSQL.setUserId(userId);
        collectionSQL.setProductId(productId);
        cm.insert(collectionSQL);
        hashMap.put("RESULT", "S");
        return hashMap;

    }

    @RequestMapping("/add_money")
    public HashMap<String, Object> addMoney(int userId, float addMoney) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId);
        User userbd = um.selectByPrimaryKey(user.getUserId());
        userbd.setUserMoney(userbd.getUserMoney() + addMoney);
        try {
            um.updateByPrimaryKey(userbd);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "添加失败");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/up_data_user")
    public HashMap<String, Object> updataUser(@RequestBody User user) {
        User userbd = um.selectByPrimaryKey(user.getUserId());
        HashMap<String, Object> hashMap = new HashMap<>();
        if (userbd == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }

        User userdb = um.selectByPrimaryKey(user.getUserId());
        userdb.setUserEmail(user.getUserEmail());
        userdb.setUserPhone(user.getUserPhone());
        userdb.setUserNike(user.getUserNike());
        try {
            um.updateByPrimaryKey(userdb);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "更新数据失败");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }


    @RequestMapping("/set_order_detail_number")
    public HashMap<String, Object> setOrderDetailNumber(int userId, int orderDetailId, int orderDetailNumber) {
        User userbd = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (userbd == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        OrderDetail orderDetail = odm.selectByPrimaryKey(orderDetailId);
        orderDetail.setProductNumber(orderDetailNumber);
        try {
            odm.updateByPrimaryKey(orderDetail);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "更新数据失败");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/buy_shopping_cart")
    public HashMap<String, Object> buyShoppingCart(int userId, @RequestBody OrderDetailIds orderDetailIds) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        System.out.println(orderDetailIds.getOrderDetailIds().toString());
        OrderDetailExample oDetailExample = new OrderDetailExample();
        oDetailExample.createCriteria().andOrderDetailIdIn(orderDetailIds.getOrderDetailIds());
        List<OrderDetail> orderDetails = odm.selectByExample(oDetailExample);

        List<Integer> orderIds = new ArrayList<>();
        for (OrderDetail detail : orderDetails) {
            orderIds.add(detail.getOrderId());
        }

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdIn(orderIds);
        List<Order> orders = om.selectByExample(orderExample);
        for (Order order : orders) {
            order.setFlag(1);
            om.updateByPrimaryKey(order);
        }

        List<Product> products = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            Product product = pm.selectByPrimaryKey(orderDetail.getProductId());
            if (product == null) {
                hashMap.put("RESULT", "F");
                hashMap.put("message", "购买的商品中 有商品已下架");
                return hashMap;
            }
            products.add(product);
        }

        float money = user.getUserMoney();
        for (int i = 0; i < products.size(); i++) {
            money -= products.get(i).getNewProductPrice() * orderDetails.get(i).getProductNumber();
            products.get(i).setProductStock(products.get(i).getProductStock() - orderDetails.get(i).getProductNumber());
            pm.updateByPrimaryKey(products.get(i));
        }
        if (money <= 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "您的余额已不足");
            return hashMap;

        }
        user.setUserMoney(money);
        ShoppingCartExample shopringCartExample = new ShoppingCartExample();
        shopringCartExample.createCriteria().andOrderIdIn(orderIds);

        scm.deleteByExample(shopringCartExample);
        try {
            um.updateByPrimaryKey(user);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "未知错误,交易取消");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/delete_shopping_cart")
    public HashMap<String, Object> deleteShoppingCart(int userId, @RequestBody OrderDetailIds orderDetailIds) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        OrderDetailExample oDetailExample = new OrderDetailExample();
        oDetailExample.createCriteria().andOrderDetailIdIn(orderDetailIds.getOrderDetailIds());
        List<OrderDetail> orderDetails = odm.selectByExample(oDetailExample);

        List<Integer> orderIds = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {
            orderIds.add(orderDetail.getOrderId());
        }

        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andOrderIdIn(orderIds);

        ShoppingCartExample shopringCartExample = new ShoppingCartExample();
        shopringCartExample.createCriteria().andOrderIdIn(orderIds);
        odm.deleteByExample(oDetailExample);
        om.deleteByExample(orderExample);
        scm.deleteByExample(shopringCartExample);
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/delete_address")
    public HashMap<String, Object> deleteAddress(int userId, int addressId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        try {
            am.deleteByPrimaryKey(addressId);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/delete_collection")
    public HashMap<String, Object> deleteCollection(int userId, int productId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        CollectionSQLExample collectionSQLExample = new CollectionSQLExample();
        collectionSQLExample.createCriteria().andProductIdEqualTo(productId);
        try {
            cm.deleteByExample(collectionSQLExample);

        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "删除失败");
            return hashMap;
        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/delete_order")
    public HashMap<String, Object> deleteOrder(int userId, int orderId) {
        User user = um.selectByPrimaryKey(userId);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (user == null) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "用户信息无效");
            return hashMap;
        }
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OrderDetail> orderDetails = odm.selectByExample(orderDetailExample);
        Order order = om.selectByPrimaryKey(orderId);
        try {
            om.deleteByPrimaryKey(orderId);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "删除失败");
            return hashMap;
        }
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andOrderIdEqualTo(orderId);
        try {
            odm.deleteByPrimaryKey(orderDetails.get(0).getOrderDetailId());
            scm.deleteByExample(shoppingCartExample);
        } catch (Exception e) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "删除失败");
            om.insert(order);
            return hashMap;

        }
        hashMap.put("RESULT", "S");
        return hashMap;
    }

    @RequestMapping("/query_product")
    public HashMap<String, Object> queryProduct(String queryWord) {
        HashMap<String, Object> hashMap = new HashMap<>();

        ProductExample productExample = new ProductExample();
        List<Product> products = pm.selectByExample(productExample);
        List<Product> queryProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(queryWord.toLowerCase())) {
                queryProducts.add(product);
            }
        }
        if (queryProducts.size() == 0) {
            hashMap.put("RESULT", "F");
            hashMap.put("message", "没有你想要的商品");
            return hashMap;
        }

        hashMap.put("RESULT", "S");
        hashMap.put("queryProducts", queryProducts);
        return hashMap;
    }

    @RequestMapping("/get_all_product_type")
    public HashMap<String, Object> getAllProductType() {
        ProductTypeExample productTypeExample = new ProductTypeExample();
        List<ProductType> productTypes = ptm.selectByExample(productTypeExample);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (productTypes.size() > 0) {
            hashMap.put("RESULT", "S");
            hashMap.put("productTypes", productTypes);
            return hashMap;
        }
        hashMap.put("RESULT", "F");
        hashMap.put("message", "获取商品类型失败");

        return hashMap;
    }

}