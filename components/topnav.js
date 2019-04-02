


//导行条
Vue.component("topnav",{
    template:`
    <!-- 顶部导航 start -->
	<div class="topnav">
		<div class="topnav_bd w1210 bc">
			<div class="topnav_left">
				
			</div>
			<div class="topnav_right fr">
				<ul>
					<li v-if="name==null">[<a href="login.html">登录</a>] | [<a href="sign.html">免费注册</a>] </li>
                    <li v-else>{{name}}  </li>
					<li class="line">|</li>
					
					

				</ul>
			</div>
		</div>
	</div>
    `,
    data:function(){
        return {
            //从浏览器缓存中获得数据
            name:localStorage.getItem('name')
        }
    },
    methods:{
        //防止数据累加
        logout:function(){
            //清空localStorage中的数据
            localStorage.removeItem("token");
            localStorage.removeItem("name");
            //将本地存储的name清空
            this.name=null;
        }
    }
});