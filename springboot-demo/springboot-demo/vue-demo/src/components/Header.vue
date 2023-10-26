<template>
    <div style="display: flex;line-height: 60px;">
        <div style="margin-top: 8px;">
            <i :class="icon" style="font-size: 20px;cursor: pointer;" @click="collapse"></i>
        </div>
        <div style="flex: 1;font-size: 30px;text-align: center ">
            <span style="color: #343434">xw仓库管理系统</span>
        </div>
        <el-dropdown>
            <div class="head_photo">
                <el-avatar src="https://pica.zhimg.com/v2-4112535d76401ea84b124d09defcfddd_r.jpg?source=1940ef5c" ></el-avatar>
            </div>
            <span id="self">{{user.name}}</span><i class="el-icon-arrow-down" style="margin-left: 5px;"></i>
            <el-dropdown-menu slot="dropdown">
                <el-dropdown-item @click.native="toUser">个人中心</el-dropdown-item>
                <el-dropdown-item @click.native="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>

    </div>
</template>

<script>
    export default {
        name: "Header",
        data(){
            return {
                user : JSON.parse(sessionStorage.getItem('CurUser'))
            }
        },
        props:{
            icon:String
        },
        methods:{
            toUser(){
                console.log('to_user')

                this.$router.push("/Home")
            },
            logout(){
                console.log('logout')

                this.$confirm('您确定要退出登录吗?', '提示', {
                    confirmButtonText: '确定',  //确认按钮的文字显示
                    type: 'warning',
                    center: true, //文字居中显示

                })
                    .then(() => {
                        this.$message({
                            type:'success',
                            message:'退出登录成功'
                        })

                        this.$router.push("/")
                        sessionStorage.clear()
                    })
                    .catch(() => {
                        this.$message({
                            type:'info',
                            message:'已取消退出登录'
                        })
                    })

            },
            collapse(){
                this.$emit('doCollapse')
            }

        },
        created(){
            this.$router.push("/Home")
        }

    }
</script>

<style scoped>

#self{
  color: #2d2d2d;
  cursor: pointer;
    font-size: 20px;
  font-family: kaiti;

}

    .head_photo{
        width: 40px;
        height: 40px;
        background-color:orange;
        margin-top: 10px;
        margin-right: 5px;
        float: left;
        border-radius:50% ;
    }
</style>