import Vue from 'vue'

import VueRouter from 'vue-router'
Vue.use(VueRouter)

export function ansurRouter () {
  return new VueRouter({
    mode: 'history',
    routes: [
      { path: '/', 
      component: () => import('./components/Index.vue') },
      { path: '/login', 
      component: () => import('./components/Login.vue') },
      { path: '/signup', 
      component: () => import('./components/Signup.vue') },
      { path: '/user-guide', 
      component: () => import('./components/UserGuide.vue') },
      { path: '/change-pswd', 
      component: () => import('./components/ChangePswd.vue') },
       { path: '/user-list', 
      component: () => import('./components/UserList.vue') },
       { path: '/add-item', 
      component: () => import('./components/AddItem.vue') },
      // { path: '/item/:id', component: () => import('./components/Item.vue') }
    ]
  })
}