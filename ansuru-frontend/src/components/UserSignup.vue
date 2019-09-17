<template>
  <div id="Login">
		<el-col :span="12" :offset="6">
			<el-card>
				<h2 id="signup-title"> 会員登録</h2>
				<el-form ref="loginForm" :model="loginForm">

				  <el-form-item label="名前" id="gap-adjust"></el-form-item>
				  <el-row v-if="!nameChecked">
				  	<el-col :span="21">
					  	<el-input v-model="loginForm.name"></el-input>
					  </el-col>
					  <el-col :span="2">
					  	<el-button v-on:click="checkName" type="success" plain>
					  		Check
					  	</el-button>
					  </el-col>
				  </el-row>
				  <el-row v-else>
				  	<el-input v-model="loginForm.name" :disabled="true"></el-input>
				  </el-row>

					<el-row :gutter="21">
						<el-col :span="12">
							<el-form-item label="パスワード" id="gap-adjust"></el-form-item>
							<el-input v-model="loginForm.password1"></el-input>
						</el-col>
						<el-col :span="12">
							<el-form-item label="パスワード（確認）" id="gap-adjust"></el-form-item>
							<el-input v-model="loginForm.password2"></el-input>
						</el-col>
					</el-row>	
					
				  <el-form-item label="セキュリティ質問" id="gap-adjust"></el-form-item>
					<template>
						<el-select v-model="loginForm.question" placeholder="質問選択してください" style="width: 100%;">
						<el-option
						  v-for="qq in loginForm.questions"
						  :key="qq.value"
						  :label="qq.label"
						  :value="qq.value">
						</el-option>
					  </el-select>
					</template>
				  <el-form-item label="セキュリティ答え" id="gap-adjust"></el-form-item>
					<el-input v-model="loginForm.answer"></el-input>

					<el-row id="gap-adjust">
						<el-radio-group v-model="loginForm.userType">
						  <el-radio :label="1">Normal User</el-radio>
						  <el-radio :label="2">Admin</el-radio>
						</el-radio-group>
					</el-row>

					<el-row id="text-center">
						<div id="gap-adjust">
							<el-button type="primary" v-on:click="userSignup">
								登録
							</el-button>
							<el-button type="danger" size="small" plain v-on:click="resetData">
							リセット
						</el-button>
						</div>
					</el-row>
				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
import axios from "axios";
export default {
  name: 'Login',
	data: function() {
		return {
			nameChecked: false,
			loginForm: {
				name: '',
				password1: '',
				password2: '',
				question: '',
				answer: '',
				userType: 1,
				questions: [{
					value: 'What is your birth month?',
					label: 'What is your birth month?'
				  }, {
					value: 'What is the career of your father?',
					label: 'What is the career of your father?'
				  }, {
					value: 'What is your company name?',
					label: 'What is your company name?'
				  }, {
					value: 'What is your position?',
					label: 'What is your position?'
				  }, {
					value: 'What is your hobby?',
					label: 'What is your hobby?'
			  }],
			},
		}
	},
	methods: {
		checkName() {
			this.nameChecked = true
		},
		userSignup() {
      console.log("user name:: " + this.loginForm.name)
			var userDts = {
        name: this.loginForm.name,
        password1: this.loginForm.password1,
        question: this.loginForm.question,
        answer: this.loginForm.answer,
        userType: this.loginForm.userType
      }
      console.log("raw user data :: " + userDts)
      userDts = JSON.stringify(userDts)
      console.log("raw user data json :: " + userDts)

      const uuid = require('uuid/v1');
      console.log("uuid:: " + uuid())
      let config = {
	      headers:{
	        'X-Requested-With': 'XMLHttpRequest',
	        'Content-Type':'application/x-www-form-urlencoded',
	        'traceno': uuid()
	      },
	      withCredentials:true,
	    }

      let url = "/signup"

      axios.post(url,userDts, config)
        .then(function(res){
          userDts = res.data
          console.log(res)
        })
        .catch(function(res){
          userDts = res.data
          console.log(res)
        })
		},
		resetData() {
			this.loginForm.name = ''
			this.loginForm.password1 = ''
			this.loginForm.password2 = ''
			this.loginForm.question = ''
			this.loginForm.answer = ''
			this.loginForm.userType = 1
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
	#signup-title {
		text-align: center;
		color: #2082e5;
	}
	.el-form-data {
		color: #000!important;
	}
</style>


