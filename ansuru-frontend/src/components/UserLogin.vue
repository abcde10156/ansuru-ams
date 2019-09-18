<template>
  <div id="UserLogin">
		<el-col :span="8" :offset="8">
			<el-card>
				<h2 id="login-title"> ログイン</h2>
				<el-form :model="loginForm" ref="loginForm" :rules="rules">

					<el-row>
						<el-form-item label="User Name" id="gap-adjust" prop="name">
							<el-input v-model="loginForm.name"></el-input>
						</el-form-item>
					</el-row>
					<el-row>
						<el-form-item label="Password" name="password" prop="password" id="gap-adjust">
							<el-input v-model="loginForm.password"></el-input>
						</el-form-item>
					</el-row>

					<el-row id="gap-adjust">
						<el-col :span="6">
							<el-form-item label="Login Type"></el-form-item>
						</el-col>
						<el-col :span="18">
							<el-form-item prop="loginType">
								<el-select 
									v-model="loginForm.loginType"
									placeholder="Login Type"
									style="width: 100%;"
									@change="selectedUType">
									<el-option
									  v-for="utype in loginForm.loginTypes"
									  :key="utype.value"
									  :label="utype.label"
									  :value="utype.value">
									</el-option>
							  </el-select>
							</el-form-item>
						</el-col>
					</el-row>
					
					<el-row id="text-center">
						<div id="gap-adjust">
							<el-button type="primary" size="small" v-on:click="userLogin('loginForm')">ログイン</el-button>
						</div>
					</el-row>

				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
// import { mapState } from 'vuex'
export default {
  name: 'UserLogin',
	data:function() {
		return {
			adminLogin: '',
			loginForm: {
				name: '',
				password: '',
				loginType: '',
				loginTypes: [{
					value: 1,
					label: 'Admin',
				},{
					value: 2,
					label: 'General',
				}]
			},
			rules: {
				name: [
	        { required: true, message: 'Please input Username', trigger: 'blur' },
	        { min: 2, max: 50, message: 'Username should be at least 2, at most 50 characters', trigger: 'blur' }
	      ],
	      password: [
	        { required: true, message: 'Please input Password', trigger: 'blur' },
	        { min: 2, max: 50, message: 'Password should be at least 2, at most 50 characters', trigger: 'blur' }
	      ],
	      loginType: [
	        { required: true, message: 'Please select loginType', trigger: 'blur' },
	      ],
			}
		}	
	},
	mounted() {
		// console.log("UserLogin loginType ::" + this.$store.state.loginType)
		console.log("UserLogin adminLogin ::" + this.$store.state.adminLogin)
	},
	// computed:{
 //   ...mapState(['loginType'])
 //   // Now you can read the name by using this.name
 //  },
	methods: {
		selectedUType() {
			console.log("selectedUType::: " + this.loginForm.loginType)
		},
		userLogin(formName) {
			this.$refs[formName].validate((valid) => {
        if (valid) {
        	// call api & check username & password
        	if ( this.loginForm.loginType == 1 ) {
        		this.$store.state.loginStatus = true
        		this.$store.state.adminLogin = true
        	} else {
        		this.$store.state.loginStatus = true
        		this.$store.state.adminLogin = false
        	}
					this.$router.push({path: '/assets-list'})
        } else {
          console.log('error submit!!');
          return false;
        }
      });
		}
	},
}
</script>


<style scoped>
	#gap-adjust {
		margin-bottom: 0px;
		margin-top: 20px;
	}
	#text-center {
		text-align: center;
	}
	#login-title {
		text-align: center;
		color: #2082e5;
	}
	a {
		text-decoration: none;
	}
	.el-form-data {
		color: #000!important;
	}
</style>