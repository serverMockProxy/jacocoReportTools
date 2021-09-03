import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import componentsRouter from './modules/components'
import chartsRouter from './modules/charts'
import tableRouter from './modules/table'
import nestedRouter from './modules/nested'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/pages/dashboard/index'),
        name: 'Dashboard',
        meta: { title: '仪表板', icon: 'dashboard', affix: true }
      }
    ]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/tools',
    component: Layout,
    children: [
      {
        path: 'list',
        component: () => import('@/pages/tools/list'),
        name: 'ToolsList',
        meta: {title: '小工具', icon: 'guide', noCache: true}
      },
      {
        path: 'demo',
        component: () => import('@/pages/tools/demo/demo'),
        name: 'demo',
        meta: {title: 'demo', noCache: false},
        hidden: true
      },
    ]
  },
  {
    path: '/mock',
    component: Layout,
    meta: {title: 'mock配置', icon: 'mock'},
    children: [
      {
        path: 'config/add',
        component: () => import('@/pages/mock/config/add'),
        name: 'AddConfig',
        meta: {title: '添加配置', noCache: false},
        hidden: true
      },
      {
        path: 'config/update/:configId',
        component: () => import('@/pages/mock/config/update'),
        name: 'UpdateConfig',
        meta: {title: '更新配置', noCache: false},
        hidden: true
      },
      {
        path: 'config/list',
        component: () => import('@/pages/mock/config/list'),
        name: 'ConfigList',
        meta: {title: '配置', icon: 'env', noCache: true}
      },
      {
        path: 'details/list',
        component: () => import('@/pages/mock/details/list'),
        name: 'DetailsList',
        meta: {title: '拦截详情', icon: 'environment', noCache: true}
      }
    ]
  },
  {
    path: '/jacoco',
    component: Layout,
    redirect: '/jacoco',
    meta: { title: 'Jacoco', icon: 'jacoco'},
    children: [
      {
        path: 'config',
        component: () => import('@/pages/jacoco/config'),
        name: 'config',
        meta: { title: 'jacoco配置', icon: 'gitlab', noCache: true }
      },
      {
        path: 'report',
        component: () => import('@/pages/jacoco/report/list'),
        name: 'jacocoReport',
        meta: { title: 'jacoco报告', icon: 'report', noCache: true }
      }
    ]
  },
  {
    path: '/system',
    component: Layout,
    meta: { title: '系统管理', icon: 'setting'},
    children: [
      {
        path: 'user/add',
        component: () => import('@/pages/user/add'),
        name: 'AddUser',
        meta: { title: '添加用户', noCache: false, roles: ['admin']},
        hidden: true
      },
      {
        path: 'user/update/:userId',
        component: () => import('@/pages/user/update'),
        name: 'UpdateUser',
        meta: { title: '更新用户', noCache: false, roles: ['admin']},
        hidden: true
      },
      {
        path: 'user/list',
        component: () => import('@/pages/user/list'),
        name: 'UserList',
        meta: { title: '用户', icon: 'user', noCache: true, roles: ['admin']}
      },
      {
        path: 'project/add',
        component: () => import('@/pages/project/add'),
        name: 'AddProject',
        meta: { title: '添加项目', noCache: false, roles: ['admin']},
        hidden: true
      },
      {
        path: 'project/update/:projectId',
        component: () => import('@/pages/project/update'),
        name: 'UpdateProject',
        meta: { title: '更新项目', noCache: false, roles: ['admin']},
        hidden: true
      },
      {
        path: 'project/list',
        component: () => import('@/pages/project/list'),
        name: 'ProjectList',
        meta: { title: '项目', icon: 'project', noCache: true, roles: ['admin']}
      }
    ]
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
