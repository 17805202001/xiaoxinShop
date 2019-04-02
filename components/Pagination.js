Vue.component("pagination",{
    template: `
        <div class="page mt20">
            <a href="" v-if="page > 1" @click.prevent="pageClick(1)" >首页</a>
            <a href="" v-if="page > 1" @click.prevent="pageClick(page-1)" >上一页</a>
            <a href="" v-for="n in pageRange" @click.prevent="pageClick(n)" :class="{'cur': page == n}">{{n}}</a>
            <a href="" v-if="page < totalPage" @click.prevent="pageClick(page+1)" >下一页</a>
            <a href="" v-if="page < totalPage" @click.prevent="pageClick(totalPage)" >尾页</a>&nbsp;&nbsp; 
        </div>

        
    `,
    data : function(){
        return {
            page : 1,           //当前第几页
            totalPage : 0,      //总分页数
            goNum : 1           //跳转页面
        };
    },
    methods : {
        pageClick : function(n){
            //修改当前页
            this.page = parseInt(n);
            //通知调用，修改数据
            this.$emit('page_changed',n);
        }
    },
    computed : {    //计算属性
        pageRange : function(){
            //计算总分页数 -- 100/20 = 5   102/20 = 6
            if(this.total % this.page_size == 0) {
                //整除
                this.totalPage = this.total / this.page_size;
            } else {
                this.totalPage = parseInt(this.total / this.page_size) + 1;
            }
            //分页范围
            let star = Math.max(this.page-5,1)              //范围开始：得到一个 >=1 的数字
            let end = Math.min(this.page+4,this.totalPage)  //范围结束：得到一个 <=end 的数字
            let arr = []
            for(let i=star;i<=end;i++){
                arr.push(i)
            }
            return arr;
        }
    },
    props : ['total','page_size']       //总条数 , 每页显示个数


});