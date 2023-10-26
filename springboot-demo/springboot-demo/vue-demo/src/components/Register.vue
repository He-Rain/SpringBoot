<template>
  <div class="RegisterBody">
    <div class="RegisterDiv">
      <div class="Register-content">
        <h1 class="Register-title" style="margin-top: 20px">欢迎来到用户注册界面</h1>

        <el-form :model="RegisterForm" label-width="100px"
                 :rules="rules" ref="RegisterForm">

          <el-form-item label="手机号" prop="phone">
            <el-input style="width: 240px" type="text" v-model="RegisterForm.phone"
                      autocomplete="off" size="small" >
            </el-input>
          </el-form-item>

          <el-form-item label="用户名" prop="username">
          <el-input style="width: 240px" type="text" v-model="RegisterForm.username"
                    autocomplete="off" size="small">
          </el-input>
        </el-form-item>

          <el-form-item label="密码" prop="password">
            <el-input style="width: 240px" type="password" v-model="RegisterForm.password"
                      show-password autocomplete="off" size="small" @keyup.enter.native="confirm"></el-input>
          </el-form-item>


          <el-form-item>
<!--            <el-button id="register" style="margin-left: 100px" @click.native="toLogin">返回登录</el-button>-->
            <el-button type="primary" style="width:120px"  @click="submit">提交</el-button>
            <el-button type="success" style="width:80px;margin-left: 10px" @click="resetParam">重置</el-button>

          </el-form-item>

        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
    export default {
      name: "Register",
      data() {
        return {
          confirm_disabled: false,
          RegisterForm: {

            phone: '',
            username:'',
            password: ''
          },
          rules: {
            phone: [
              {required: true,message: "请输入你的电话号",trigger: "blur"},
              {pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/, message: "请输入正确的手机号码", trigger: "blur"}
            ],
            username:[
              {required: true, message: '请输入用户名', trigger: 'blur'}
            ],
            password: [
              {required: true, message: '请设置密码', trigger: 'blur'},
              {min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur'}
            ],
          }
        }
      },
      methods: {
        resetParam(){
              this.RegisterForm.username='',
              this.RegisterForm.phone='',
              this.RegisterForm.password=''
        },

        doSave(){
          this.$axios.post(this.$httpUrl+'/users/save',this.RegisterForm).then(res=>res.data).then(res=>{
            console.log(res)
            if(res.code==200){
              this.$message({
                message: '用户注册成功！',
                type: 'success',
              });
              this.$router.replace('/');//完成注册后跳转至登录页面
            }else{
              this.$message({
                message: '操作失败！',
                type: 'error'
              });
            }

          })
        },
        doMod(){
          this.$axios.post(this.$httpUrl+'/users/update',this.RegisterForm).then(res=>res.data).then(res=>{
            console.log(res)
            if(res.code==200){

              this.$message({
                message: '操作成功！',
                type: 'success'
              });
            }else{
              this.$message({
                message: '操作失败！',
                type: 'error'
              });
            }

          })
        },
        submit(){
          this.$refs.RegisterForm.validate((valid) => {
            if (valid) {
              if(this.RegisterForm.id){
                this.doMod();
              }else{
                 this.doSave();
              }
            } else {
              console.log('error submit!!');
              return false;
            }
          });

        },

      }
    }
</script>

<style scoped>
.RegisterBody {
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url("../assets/register.jpg");
  background-size: 100% 100%;

}
.RegisterDiv {
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: -220px;
  margin-left: -250px;
  width: 450px;
  height: 420px;
  background: #fff;
  border-radius: 5%;
  opacity: 0.9;

}
.Register-title {
  margin: 30px 0;
  text-align: center;
}
.Register-content {
  width: 400px;
  height: 250px;
  position: absolute;
  top: 25px;
  left: 25px;
}
#register:hover{
  cursor: pointer;
}

</style>