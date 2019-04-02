//导行条
Vue.component("seckill",{
    template:`
    <span class="overtime">
    <span v-if="simple">
        
        {{days!=0?(days+":"):""}}天
        {{hours!=0?(hours+":"):""}}时
        {{minutes!=0?(minutes+":"):""}}分
        {{secound}}秒
    </span>
    <span v-else>
        
        {{days}}天
        {{hours}}时
        {{minutes}}分
        {{secound}}秒
    </span>
    </span>
    `,
    data:function(){
        return {
           //总秒数
           mico:0,
           //定时器
           timer:'',
          
           //天数
           days:0,
           //时
           hours:0,
           //分
           minutes:0,
           //秒
           secound:0
        }
    },
    methods:{
        countDown:function(){
            //记时结束
            if(this.mico==0){
                window.clearInterval(this.timer);
                //4 回调：通知组件使用方
                this.$emit("stop")
            }else{
                //秒数递减
                this.mico--;
                //计算天，时，分，秒
                this.days=Math.floor(this.mico/(60*60*24));
                let temp=this.mico%(60*60*24);
                //小时
                this.hours=Math.floor(temp/(60*60));
                let temp2=temp%(60*60);
                //分钟
                this.minutes=Math.floor(temp2/60);
                //剩余秒数
                this.secound=temp2%60;
            }


           
            
           
        }
        
    },
    props : {
        'start' : {},           //开始时间
        'end' : {},             //结束时间
        'simple' : {            //是否显示简单版
            default : false         //默认false
        }
    },
    created:function(){
        //开始时间
        let startDate=new Date(this.start).getTime();
        
        //结束时间
        let endDate=new Date(this.end).getTime();
        
        // 获得需要的秒数
        this.mico=(endDate-startDate)/1000;
        
        //启动定时器
        this.countDown();
        this.timer = window.setInterval( this.countDown , 1 );

    }
});