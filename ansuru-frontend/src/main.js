import Vue from 'vue'
import App from './App.vue'
  
import { ansurRouter } from './router.js'
import { vuexStore } from './store.js'

import ElementUI from 'element-ui'
// import locale from 'element-ui/lib/locale/lang/ja'
import 'element-ui/lib/theme-chalk/index.css'
// Vue.use(ElementUI, {locale})
Vue.use(ElementUI)

Vue.config.productionTip = false

const router = new ansurRouter()
// const ctxStore = new vuexStore

new Vue({
	router,
	vuexStore,
  render: h => h(App),
}).$mount('#ansur')