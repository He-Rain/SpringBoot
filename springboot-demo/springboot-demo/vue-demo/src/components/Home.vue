<template>
    <div id="bj2" style="text-align: center;height: 620px;padding: 0px;margin-top: 0px;">
        <el-descriptions style="margin-top:10px;padding-top: 80px; " title="个人中心" :column="2" size="40"  border>
            <el-descriptions-item >
                <template slot="label">
                    <i class="el-icon-s-custom" style="height: 60px;line-height: 60px"></i>
                    账号
                </template>
                {{user.no }}
            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-mobile-phone" ></i>
                    电话
                </template>
                {{user.phone}}
            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-location-outline" style="height: 60px;line-height: 60px"></i>
                    性别
                </template>
                <el-tag
                        :type="user.sex === '1' ? 'primary' : 'danger'"
                        disable-transitions><i :class="user.sex==1?'el-icon-male':'el-icon-female'"></i>{{user.sex==1?"男":"女"}}</el-tag>
            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-tickets" ></i>
                    角色
                </template>
                <el-tag
                        type="success"
                        disable-transitions>{{user.roleId==0?"超级管理员":(user.roleId==1?"管理员":"用户")}}</el-tag>

            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-info" style="height: 60px;line-height: 60px"></i>
                    昵称
                </template>
                <p >{{user.name}}</p>
            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-chat-line-square"></i>
                    座右铭
                </template>
                <p style="font-size: 20px">Let everyday life be full of hope</p>
            </el-descriptions-item>

            <el-descriptions-item>
                <template slot="label">
                    <i class="el-icon-date" style="height: 60px;line-height: 60px"></i>
                    日期
                </template>
                <DateUtils></DateUtils>
            </el-descriptions-item>

        </el-descriptions>


    </div>
</template>

<script>
    import DateUtils from "./DateUtils";
    export default {
        name: "Home",
        components: {DateUtils},
        data() {

            return {
                user:{}
            }
        },
        computed:{

        },
        methods:{
            init(){
                this.user = JSON.parse(sessionStorage.getItem('CurUser'))
            }
        },
        created(){
            this.init()
        }
    }
</script>

<style scoped>
    .el-descriptions{
        width:90%;
        margin: 0 auto;
        text-align: center;
        opacity: 0.9;
    }
    #bj2{

        background-color: #fff0e6;
        background-image: url("../assets/home.jpg");
        background-size: 100% 100%;
    }
</style>