<template>
  <div id="ChangePswd">
		<el-col :span="8" :offset="8">
			<el-card>
				<h2 id="text-center">パスワード編集</h2>
				<el-form ref="loginForm" :model="loginForm">

					<el-row>
						<el-form-item label="新しいパスワード" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.password1"></el-input>
					</el-row>
					<el-row v-if="!forgetPswd" >
						<el-form-item label="新しいパスワード（確認）" id="gap-adjust"></el-form-item>
						<el-input v-model="loginForm.password2"></el-input>
					</el-row>
					
					<el-row id="text-center">
						<div id="gap-adjust">
							<el-button type="success" size="small">編集する</el-button>
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
			forgetPswd: false,
			loginForm: {
				password1: '',
				password2: '',
			},
		}
	},
	methods: {
		
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
	.el-card {
		background-color: #e6fcb6!important;
	}
	.el-form-data {
		color: #000!important;
	}
</style>