<template>
  <div id="UserHome">
		<el-col :span="12" :offset="6">
			<el-card>
				<h2 id="user-home-title"> ユーザー情報詳細</h2>
				<el-row id="gap-adjust">
					<el-col :span="6">
						Name: 
					</el-col>
					<el-col :span="18">
						{{ userForm.name }}
					</el-col>
				</el-row>
				<el-row id="gap-adjust">
					<el-col :span="6">
						Password: 
					</el-col>
					<el-col :span="18">
						{{ userForm.password }}
					</el-col>
				</el-row>
				<el-row id="gap-adjust">
					<el-col :span="6">
						Security Question: 
					</el-col>
					<el-col :span="18">
						{{ userForm.question }}
					</el-col>
				</el-row>
				<el-row id="gap-adjust">
					<el-col :span="6">
						Security Answer: 
					</el-col>
					<el-col :span="18">
						{{ userForm.answer }}
					</el-col>
				</el-row>
				<el-row id="gap-adjust">
					<el-col :span="6">
						Handle Devices: 
					</el-col>
					<el-col :span="18">
						<el-row v-for="hd in userForm.handleDevices"> {{ hd.name }} </el-row>
					</el-col>
				</el-row>

				<el-row style="text-align: right">
					<el-button type="primary" size="small" plain v-on:click="userEdit">
						編集
					</el-button>
				</el-row>

			</el-card>
		</el-col>

	</div>
</template>

<script>
export default {
  name: 'UserHome',
	data: function() {
		return {
			userForm: {
				name: 'akks',
				password: 'akks',
				question: 'What is your hobby?',
				answer: 'akks',
				handleDevices: [{
					name: 'HP Thinkpad',
		      category: 'Laptop'
				},{
					name: 'Lenovo',
		      category: 'Laptop'
				}]
			}
		}
	},
	methods: {
		userEdit() {
			this.$router.push({ path: '/user-edit'})
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
	#user-home-title {
		text-align: center;
		color: #2082e5;
	}
</style>


