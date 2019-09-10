<template>
  <div id="Signup">
		<el-col :span="8" :offset="8">
			<el-card>
				<h2 id="login-title"> ログイン</h2>
				<el-form ref="loginForm" :model="loginForm">

					<el-row>
						<el-form-item label="名前" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.name"></el-input>
					</el-row>
					<el-row v-if="!forgetPswd" >
						<el-form-item label="パスワード" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.password"></el-input>
					</el-row>
					
					<el-row v-if="!forgetPswd" id="text-center">
						<div id="gap-adjust">
							<el-button type="primary" size="small">ログイン</el-button>
						</div>
					</el-row>

					<el-row v-if="!forgetPswd" id="gap-adjust">
						<a href="#" @click.prevent="forgetPassword">パスワード忘れた方はこちら</a>
					</el-row>

					<div v-else id="gap-adjust">
						<h4>下の質問答えてください！</h4>
						<el-row id="gap-adjust">{{ loginForm.question }}</el-row>
						<el-form-item label="セキュリティ答え" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.answer"></el-input>
						<el-row id="text-center">
							<div id="gap-adjust">
								<el-button type="danger" size="small" plain v-on:click="backBtn">戻る</el-button>
								<el-button type="primary" size="small">パスワード編集</el-button>
							</div>
						</el-row>

					</div>


				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
export default {
  name: 'Signup',
	data:function() {
		return {
			forgetPswd: false,
			loginForm: {
				name: '',
				password: '',
				question: 'Question 1',
				answer: '',
			},
		}	
	},
	methods: {
		forgetPassword() {
			this.forgetPswd = true
		},
		backBtn() {
			this.forgetPswd = false
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