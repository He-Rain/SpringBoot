
import VueRouter from 'vue-router';


const routes = [
  {path:'/', name:'login', component:()=>import('../components/Login')},
  {path:'/Register', name:'register', component:()=>import('../components/Register')},
  {path:'/Index', name:'index', meta:{}, component:()=>import('../components/Index'),
    children:[
      {path:'/Home', name:'home', meta:{title:'首页'}, component:()=>import('../components/Home')},
      {path:'/Admin', name:'admin', meta:{title:'管理员管理'}, component:()=>import('../components/admin/AdminManage.vue')},
      {path:'/User', name:'user', meta:{title:'用户管理'}, component:()=>import('../components/user/UserManage.vue')},
      {path:'/Storage', name:'storage', meta:{title:'仓库管理'}, component:()=>import('../components/storage/StorageManage')},
      {path:'/Goodstype', name:'goodstype', meta:{title:'物品分类管理'}, component:()=>import('../components/goodstype/GoodstypeManage')},
      {path:'/Goods', name:'goods', meta:{title:'物品管理'}, component:()=>import('../components/goods/GoodsManage')},
      {path:'/Record', name:'record', meta:{title:'记录管理'}, component:()=>import('../components/record/RecordManage')},
    ]
  }
]

//在现做项目中，由于公司需要求vue-router模式需要更改为 history模式，发现二级路由刷新直接白屏
// 打开控制台发现报错
const router = new VueRouter({
  mode:'history',
  routes
})

export function resetRouter() {
  router.matcher = new VueRouter({
    mode:'history',
    routes: []
  }).matcher
}




const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
  return VueRouterPush.call(this, to).catch(err => err)

}

//路由配置如下，在这里自定义了一个对象的参数meta: {authRequired: true}
// 来标记哪些路由是需要登录验证的，导航被触发的时候只要判断是否目标路由中
// 是否有meta这个对象，且meta包含authRequired属性，其值为true。这里访问
// 带有meta对象的路由是被拦截的。




export  default router;
