// //用于编写ajax
// /* 所有ajax的代码写到这里 */
// axios.defaults.baseURL='http://localhost:10010/v1'
// // 设置AJAX超时时间
// axios.defaults.timeout = 3000
// // 设置提交数据时的格式
// axios.defaults.headers['Content-Type'] = 'application/json'

// // 设置前置拦截器->以后所有的AJAX都会自动添加上 Authorization:token 的协议头
// axios.interceptors.request.use(function (config) {
//     // 判断如果用户登录了就把 token 配置上 axios 的协议头中
//     let token = localStorage.getItem('token')
//     if (token) {
//         config.headers['Authorization'] = token
//     }
//     // 处理请求前代码
//     return config;
// }, function (error) {
//     // Do something with request error
//     return Promise.reject(error);
// });






//注册
function regist(params){
   return axios.post("/web-service/regist",params);
}


//获取验证码
function sms(mobile){
    return axios.post("/web-service/sms",{"mobile":mobile});
}


//登录
function logins(params){
    console.info(params)
    return axios.post("/auth-service/login",params);
}




//商品搜索

function search(searchMap){
    return axios.get("/web-service/search",{
        params:searchMap
    })
   
}

 //商品信息
 function shop(){
    return axios.get("/web-service/shop")
}

//促销活动
function ashop(){
    return axios.get("/web-service/ashop")
}

//商品分类
function categorys(){
    return axios.get("/web-service/categorys")
}


//条件查询
function conditionSearch(searchMap){
    return axios.post("/web-service/conditionSearch",{
        params:searchMap
    })
   
}

//品牌
function searchBrand(cat_id){
    return axios.get("/web-service/brand/" + cat_id)
}
//规格
function specifications(cat_id){
    return axios.get("/web-service/specifications/" + cat_id)
}



//商品详情页
function goods(skuid){
    return axios.get("/web-service/goods/"+skuid)

}

//商品规格
function spec(){
    return axios.get("/web-service/spec")

}

//修改商品库存
function updateStock(params){
    return axios.put("/web-service/update",params)

}


//商品评论
function getComments(spuid,pageSize,page){
    return axios.get("/web-service/comments/"+spuid+"?limit="+pageSize+"&page="+page+"&sort_by=id&sort_way=asc");
   
}

//查询购物车
function getCart(){
    return axios.get("/cart-service/carts");
};

//添加到购物车
function addToCart(params){
    return axios.post("/cart-service/carts",params);
};

//修改购物车
function updateCart(params){
    return axios.put("/cart-service/carts",params);
};

//删除购物车
function deleteCart(skuid){
    return axios.delete("/cart-service/carts/"+skuid);
};


//查询所购商品信息
function orders(skuid){
    return axios.get("/order-service/orders/"+skuid);
};


//获取地址列表
function getAddress(){
    return axios.get("/order-service/address");
}


//添加地址
function addAddress(params){
    return axios.post("/order-service/address",params);
};

//默认地址
function updateAddress(params){
    return axios.put("/order-service/address",params);
};

//订单——地址列表
function getAdd(){
    return axios.get("/order-service/add");
}

//删除地址
function deleteAddress(id){
    return axios.delete("/order-service/address/"+id);
};





//查询订单信息
function ordersList(){
    return axios.get("/order-service/ordersList");
};


//生成订单
function addOrders(params){
    return axios.post("/order-service/orders",params);
};

//删除订单
function deleteOrders(id){
    return axios.delete("/order-service/orders/"+id);
};

//支付订单
function payOrders(params){
    return axios.post("/order-service/pay",params);
};


//修改订单
function updateOrders(params){
    return axios.put("/order-service/orders",params);
};


//付款
function order_status(id){
    return axios.get("/order_status"+id);
};


//商品秒杀
function seckillShop(){
    return axios.get("/web-service/shops");
};



//修改秒杀商品状态
function updateShop(params){
    return axios.put("/web-service/shops",params);
};


//查询优惠卷
function getCoupon(){
    return axios.get("/order-service/coupons");
};





//记录浏览的商品详情
function addFoot(id){
    return axios.get("/order-service/foots/"+id)

}

//浏览的商品详情
function footGoods(){
    return axios.get("/order-service/foots")

}

