import Vue from 'vue'

import VueRouter from 'vue-router'
Vue.use(VueRouter)

export function ansurRouter () {
  return new VueRouter({
    mode: 'history',
    routes: [
      { path: '/', 
      component: () => import('./components/UserLogin.vue') },
      // { path: '/user-login', 
      // component: () => import('./components/UserLogin.vue') },
      // { path: '/user-signup', 
      // component: () => import('./components/UserSignup.vue') },
      // { path: '/user-guide', 
      // component: () => import('./components/UserGuide.vue') },
      { path: '/user-list',
       component: () => import('./components/UserList.vue') },
      // { path: '/user-home',
      // component: () => import('./components/UserHome.vue') },
      // { path: '/user-edit',
      // component: () => import('./components/UserEdit.vue') },
      
      { path: '/asset-form', 
      component: () => import('./components/AssetForm.vue') },
      { path: '/assets-list', 
      component: () => import('./components/AssetsList.vue') },
      // { path: '/item/:id', component: () => import('./components/Item.vue') }
    ]
  })
}