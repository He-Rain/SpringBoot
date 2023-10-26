<template>
    <div class="loginBody">
        <div class="loginDiv">
            <div class="login-content">
                <h1 class="login-title" style="margin-top: 20px">仓库后台登录界面</h1>
                <el-form :model="loginForm" label-width="100px"
                         :rules="rules" ref="loginForm">
                    <el-form-item label="账号" prop="no">
                        <el-input style="width: 200px" type="text" v-model="loginForm.no"
                                  autocomplete="off" size="small">

                        </el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input style="width: 200px" type="password" v-model="loginForm.password"
                                  show-password autocomplete="off" size="small" @keyup.enter.native="confirm"></el-input>
                    </el-form-item>
                    <span style="margin-left: 100px">
                    <el-radio-group v-model="radio">

                    <el-radio :label="3">超级管理员</el-radio>
                    <el-radio :label="6">管理员</el-radio><br>
                    <el-radio :label="9" style="margin-top: 15px">用户</el-radio>
                    </el-radio-group>
                    </span>
                    <br><br>
                    <el-form-item>
                        <el-button type="primary" @click="confirm" :disabled="confirm_disabled"
                        style="width: 100px;margin-top:12px ">
                            登录
                        </el-button>
                      <el-button id="register" style="margin-left: 10px" @click.native="toRegister">用户注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
</template>


<script>
    export default {
        name: "Login",
        data(){

            return{
                radio:3,
                confirm_disabled:false,
                loginForm:{
                    no:'',
                    password:''
                },
                rules:{
                    no: [
                        { required: true, message: '请输入账号', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输密码', trigger: 'blur' }
                    ],
                }
            }
        },
        methods:{
           toRegister(){
             this.$router.push("/Register")
           },
            confirm(){
                this.confirm_disabled=true;
                this.$refs.loginForm.validate((valid) => {
                    if (valid) { //valid成功为true，失败为false
                        //去后台验证用户名密码
                        this.$axios.post(this.$httpUrl+'/user/login',this.loginForm).then(res=>res.data).then(res=>{
                            console.log(res)
                            if(res.code==200){
                                //存储
                                sessionStorage.setItem("CurUser",JSON.stringify(res.data.user))

                                console.log(res.data.menu)
                                this.$store.commit("setMenu",res.data.menu)
                                //跳转到主页
                                this.$router.replace('/Index');
                            }else{
                                this.confirm_disabled=false;
                                alert('校验失败，用户名或密码错误！');
                                return false;
                            }
                        });
                    } else {
                        this.confirm_disabled=false;
                        console.log('校验失败');
                        return false;
                    }
                });

            }
        }
    }
</script>

<style scoped>
    .loginBody {
        position: absolute;
        width: 100%;
        height: 100%;
        background-image: url("../assets/bj.jpg");
        background-size:100% 100%;

    }
    .loginDiv {
        position: absolute;
        top: 50%;
        left: 50%;
        margin-top: -200px;
        margin-left: -250px;
        width: 450px;
        height: 400px;
        background: #fff;
        border-radius: 5%;

    }
    .login-title {
        margin: 30px 0;
        text-align: center;
    }
    .login-content {
        width: 400px;
        height: 280px;
        position: absolute;
        top: 25px;
        left: 25px;
    }
    #register:hover{
      cursor: pointer;
    }
    #register{
      border:1px solid white;
    }
</style>