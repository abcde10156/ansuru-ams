import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export function vuexStore () {
	return new Vuex.Store({
	  state: {
	    // loginType: '',
	    loginStatus: false,
	    adminLogin: false,
	    assetFormMode: 'add',
	    assetCode: '',
	    assetName: '',
	    classification: '',
	    condition: '',
	    pic: '',
	    starts: '',
	    ends: '',
	  },
	  mutations: {
	    
	  }
	})
} 