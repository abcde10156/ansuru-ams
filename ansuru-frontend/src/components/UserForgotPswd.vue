<template>
  <div id="Signup">
		<el-col :span="8" :offset="8">
			<el-card>
				<h2 id="forgot-pswd-title"> 本人確認</h2>
				<el-form ref="loginForm" :model="loginForm">

					<el-row v-if="!showQues">
						<el-form-item label="名前" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.name"></el-input>
					</el-row>

					<el-row v-if="showQues" id="text-center">
						We found your account!
						<br>
						<span id="forgot-pswd-title">{{ loginForm.name }}</span>
					</el-row>

					<el-row v-if="nameIncorrect" id="input-error">
						Your account is not registered yet!
					</el-row>
					
					<el-row v-if="!showQues" id="text-center">
						<div id="gap-adjust">
							<el-button type="primary" size="small" v-on:click="SearchAccount">アカウント検索</el-button>
						</div>
					</el-row>


					<div v-if="showQues" id="gap-adjust">
						<!-- <h4>下の質問答えてください！</h4> -->
						<el-row id="gap-adjust">
							<el-tag> {{ loginForm.question }} </el-tag>
						</el-row>
						<!-- <el-form-item label="セキュリティ答え" id="gap-adjust"></el-form-item> -->
						<el-input v-model="loginForm.answer" placeholder="上のセキュリティ質問を答えてください！"></el-input>

						<el-row v-if="answerIncorrect" id="input-error">
							The answer is not incorrect!
						</el-row>

						<el-row id="text-center">
							<div id="gap-adjust">
								<el-button type="danger" size="small" plain v-on:click="backBtn">戻る</el-button>
								<el-button type="primary" size="small"v-on:click="changePswd">パスワード編集</el-button>
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
			showQues: false,
			nameIncorrect: false,
			answerIncorrect: false,
			loginForm: {
				name: '',
				question: '',
				answer: '',
			},
		}	
	},
	methods: {
		SearchAccount() {
			// if the account is occured, the system will show security question
			// retrieve user data from database
			this.loginForm.question = 'Question 1'
			this.showQues = true
			this.nameIncorrect = false

			// if the account is not occured, alert error
			// this.nameIncorrect = true
		},
		backBtn() {
			this.$router.push({path: '/user-login'})
		},
		changePswd() {
			// if the answer is correct
			this.answerIncorrect = false
			this.$router.push({path: '/user-change-pswd'})

			// if the answer is not incorrect
			// this.answerIncorrect = true
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
	#forgot-pswd-title {
		text-align: center;
		color: #2082e5;
	}
	a {
		text-decoration: none;
	}
	.el-form-data {
		color: #000!important;
	}
	#input-error {
		padding-top: 20px;
		text-align: center;
		color: red;
	}
</style>