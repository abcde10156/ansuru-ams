import Vue from 'vue'
import App from './App.vue'
  
import { ansurRouter } from './router.js'
import { vuexStore } from './store.js'

import ElementUI from 'element-ui'
import locale from 'element-ui/lib/locale/lang/en'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI, {locale})
// Vue.use(ElementUI)

Vue.config.productionTip = false

const router = new ansurRouter()
const store = new vuexStore

new Vue({
	router,
	store,
  render: h => h(App),
}).$mount('#ansur')

