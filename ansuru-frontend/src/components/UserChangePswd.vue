<template>
  <div id="ChangePswd">
		<el-col :span="8" :offset="8">
			<el-card>
				<h2 id="change-pswd-title">パスワード編集</h2>
				<el-form ref="pswdForm" :model="pswdForm">

					<el-row>
						<el-form-item label="新しいパスワード" id="gap-adjust"></el-form-item>
						<el-input v-model="pswdForm.password1"></el-input>
					</el-row>
					<el-row>
						<el-form-item label="新しいパスワード（確認）" id="gap-adjust"></el-form-item>
						<el-input v-model="pswdForm.password2"></el-input>
					</el-row>

					<el-row v-if="pswdError" id="input-error">
						Two passwords must be the same!
					</el-row>
					
					<el-row id="text-center">
						<div id="gap-adjust">
							<el-button type="success" size="small" v-on:click="changePswd">編集する</el-button>
						</div>
					</el-row>

				</el-form>
			</el-card>
		</el-col>

	</div>
</template>

<script>
export default {
  name: 'ChangePswd',
	data: function() {
		return {
			pswdError: false,
			pswdForm: {
				password1: '',
				password2: '',
			},
		}
	},
	methods: {
		changePswd() {
			if (this.pswdForm.password1 == this.pswdForm.password2) {
				this.pswdError = false
				this.$router.push({path: '/user-login'})
			} else {
				this.pswdError = true
			}
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
	#change-pswd-title {
		text-align: center;
		color: #2082e5;
	}
	#input-error {
		padding-top: 20px;
		text-align: center;
		color: red;
	}
</style>