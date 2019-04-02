// //用于存放模
// //注册
// Mock.mock("/web-service/regist","post",{
//     "data":{
//         "errno":"@integer(0,1)",
//         "errmsg":"@cword(4)"
//     }
// });

// //获取验证码
// Mock.mock("/web-service/sms","post",{
//     "data":{
//         "errno":"@integer(0,1)",
//         "errmsg":"@cword(4)"
//     }
// });

// //登录
// Mock.mock("/auth-service/logins","post",{
//     "data":{
//         "errno":"@integer(0,1)",
//         "errmsg":"@cword(4)",
//         "token|20-30":10,
//         "name":"@cname"
//     }
// });




// //商品信息
// Mock.mock("/web-service/shop","get",{
//     "data|8-14":[{
//         "id|+1":1,
//         "sname":"@ctitle(10,14)",
//         //现价
//         "price":"@float(100,200,0,2)",
//         //原价
//         "nprice":"@float(300,400,0,2)",
//         }]
    
// });


// //促销活动
// Mock.mock("/web-service/ashop","get",{
//     "data|4-6":[{
//         "id|+1":1,
//         "sname":"@ctitle(8,10)",
//         //现价
//         "price":"@float(50,150,0,2)",
//         //原价
//         "nprice":"@float(300,400,0,2)",
//         }]
    
// });



// //商品分类
// Mock.mock("/web-service/categorys","get",{
//     "data|4-8":[{
//         "id|+1":1,
//         "cat_name":"@ctitle(2,5)",
//         "children|4-7":[{
//             "id|+1":100,
//             "cat_name":"@ctitle(2,5)",
//         }]
//     }]
// });



// //商品搜索(如果请求带有参数，就使用正则表达式，不能有双引号)
// Mock.mock(/\/web-service\/search/,"get",{
   
//         "count":"@integer(10,100)",
//         "data|10-30":[
//             {
//                 "id":"@id",
//                 "goods_name":"@ctitle(10)",
//                 "price":"@float(1,10000,1,2)",
//                 "img":"@dataImage(130x130)",
//                 "comment_count":"@integer(100,200)"
//             }
//         ]
     
// });

// //条件查询
// Mock.mock("/web-service/conditionSearch", "post", {
//     //品牌
//     'brand_list|10': [{
//         'id|+1': 1,
//         'brand_name': '@ctitle',
//         'logo': '@dataImage(60x20,thinkPad)',
//         'link': '@url(http)'
//     }],
//     //分类
//     'category_goods|4': [{
//         'id|+1': 1,
//         'category_name': '@ctitle',
//         'link': '@url(http)'
//     }],
//     //规格
//     'spec_list|3': [{
//         'id|+1': 1,
//         'spec_name': '@ctitle(2)',        
//         'options|4': [
//             {
//                 'id|+1': 1,
//                 'option_name': '@ctitle',
//                 'selected': false,
//             }
//         ]
//     }]

// });

// // 商品详情页（接口上有参数必须用正则）
// Mock.mock(/\/web-service\/goods\/\d+/,'get',{
//     'skuid':'@id',
//     'spuid':'@id',

//     'goods_name':'@ctitle(30,40)',
//     'price':'@float(100,300,0,2)',
//     'prices':'@float(100,300,0,2)',
//     //商品描述
//     'describe':'@ctitle(20,30)',
//     'on_sale_date':'@datetime',
//     'comment_count':'@integer(10,20000)',
//     'comment_level':'@integer(1,5)',
//     'cat1_info':{
//         'id':'@id',
//         'cat_name':"@ctitle"
//     },
//     'cat2_info':{
//         'id':'@id',
//         'cat_name':"@ctitle"
//     },
//     'cat3_info':{
//         'id':'@id',
//         'cat_name':"@ctitle"
//     },
//     'logo':{
//         'smlogo':'@dataImage(50x50)',
//         'biglogo':'@dataImage(350x350)',
//         'xbiglogo':'@dataImage(800x800)',
//     },
//     'photos|6-10':[
//         {
//             'smimg':'@dataImage(50x50)',
//             'bigimg':'@dataImage(350x350)',
//             'xbigimg':'@dataImage(800x800)',
//         }
//     ],
//     'description':'@ctitle(100,3000)',
//     'aftersale':'@ctitle(100,3000)',
//     'stock':"@integer(10,3000)",
//     'spec_list':[
//         {
//             'id':1,
//             "spec_name":"颜色",
//             "options":[
//                 {
//                     "id":1,
//                     "option_name":"白色"
//                 },
//                 {
//                     "id":2,
//                     "option_name":"黑色"
//                 }
//             ]
//         },
//         {
//             'id':2,
//             "spec_name":"尺寸",
//             "options":[
//                 {
//                     "id":6,
//                     "option_name":"S"
//                 },
//                 {
//                     "id":7,
//                     "option_name":"M"
//                 },
//                 {
//                     "id":8,
//                     "option_name":"L"
//                 },
//                 {
//                     "id":9,
//                     "option_name":"XL"
//                 }
//             ]
//         }
//     ],
//     'spec_info':{
//         'id_list':'1:2|2:8',
//         'id_txt':"颜色:黑色|尺寸:L"
//     },
//     'sku_list':[
//         {
//             'skuid':'@id',
//             'id_list':'1:2|2:6'
//         },
//         {
//             'skuid':'@id',
//             'id_list':'1:2|2:7'
//         },
//         {
//             'skuid':'@id',
//             'id_list':'1:2|2:8'
//         },
//         {
//             'skuid':'@id',
//             'id_list':'1:1|2:6'
//         },
//         {
//             'skuid':'@id',
//             'id_list':'1:1|2:7'
//         },
//         {
//             'skuid':'@id',
//             'id_list':'1:1|2:8'
//         },
//     ]
// });




// //模拟购物车
// Mock.mock("/cart-service/carts","get",{
//     "data|3-5":[
//         {
//         "skuid":"@id",
//         "goods_name":"@ctitle",
//         "price":"@float(100,200,0,2)",
//         "prices":"@float(200,400,0,2)",
//         "count":"@integer(1,5)",
//         "checked":"@boolean()",
//         "midlogo":"@dataImage(50x50)",
//         "spec_info":"颜色:黑色|尺寸:s"
//         }
   
//     ]
// });

// //添加购物车
// Mock.mock("/cart-service/carts","post",{
   
//         "errno":"@integer(0,1)",
//         "errmsg":"@cword(4)"
    
// });

// //修改购物车
// Mock.mock("/cart-service/carts","put",{
//     "errno":"@integer(0,1)",
//     "errmsg":"@cword(4)"
// });



// //订单商品信息
// Mock.mock("/order-service/orders","get",{
   
//         "skuid":"@id",
//         "goods_name":"@ctitle",
//         "price":"@float(100,200,0,2)",
//         "prices":"@float(200,400,0,2)",
//         "count":"@integer(1,5)",
//         "checked":"@boolean()",
//         "midlogo":"@dataImage(50x50)",
//         "spec_info":"颜色:黑色|尺寸:s"

// });


// //订单地址
// Mock.mock("/web-service/address","get",{
//     "data|4-6":[
//         {
//             "id":"@id",
//             "shr_name":"@cname",
//             "phone":/^[1][34578][0-9]{9}$/,
//             "shr_province":"@province",
//             "shr_city":"@city",
//             "shr_county":"@county",
//             "shr_address":"@ctitle(10,20)",
//             "shr_default":"@integer(0,1)"
//        }
//     ]
// });


// //添加地址
// Mock.mock("/web-service/address","post",{

//         "id":"@id",
//         "errno":"@integer(0,1)",
//         "errmsg":"@cword(4)"

// });


// //生成订单
// Mock.mock("/web-service/orders","post",{

//     "id":"@id",
//     "errno":"@integer(0,1)",
//     "errmsg":"@cword(4)"

// });

// //支付订单
// Mock.mock("/web-service/payOrders","post",{

    
//     "errno":"@integer(0,1)",
//     "errmsg":"@cword(4)",
//     "wxurl":"@url"
// });

// //付款
// Mock.mock(/\/order_status\/\d+/,"get",{

    
//     "errno":"@integer(0,1)",
//     "errmsg":"@cword(4)",
//     "pay_status":"@integer(0,1)"
// });


// //商品秒杀列表
// Mock.mock("/seckill/goods","get",{
//     'seckill_list|8-15':[{
//         'id|+1':1,
//         'goods_name':'@ctitle',
//         //原价
//         'price':'@float(100,200,1,2)',
//         //打折后的价格
//         'cost_price':'@float(50,100,1,2)',
//         //库存
//         'num':'200',
//         //剩余库存
//         'stock_count':'@integer(1,200)',
//         //秒杀图片
//         'pic':'@dataImage(130x130)',
//         //秒杀开始时间
//         'start_time':'@datetime',
//         //秒杀结束时间
//         'end_time':'@datetime',
//         'desc':'@ctitle'
//     }]

// });




